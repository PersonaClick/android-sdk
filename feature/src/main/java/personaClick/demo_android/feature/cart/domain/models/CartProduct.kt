package personaClick.demo_android.feature.cart.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import personaClick.demo_android.feature.productDetails.domain.models.Product

@Parcelize
data class CartProduct(
    val product: Product,
    var quantity: Int
) : Parcelable
