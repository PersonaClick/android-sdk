package personaClick.demo_android.feature.search.domain.usecase

import personaClick.demo_android.feature.search.domain.repository.SearchRepository
import personaClick.demo_android.feature.search.domain.models.Search

class SearchProductsUseCase (
    private val searchRepository: SearchRepository
) {

    fun invoke(
        query: String,
        onGetSearch: (Search) -> Unit
    ) {
        searchRepository.searchProducts(query, onGetSearch)
    }
}
