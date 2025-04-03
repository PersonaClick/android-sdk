package personaClick.demo_android.feature.search.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import personaClick.demo_android.feature.search.data.api.SearchApi
import personaClick.demo_android.feature.search.data.mappers.SearchMapper
import personaClick.demo_android.feature.search.data.repository.SearchRepositoryImpl
import personaClick.demo_android.feature.search.domain.repository.SearchRepository
import personaClick.demo_android.feature.search.presentation.viewmodel.SearchViewModel
import personaClick.demo_android.feature.search.domain.usecase.SearchProductsUseCase
import personaClick.demo_android.feature.search.domain.usecase.SearchRecommendedProductsUseCase
import personaClick.demo_android.feature.search.presentation.mappers.SearchItemMapper

val searchModule = module {
    viewModel {
        SearchViewModel(
            searchProductsUseCase = get(),
            searchRecommendedProductsUseCase = get()
        )
    }
    single<SearchApi> {
        SearchApi(
            sdk = get()
        )
    }
    single {
        SearchMapper(
            productMapper = get()
        )
    }
    single {
        SearchItemMapper(
            productItemMapper = get()
        )
    }
    single<SearchRepository> {
        SearchRepositoryImpl(
            productApi = get(),
            searchMapper = get()
        )
    }
    single {
        SearchProductsUseCase(
            searchRepository = get()
        )
    }
    single {
        SearchRecommendedProductsUseCase(
            searchRepository = get()
        )
    }
}
