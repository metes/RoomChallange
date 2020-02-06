package com.base.ui.fragment.splash

import com.base.R
import com.base.base.BaseFragment
import com.base.commons.splashAnimation
import com.base.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>() {

    override val layoutId: Int = R.layout.fragment_splash
    override val viewModel: SplashVM by viewModel()

    override fun prepareViews() {
        changeToolbarVisibility()
        binding.imageViewLogo.splashAnimation(::onLogoAnimationEnd)
    }

    /**
     *  Animasyon bitiminde calistirilacak
     */
    private fun onLogoAnimationEnd() {
        navigateFragment(R.id.nav_action_splash_to_products)
    }

}

