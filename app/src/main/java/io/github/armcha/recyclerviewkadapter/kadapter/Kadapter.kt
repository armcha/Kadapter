package io.github.armcha.recyclerviewkadapter.kadapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class RibbleAdapter<ITEM>(items: MutableList<ITEM>, layoutResId: Int,
                          private val bindHolder: View.(ITEM) -> Unit,
                          private var itemClick: ITEM.() -> Unit = {})
    : AbstractAdapter<ITEM>(items, layoutResId) {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.bindHolder(itemList[position])
    }

    override fun onItemClick(itemView: View, position: Int) {
        itemList[position].itemClick()
    }
}

fun <ITEM> RecyclerView.setUp(items: MutableList<ITEM>,
                              layoutResId: Int,
                              bindHolder: View.(ITEM) -> Unit,
                              itemClick: ITEM.() -> Unit = {},
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)): RibbleAdapter<ITEM> {
    layoutManager = manager
    return RibbleAdapter(items, layoutResId, bindHolder, itemClick).apply { adapter = this }
}