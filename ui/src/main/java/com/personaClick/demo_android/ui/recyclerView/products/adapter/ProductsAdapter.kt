package com.personaClick.demo_android.ui.recyclerView.products.adapter

import com.personaClick.demo_android.ui.recyclerView.base.adapter.ListItemAdapter
import com.personaClick.demo_android.ui.recyclerView.base.listener.OnItemClickListener
import com.personaClick.demo_android.ui.recyclerView.products.models.ProductRecyclerViewItem
import com.personaClick.demo_android.ui.recyclerView.products.view.ProductItemView

abstract class ProductsAdapter(
    items: List<ProductRecyclerViewItem>,
    listener: OnItemClickListener
) : ListItemAdapter<ProductRecyclerViewItem, ProductItemView>(
    items = items,
    listener = listener
)
