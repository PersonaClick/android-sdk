package personaClick.demo_android.feature.recommendationBlock.di

import org.koin.dsl.module
import personaClick.demo_android.feature.recommendationBlock.data.api.RecommendationApi
import personaClick.demo_android.feature.recommendationBlock.data.mappers.RecommendationMapper
import personaClick.demo_android.feature.recommendationBlock.data.repository.RecommendationRepositoryImpl
import personaClick.demo_android.feature.recommendationBlock.domain.repository.RecommendationRepository
import personaClick.demo_android.feature.recommendationBlock.domain.usecase.GetRecommendationUseCase

val recommendationBlockModule = module {
    single {
        GetRecommendationUseCase(
            recommendationRepository = get()
        )
    }
    single<RecommendationApi> {
        RecommendationApi(
            sdk = get()
        )
    }
    single {
        RecommendationMapper(
            productMapper = get()
        )
    }
    single<RecommendationRepository> {
        RecommendationRepositoryImpl(
            recommendationApi = get(),
            recommendationMapper = get()
        )
    }
}
