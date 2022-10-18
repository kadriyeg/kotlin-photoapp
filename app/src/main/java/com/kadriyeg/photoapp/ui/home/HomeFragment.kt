package com.kadriyeg.photoapp.ui.home

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.kadriyeg.photoapp.base.BaseFragment
import com.kadriyeg.photoapp.databinding.FragmentHomeBinding
import com.kadriyeg.photoapp.utils.downloadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinished() {
        viewModel.getData()
    }

    val url ="https://api.thecatapi.com/v1/images/search"
    override fun initializeListeners() {
       binding.btnImg.setOnClickListener {
          viewModel.getData()
           Glide.with(this)
               .load(url) // image url
               .centerCrop()
               .into(imageView);

       }
    }

    override fun observeEvents() {
        with(viewModel) {
            imageResponse.observe(viewLifecycleOwner, Observer {
                it?.let {
                    binding.imageView.downloadImage(it.url)
                }
            })
            isLoading.observe(viewLifecycleOwner, Observer {
                handleViews(it)
            })

            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })
        }
    }



    private fun handleViews(isLoading: Boolean = true) {
        binding.pbHome.isVisible = isLoading
    }
}