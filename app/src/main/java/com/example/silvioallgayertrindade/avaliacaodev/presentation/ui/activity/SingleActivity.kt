package com.example.silvioallgayertrindade.avaliacaodev.presentation.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.silvioallgayertrindade.avaliacaodev.R
import com.example.silvioallgayertrindade.avaliacaodev.databinding.ActivitySingleBinding
import com.example.silvioallgayertrindade.avaliacaodev.factory.DaggerViewModelFactory
import com.example.silvioallgayertrindade.avaliacaodev.presentation.view.SingleActivityView
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.SingleActivityViewModel
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SingleActivity : DaggerAppCompatActivity(), SingleActivityView {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    lateinit var viewModel: SingleActivityViewModel

    lateinit var activitySingleBinding: ActivitySingleBinding

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        activitySingleBinding = DataBindingUtil.setContentView(this, R.layout.activity_single)
        navController = Navigation.findNavController(this, R.id.navigation_host)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SingleActivityViewModel::class.java)
        viewModel.setup(this)
        activitySingleBinding.singleActivityViewModel = viewModel
    }

    override fun onSupportNavigateUp(): Boolean {
        return executeInitialNavigationAction()
    }

    override fun executeInitialNavigationAction(): Boolean {
        return navController.navigateUp()
    }
}
