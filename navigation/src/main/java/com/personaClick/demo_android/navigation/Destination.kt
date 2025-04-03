package com.personaClick.demo_android.navigation

import com.personaClick.demo_android.navigation.models.NavigationProduct

sealed interface Destination
class ProductDetails(val navigationProduct: NavigationProduct) : Destination
class ProductsDetails(val navigationProducts: Collection<NavigationProduct>) : Destination
