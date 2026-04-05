package com.example.shopkart.ui.screens

import android.Manifest
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopkart.viewmodel.AuthViewModel
import com.example.shopkart.viewmodel.HomeViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices


const val PLACES_API_KEY = "NOT_REQUIRED_USING_MOCK_DATA"

@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    authViewModel: AuthViewModel,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    val context = LocalContext.current
    val searchQuery by homeViewModel.searchQuery.collectAsState()
    val recentSearches by homeViewModel.recentSearches.collectAsState()
    val bannerText by homeViewModel.bannerText.collectAsState()
    val featuredCategory by homeViewModel.featuredCategory.collectAsState()
    val user by authViewModel.user.collectAsState()


    val locationPermission = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)


    LaunchedEffect(locationPermission.status.isGranted) {
        if (locationPermission.status.isGranted) {
            val fusedClient = LocationServices.getFusedLocationProviderClient(context)
            fusedClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    homeViewModel.updateLocation(it.latitude, it.longitude)
                }
            }
        } else {
            locationPermission.launchPermissionRequest()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ShopKart",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                    IconButton(onClick = {
                        authViewModel.signOut(context, WEB_CLIENT_ID)
                        onLogoutClick()
                    }) {
                        Icon(Icons.Default.Logout, contentDescription = "Logout")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Campaign,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = bannerText,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    }
                }
            }


            item {
                Text(
                    text = "Hello, ${user?.displayName?.split(" ")?.firstOrNull() ?: "there"} 👋",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }


            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { homeViewModel.onSearchQueryChange(it) },
                    placeholder = { Text("Search for stores or products...") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null)
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { homeViewModel.onSearchQueryChange("") }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Search
                    ),
                    keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                        onSearch = {
                            if (searchQuery.isNotEmpty()) {
                                homeViewModel.searchStores(PLACES_API_KEY)
                                onSearchClick()
                            }
                        }
                    )
                )
            }


            item {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        if (searchQuery.isNotEmpty()) {
                            homeViewModel.searchStores(PLACES_API_KEY)
                            onSearchClick()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(16.dp),
                    enabled = searchQuery.isNotEmpty()
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Find Nearby Stores", fontSize = 16.sp)
                }
            }


            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Featured: ",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    SuggestionChip(
                        onClick = {
                            homeViewModel.onSearchQueryChange(featuredCategory)
                            homeViewModel.searchStores(PLACES_API_KEY)
                            onSearchClick()
                        },
                        label = { Text(featuredCategory) },
                        icon = {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    )
                }
            }


            if (recentSearches.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Recent Searches",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                items(recentSearches.take(3)) { search ->
                    ListItem(
                        headlineContent = { Text(search.query) },
                        leadingContent = {
                            Icon(
                                Icons.Default.History,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        trailingContent = {
                            Icon(
                                Icons.Default.NorthWest,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .then(
                                Modifier.padding(0.dp)
                            ),
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                    )
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }


            if (!locationPermission.status.isGranted) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "📍 Location Required",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Please grant location permission to find nearby stores.",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            TextButton(onClick = { locationPermission.launchPermissionRequest() }) {
                                Text("Grant Permission")
                            }
                        }
                    }
                }
            }
        }
    }
}