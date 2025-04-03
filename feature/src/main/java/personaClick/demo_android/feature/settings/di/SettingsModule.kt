package personaClick.demo_android.feature.settings.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import personaClick.demo_android.feature.category.presentation.viewmodel.CategoryViewModel

val settingsModule = module {
    viewModel {
        CategoryViewModel()
    }
}
