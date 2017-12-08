package io.github.armcha.recyclerviewkadapter.kadapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *
 * Created by Arman Chatikyan on 08 Dec 2017
 */
class RibbleAdapter<ITEM>(items: List<ITEM>,
                          layoutResId: Int,
                          private val bindHolder: View.(ITEM) -> Unit)
    : AbstractAdapter<ITEM>(items, layoutResId) {

    private var itemClick: ITEM.() -> Unit = {}

    constructor(items: List<ITEM>,
                layoutResId: Int,
                bindHolder: View.(ITEM) -> Unit,
                itemClick: ITEM.() -> Unit = {}) : this(items, layoutResId, bindHolder) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.bindHolder(itemList[position])
    }

    override fun onItemClick(itemView: View, position: Int) {
        itemList[position].itemClick()
    }
}

fun <ITEM> RecyclerView.setUp(items: List<ITEM>,
                              layoutResId: Int,
                              bindHolder: View.(ITEM) -> Unit,
                              itemClick: ITEM.() -> Unit = {},
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)): RibbleAdapter<ITEM> {
    val ribbleAdapter by lazy {
        RibbleAdapter(items, layoutResId, {
            bindHolder(it)
        }, {
            itemClick()
        })
    }
    layoutManager = manager
    adapter = ribbleAdapter
    return ribbleAdapter
}