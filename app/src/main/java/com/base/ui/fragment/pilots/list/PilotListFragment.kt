package com.base.ui.fragment.pilots.list

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.R
import com.base.base.BaseFragment
import com.base.databinding.FragmentRecyclerviewBinding
import com.base.model.retrofit.response.pilots.Item
import org.koin.androidx.viewmodel.ext.android.viewModel


const val itemIdArgKey = "itemId"

class PilotListFragment : BaseFragment<FragmentRecyclerviewBinding, PilotVM>() {

    override val layoutId: Int = R.layout.fragment_recyclerview
    override val viewModel: PilotVM by viewModel()

    private var productAdapter: ProductAdapter<Item>? = null

    override fun prepareViews() {
        changeToolbarVisibility(true)
        prepareRecyclerView()
    }

    override fun subscribe() {
        viewModel.allPilptsLD.observeThis {
            binding.swipeRefresh.isRefreshing = false
            productAdapter?.changeDataWithThis(it)
            productAdapter?.notifyDataSetChanged()
        }
    }

    private fun prepareRecyclerView() {
        productAdapter = ProductAdapter(::onItemClicked, ::onFavoritesClicked)
        binding.recyclerViewSongs.apply {
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = productAdapter
        }
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.fetchSongs()
        }
    }

    private fun onItemClicked(item: Item?) {
        item?.let {
            Bundle().apply {
                navigateFragment(R.id.nav_action_pilot_list_to_detail, bundleOf(itemIdArgKey to it.id))

            }

        }
    }


    private fun onFavoritesClicked(item: Item?) {
        item?.let {
            viewModel.updateFavorite(it.id, !item.isFavorite)
        }
    }




}

