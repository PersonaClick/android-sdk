package personaClick.demo_android.feature.search.domain.usecase

import personaClick.demo_android.feature.search.domain.models.Search
import personaClick.demo_android.feature.search.domain.repository.SearchRepository

class SearchRecommendedProductsUseCase (
    private val searchRepository: SearchRepository
) {

    fun invoke(
        onGetSearch: (Search) -> Unit
    ) {
        searchRepository.searchRecommendedProducts(onGetSearch)
    }
}
