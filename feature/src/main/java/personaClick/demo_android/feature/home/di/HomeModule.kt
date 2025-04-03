package personaClick.demo_android.feature.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import personaClick.demo_android.core.settings.RecommendationSettings
import personaClick.demo_android.feature.home.presentation.viewmodel.HomeViewModel

val homeModule = module {
    viewModel {
        HomeViewModel(
            getRecommendationUseCase = get(),
            recommenderCode = RecommendationSettings.SIMPLE_RECOMMENDED_CODE
        )
    }
}
