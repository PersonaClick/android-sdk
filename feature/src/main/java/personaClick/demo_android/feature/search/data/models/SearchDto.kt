package personaClick.demo_android.feature.search.data.models

import personaClick.demo_android.feature.productDetails.data.models.ProductDto

data class SearchDto(
    val products: List<ProductDto>,
    val categories: List<CategoryDto>
)
