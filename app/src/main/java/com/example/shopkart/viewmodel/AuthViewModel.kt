package com.example.shopkart.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopkart.data.preferences.UserPreferences
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val auth = FirebaseAuth.getInstance()
    private val userPreferences = UserPreferences(application)

    private val _user = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val user: StateFlow<FirebaseUser?> = _user

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getGoogleSignInClient(context: Context, webClientId: String): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(webClientId)
            .requestEmail()
            .requestProfile()
            .build()
        return GoogleSignIn.getClient(context, gso)
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        _isLoading.value = true
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser
                    _user.value = firebaseUser
                    // Saving user info locally
                    viewModelScope.launch {
                        userPreferences.saveUserInfo(
                            name = firebaseUser?.displayName ?: "",
                            email = firebaseUser?.email ?: "",
                            photoUrl = firebaseUser?.photoUrl?.toString() ?: ""
                        )
                    }
                } else {
                    _errorMessage.value = task.exception?.message ?: "Sign-in failed"
                }
                _isLoading.value = false
            }
    }

    fun signOut(context: Context, webClientId: String) {
        auth.signOut()
        getGoogleSignInClient(context, webClientId).signOut()
        _user.value = null
        viewModelScope.launch {
            userPreferences.clearUserInfo()
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}