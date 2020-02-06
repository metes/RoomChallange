package com.base.ui.fragment.pilots.detail

import com.base.R
import com.base.base.BaseFragment
import com.base.databinding.FragmentPilotDetailBinding
import com.base.ui.fragment.pilots.list.itemIdArgKey
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel


class PilotDetailFragment : BaseFragment<FragmentPilotDetailBinding, PilotDetailVM>() {

    override val layoutId: Int = R.layout.fragment_pilot_detail
    override val viewModel: PilotDetailVM by viewModel()


    override fun prepareViews() {
        changeToolbarVisibility(true)
        viewModel.getDetails(arguments?.getInt(itemIdArgKey)?: -1)
    }

    override fun subscribe() {
        viewModel.detailsLD.observeThis {
            binding.pilotDetails = it
            binding.txtTeam.text = it.team
            binding.txtAge.text = it.age.toString()
            Glide.with(this)
                .load(it.image)
                .into(binding.imgPilot)
        }
    }



}

