package personaClick.demo_android.feature.search.presentation.adapter

import android.content.Context
import com.personaClick.demo_android.ui.recyclerView.base.adapter.ListItemAdapter
import com.personaClick.demo_android.ui.recyclerView.base.listener.OnItemClickListener
import com.personaClick.demo_android.ui.recyclerView.products.models.ProductRecyclerViewItem
import personaClick.demo_android.feature.search.presentation.view.recyclerView.SearchProductItemView

class SearchProductAdapter(
    private val context: Context,
    items: List<ProductRecyclerViewItem>,
    listener: OnItemClickListener
) : ListItemAdapter<ProductRecyclerViewItem, SearchProductItemView>(
    items = items,
    listener = listener
) {

    override fun createItemView(): SearchProductItemView =
        SearchProductItemView(
            context = context
        )
}
