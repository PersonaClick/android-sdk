package personaClick.demo_android.feature.recommendationBlock.presentation.adapter

import android.content.Context
import com.personaClick.demo_android.ui.recyclerView.base.view.RecyclerItemView
import com.personaClick.demo_android.ui.recyclerView.base.listener.OnItemClickListener
import com.personaClick.demo_android.ui.recyclerView.products.adapter.ProductsAdapter
import com.personaClick.demo_android.ui.recyclerView.products.models.ProductRecyclerViewItem
import personaClick.demo_android.feature.recommendationBlock.presentation.view.recyclerView.RecommendationProductItemView

class RecommendationProductsAdapter(
    private val context: Context,
    productItems: List<ProductRecyclerViewItem>,
    listener: OnItemClickListener
) : ProductsAdapter(
    items = productItems,
    listener = listener
) {

    override fun createItemView(): RecyclerItemView =
        RecommendationProductItemView(
            context = context
        )
}
