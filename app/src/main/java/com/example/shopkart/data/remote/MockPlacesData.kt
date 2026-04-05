package com.example.shopkart.data.remote

object MockPlacesData {

    private val electronicsStores = listOf(
        PlaceResult(
            placeId = "mock_e1",
            name = "Croma - Electronic City",
            vicinity = "Neeladri Road, Electronic City Phase 1, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8472, 77.6734),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1243
        ),
        PlaceResult(
            placeId = "mock_e2",
            name = "Sangeetha Mobiles - EC Phase 2",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8441, 77.6798),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        ),
        PlaceResult(
            placeId = "mock_e3",
            name = "Poorvika Mobiles - Hebbagodi",
            vicinity = "Hebbagodi Main Road, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8389, 77.6845),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 432
        ),
        PlaceResult(
            placeId = "mock_e4",
            name = "Reliance Digital - Neeladri",
            vicinity = "Neeladri Road, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8501, 77.6756),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 876
        ),
        PlaceResult(
            placeId = "mock_e5",
            name = "Unicorn Computers - EC",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8455, 77.6763),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 312
        ),
        PlaceResult(
            placeId = "mock_e6",
            name = "Samsung Service Center - EC",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 3.9,
            location = PlaceLocation(12.8423, 77.6812),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = false),
            userRatingsTotal = 567
        ),
        PlaceResult(
            placeId = "mock_e7",
            name = "iZone Apple Reseller - EC",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.4,
            location = PlaceLocation(12.8467, 77.6831),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 445
        ),
        PlaceResult(
            placeId = "mock_e8",
            name = "Laptop World - Hosa Road",
            vicinity = "Hosa Road, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8523, 77.6878),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 234
        ),
        PlaceResult(
            placeId = "mock_e9",
            name = "Jio Point - Hebbagodi",
            vicinity = "Hebbagodi, Bangalore",
            rating = 3.8,
            location = PlaceLocation(12.8401, 77.6856),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 198
        ),
        PlaceResult(
            placeId = "mock_e10",
            name = "HP World - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8478, 77.6712),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 321
        )
    )

    private val groceryStores = listOf(
        PlaceResult(
            placeId = "mock_g1",
            name = "DMart - Electronic City",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.4,
            location = PlaceLocation(12.8449, 77.6741),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 3456
        ),
        PlaceResult(
            placeId = "mock_g2",
            name = "More Supermarket - EC Phase 2",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8435, 77.6823),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 876
        ),
        PlaceResult(
            placeId = "mock_g3",
            name = "Namdhari's Fresh - Neeladri",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8489, 77.6767),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        ),
        PlaceResult(
            placeId = "mock_g4",
            name = "Nilgiris Supermarket - EC",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8462, 77.6798),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 543
        ),
        PlaceResult(
            placeId = "mock_g5",
            name = "BigBasket Now - Hebbagodi",
            vicinity = "Hebbagodi Main Road, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8378, 77.6856),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 765
        ),
        PlaceResult(
            placeId = "mock_g6",
            name = "Foodworld - Hosa Road",
            vicinity = "Hosa Road, Bangalore",
            rating = 3.9,
            location = PlaceLocation(12.8512, 77.6867),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = false),
            userRatingsTotal = 432
        ),
        PlaceResult(
            placeId = "mock_g7",
            name = "Spar - Begur Road",
            vicinity = "Begur Road, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8534, 77.6712),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 987
        ),
        PlaceResult(
            placeId = "mock_g8",
            name = "Lulu Hypermarket - EC Phase 2",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8412, 77.6778),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1234
        )
    )

    private val fashionStores = listOf(
        PlaceResult(
            placeId = "mock_f1",
            name = "Max Fashion - EC",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8456, 77.6745),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 876
        ),
        PlaceResult(
            placeId = "mock_f2",
            name = "V-Mart Fashion - Neeladri",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 3.9,
            location = PlaceLocation(12.8478, 77.6801),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 543
        ),
        PlaceResult(
            placeId = "mock_f3",
            name = "Pantaloons - Hebbagodi",
            vicinity = "Hebbagodi, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8367, 77.6834),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1234
        ),
        PlaceResult(
            placeId = "mock_f4",
            name = "Levi's Outlet - EC Phase 2",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8445, 77.6823),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        ),
        PlaceResult(
            placeId = "mock_f5",
            name = "Manyavar - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8501, 77.6756),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = false),
            userRatingsTotal = 432
        ),
        PlaceResult(
            placeId = "mock_f6",
            name = "Allen Solly - Hosa Road",
            vicinity = "Hosa Road, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8523, 77.6845),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 345
        ),
        PlaceResult(
            placeId = "mock_f7",
            name = "Fabindia - Begur Road",
            vicinity = "Begur Road, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8545, 77.6723),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 567
        ),
        PlaceResult(
            placeId = "mock_f8",
            name = "Westside - EC Mall",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8467, 77.6712),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 765
        )
    )

    private val shoeStores = listOf(
        PlaceResult(
            placeId = "mock_s1",
            name = "Bata - Electronic City",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8451, 77.6752),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 765
        ),
        PlaceResult(
            placeId = "mock_s2",
            name = "Nike Outlet - EC Phase 2",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.4,
            location = PlaceLocation(12.8438, 77.6834),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 987
        ),
        PlaceResult(
            placeId = "mock_s3",
            name = "Metro Shoes - Neeladri",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8489, 77.6778),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 543
        ),
        PlaceResult(
            placeId = "mock_s4",
            name = "Puma Store - Hebbagodi",
            vicinity = "Hebbagodi, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8378, 77.6845),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 432
        ),
        PlaceResult(
            placeId = "mock_s5",
            name = "Woodland - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8467, 77.6723),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = false),
            userRatingsTotal = 321
        ),
        PlaceResult(
            placeId = "mock_s6",
            name = "Adidas Outlet - Hosa Road",
            vicinity = "Hosa Road, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8512, 77.6856),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        )
    )

    private val foodStores = listOf(
        PlaceResult(
            placeId = "mock_fd1",
            name = "McDonald's - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8458, 77.6748),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 2345
        ),
        PlaceResult(
            placeId = "mock_fd2",
            name = "Domino's Pizza - Neeladri Road",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8478, 77.6812),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1876
        ),
        PlaceResult(
            placeId = "mock_fd3",
            name = "KFC - Electronic City",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8445, 77.6834),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1543
        ),
        PlaceResult(
            placeId = "mock_fd4",
            name = "Subway - Hosa Road",
            vicinity = "Hosa Road, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8523, 77.6867),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 987
        ),
        PlaceResult(
            placeId = "mock_fd5",
            name = "Burger King - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8467, 77.6756),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1234
        ),
        PlaceResult(
            placeId = "mock_fd6",
            name = "Pizza Hut - Hebbagodi",
            vicinity = "Hebbagodi, Bangalore",
            rating = 3.9,
            location = PlaceLocation(12.8389, 77.6845),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = false),
            userRatingsTotal = 876
        ),
        PlaceResult(
            placeId = "mock_fd7",
            name = "Cafe Coffee Day - EC",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8501, 77.6734),
            types = listOf("cafe", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        ),
        PlaceResult(
            placeId = "mock_fd8",
            name = "Starbucks - Neeladri Road",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8489, 77.6789),
            types = listOf("cafe", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1123
        )
    )

    private val accessoriesStores = listOf(
        PlaceResult(
            placeId = "mock_a1",
            name = "Titan World - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.3,
            location = PlaceLocation(12.8462, 77.6756),
            types = listOf("jewelry_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 876
        ),
        PlaceResult(
            placeId = "mock_a2",
            name = "Tanishq - Neeladri Road",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.5,
            location = PlaceLocation(12.8489, 77.6812),
            types = listOf("jewelry_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1234
        ),
        PlaceResult(
            placeId = "mock_a3",
            name = "Nykaa Beauty - EC",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8434, 77.6823),
            types = listOf("beauty_salon", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        ),
        PlaceResult(
            placeId = "mock_a4",
            name = "Fossil Store - EC Mall",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.4,
            location = PlaceLocation(12.8445, 77.6712),
            types = listOf("jewelry_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 432
        ),
        PlaceResult(
            placeId = "mock_a5",
            name = "Sunglass Hut - Hebbagodi",
            vicinity = "Hebbagodi, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8378, 77.6867),
            types = listOf("store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = false),
            userRatingsTotal = 321
        )
    )

    private val sportsStores = listOf(
        PlaceResult(
            placeId = "mock_sp1",
            name = "Decathlon - Electronic City",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.6,
            location = PlaceLocation(12.8423, 77.6778),
            types = listOf("sporting_goods_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 3456
        ),
        PlaceResult(
            placeId = "mock_sp2",
            name = "Sports Station - Neeladri",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8478, 77.6745),
            types = listOf("sporting_goods_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 654
        ),
        PlaceResult(
            placeId = "mock_sp3",
            name = "Planet Sports - Hosa Road",
            vicinity = "Hosa Road, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8534, 77.6856),
            types = listOf("sporting_goods_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 432
        )
    )

    private val defaultStores = listOf(
        PlaceResult(
            placeId = "mock_d1",
            name = "DMart - Electronic City",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.4,
            location = PlaceLocation(12.8449, 77.6741),
            types = listOf("grocery_or_supermarket", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 3456
        ),
        PlaceResult(
            placeId = "mock_d2",
            name = "Croma - Electronic City",
            vicinity = "Neeladri Road, Electronic City Phase 1, Bangalore",
            rating = 4.2,
            location = PlaceLocation(12.8472, 77.6734),
            types = listOf("electronics_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1243
        ),
        PlaceResult(
            placeId = "mock_d3",
            name = "McDonald's - EC Phase 1",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.1,
            location = PlaceLocation(12.8458, 77.6748),
            types = listOf("restaurant", "food"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 2345
        ),
        PlaceResult(
            placeId = "mock_d4",
            name = "Bata - Electronic City",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8451, 77.6752),
            types = listOf("shoe_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 765
        ),
        PlaceResult(
            placeId = "mock_d5",
            name = "Max Fashion - EC",
            vicinity = "Electronic City Phase 1, Bangalore",
            rating = 4.0,
            location = PlaceLocation(12.8456, 77.6745),
            types = listOf("clothing_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 876
        ),
        PlaceResult(
            placeId = "mock_d6",
            name = "Tanishq - Neeladri Road",
            vicinity = "Neeladri Road, Electronic City, Bangalore",
            rating = 4.5,
            location = PlaceLocation(12.8489, 77.6812),
            types = listOf("jewelry_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 1234
        ),
        PlaceResult(
            placeId = "mock_d7",
            name = "Decathlon - Electronic City",
            vicinity = "Electronic City Phase 2, Bangalore",
            rating = 4.6,
            location = PlaceLocation(12.8423, 77.6778),
            types = listOf("sporting_goods_store", "store"),
            icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
            openingHours = OpeningHours(openNow = true),
            userRatingsTotal = 3456
        )
    )

    fun getStoresForKeyword(keyword: String): List<PlaceResult> {
        val query = keyword.lowercase().trim()
        return when {
            query.contains("electron") || query.contains("mobile") ||
                    query.contains("laptop") || query.contains("phone") ||
                    query.contains("computer") || query.contains("gadget") ||
                    query.contains("tv") || query.contains("camera") -> electronicsStores

            query.contains("grocer") || query.contains("supermarket") ||
                    query.contains("vegetable") || query.contains("fruit") ||
                    query.contains("dairy") || query.contains("fresh") -> groceryStores

            query.contains("fashion") || query.contains("cloth") ||
                    query.contains("wear") || query.contains("shirt") ||
                    query.contains("dress") || query.contains("kurta") ||
                    query.contains("jeans") || query.contains("apparel") -> fashionStores

            query.contains("shoe") || query.contains("footwear") ||
                    query.contains("sneaker") || query.contains("sandal") ||
                    query.contains("boot") -> shoeStores

            query.contains("food") || query.contains("eat") ||
                    query.contains("restaurant") || query.contains("pizza") ||
                    query.contains("burger") || query.contains("cafe") ||
                    query.contains("coffee") -> foodStores

            query.contains("accessor") || query.contains("watch") ||
                    query.contains("jewel") || query.contains("bag") ||
                    query.contains("beauty") || query.contains("makeup") ||
                    query.contains("cosmetic") -> accessoriesStores

            query.contains("sport") || query.contains("gym") ||
                    query.contains("fitness") || query.contains("cricket") ||
                    query.contains("football") || query.contains("yoga") -> sportsStores

            else -> defaultStores
        }
    }
}