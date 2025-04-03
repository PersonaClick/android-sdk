package personaClick.demo_android.feature.search.domain.repository

import personaClick.demo_android.feature.search.domain.models.Search

interface SearchRepository {

    fun searchProducts(
        query: String,
        onGetSearch: (Search) -> Unit
    )

    fun searchRecommendedProducts(
        onGetSearch: (Search) -> Unit
    )
}
