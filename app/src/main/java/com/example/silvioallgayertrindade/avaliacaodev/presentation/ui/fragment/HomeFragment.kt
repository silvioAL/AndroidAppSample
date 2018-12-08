package com.example.silvioallgayertrindade.avaliacaodev.presentation.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.silvioallgayertrindade.avaliacaodev.R
import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Status
import com.example.silvioallgayertrindade.avaliacaodev.databinding.FragmentHomeBinding
import com.example.silvioallgayertrindade.avaliacaodev.factory.DaggerViewModelFactory
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.HomeFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

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
        AndroidSupportInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        attachObservers()
        viewModel.loadEvents()
        return binding.root
    }

    fun attachObservers() {
        viewModel.status.observe(this, onSatusChange)
    }

    val onSatusChange = Observer<Status> {
        when (it) {
            Status.SUCCESS -> hideLoading()
            Status.LOADING -> showLoading()
            Status.ERROR -> showMessage()
        }
    }

    fun showLoading() {
        binding.progress.visibility = View.VISIBLE
    }

    fun hideLoading() {
        binding.progress.visibility = View.GONE
    }

    fun showMessage() {
        hideLoading()
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setMessage(viewModel.message.value)
        builder?.setPositiveButton(
            android.R.string.ok
        ) { dialog, _ -> dialog.dismiss() }

        val dialog = builder?.create()
        dialog?.show()

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
            }
    }
}
