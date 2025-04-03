package personaClick.demo_android.feature.search.presentation.view.recyclerView

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import com.personaClick.demo_android.ui.recyclerView.base.view.ListRecyclerView
import com.personaClick.demo_android.ui.recyclerView.base.adapter.ListItemAdapter
import com.personaClick.demo_android.ui.recyclerView.base.listener.OnItemClickListener
import personaClick.demo_android.feature.search.presentation.adapter.SearchCategoryAdapter
import personaClick.demo_android.feature.search.presentation.models.CategoryRecyclerViewItem

class SearchCategoriesRecyclerView @JvmOverloads constructor(
    private val context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ListRecyclerView<CategoryRecyclerViewItem, SearchCategoryItemView>(
    context = context,
    attrs = attrs,
    defStyleAttr = defStyleAttr
) {

    override fun createAdapter(
        listener: OnItemClickListener
    ): ListItemAdapter<CategoryRecyclerViewItem, SearchCategoryItemView> =
        SearchCategoryAdapter(
           context = context,
           items = items,
           listener = listener
       )

    override fun createLayoutManager(): LayoutManager =
        LinearLayoutManager(context)
            .apply {
                orientation = VERTICAL
            }
}
