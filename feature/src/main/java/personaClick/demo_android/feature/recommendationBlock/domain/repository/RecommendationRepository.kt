package personaClick.demo_android.feature.recommendationBlock.domain.repository

import personaClick.demo_android.feature.recommendationBlock.domain.models.Recommendation

interface RecommendationRepository {

    fun getRecommendation(
        recommenderCode: String,
        onGetRecommendation: (Recommendation) -> Unit
    )

    fun getRecommendationForProduct(
        recommenderCode: String,
        productId: String,
        onGetRecommendation: (Recommendation) -> Unit
    )
}
