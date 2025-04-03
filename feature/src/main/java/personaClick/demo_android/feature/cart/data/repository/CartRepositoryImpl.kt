package personaClick.demo_android.feature.cart.data.repository

import kotlinx.coroutines.flow.StateFlow
import personaClick.demo_android.core.utils.SdkUtils
import personaClick.demo_android.feature.cart.data.api.CartApi
import personaClick.demo_android.feature.cart.data.models.Cart
import personaClick.demo_android.feature.cart.domain.repository.CartRepository
import personaClick.demo_android.feature.cart.domain.models.CartProduct
import personaClick.demo_android.feature.productDetails.domain.models.Product

class CartRepositoryImpl(
    private val cartApi: CartApi,
    private val cart: Cart
) : CartRepository {

    override fun getCartProducts(): StateFlow<MutableList<CartProduct>> =
        cart.cartProductsFlow

    override fun getCartProduct(productId: String): CartProduct? =
        cart.getCartProduct(productId)

    override fun getSumPrice(): StateFlow<Double> =
        cart.cartSumPrice

    override fun addProduct(
        product: Product,
        quantity: Int
    ) {
        cartApi.addProduct(
            product = product,
            quantity = quantity,
            listener = SdkUtils.createOnApiCallbackListener(
                onSuccess = {
                    cart.addProduct(
                        product = product,
                        quantity = quantity
                    )
                }
            )
        )
    }

    override fun removeProduct(productId: String) {
        cartApi.removeProduct(
            productId = productId,
            listener = SdkUtils.createOnApiCallbackListener(
                onSuccess = {
                    cart.removeProduct(productId)
                }
            )
        )
    }
}
