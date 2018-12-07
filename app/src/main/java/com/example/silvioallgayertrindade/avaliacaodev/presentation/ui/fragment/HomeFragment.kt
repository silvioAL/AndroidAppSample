package com.example.silvioallgayertrindade.avaliacaodev.presentation.ui.fragment


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.silvioallgayertrindade.avaliacaodev.R
import com.example.silvioallgayertrindade.avaliacaodev.databinding.FragmentHomeBinding
import com.example.silvioallgayertrindade.avaliacaodev.factory.DaggerViewModelFactory
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.HomeFragmentViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        viewModel.loadEvents()


        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
            }
    }
}
