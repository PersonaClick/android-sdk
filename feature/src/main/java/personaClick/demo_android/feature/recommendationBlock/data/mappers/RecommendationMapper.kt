package personaClick.demo_android.feature.recommendationBlock.data.mappers

import personaClick.demo_android.feature.productDetails.data.mappers.ProductMapper
import personaClick.demo_android.feature.recommendationBlock.data.models.RecommendationDto
import personaClick.demo_android.feature.recommendationBlock.domain.models.Recommendation

class RecommendationMapper  (
    private val productMapper: ProductMapper
) {
    fun toRecommendation(recommendationDto: RecommendationDto): Recommendation =
        with(recommendationDto) {
            Recommendation(
                title = title,
                products = productMapper.toProducts(products)
            )
        }
}
