package personaClick.demo_android.feature.cart.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import personaClick.demo_android.feature.cart.data.api.CartApi
import personaClick.demo_android.feature.cart.data.models.Cart
import personaClick.demo_android.feature.cart.data.repository.CartRepositoryImpl
import personaClick.demo_android.feature.cart.domain.repository.CartRepository
import personaClick.demo_android.feature.cart.domain.usecase.GetCartProductsUseCase
import personaClick.demo_android.feature.cart.domain.usecase.GetCartSumPriceUseCase
import personaClick.demo_android.feature.cart.domain.usecase.RemoveProductFromCartUseCase
import personaClick.demo_android.feature.cart.presentation.mappers.CartProductItemMapper
import personaClick.demo_android.feature.cart.presentation.viewmodel.CartViewModel
import kotlin.math.sin

val cartModule = module {
    viewModel {
        CartViewModel(
            getCartProductsUseCase = get(),
            removeProductFromCartUseCase = get(),
            getCartSumPriceUseCase = get(),
            getRecommendationUseCase = get()
        )
    }
    single {
        CartProductItemMapper(
            productItemMapper = get()
        )
    }
    single {
        GetCartProductsUseCase(
            cartRepository = get()
        )
    }
    single {
        GetCartSumPriceUseCase(
            cartRepository = get()
        )
    }
    single {
        RemoveProductFromCartUseCase(
            cartRepository = get()
        )
    }
    single<CartApi> {
        CartApi(
            sdk = get()
        )
    }
    single<Cart> {
        Cart()
    }
    single<CartRepository> {
        CartRepositoryImpl(
            cartApi = get(),
            cart = get()
        )
    }
}
