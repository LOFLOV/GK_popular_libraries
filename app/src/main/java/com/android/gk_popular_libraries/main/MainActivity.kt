package com.android.gk_popular_libraries.main

import android.os.Bundle
import com.android.gk_popular_libraries.GeekBrainsApp
import com.android.gk_popular_libraries.R
import com.android.gk_popular_libraries.core.OnBackPressedListener
import com.android.gk_popular_libraries.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val navigator = AppNavigator(this, R.id.containerMain)
    private val presenter by moxyPresenter { MainPresenter(GeekBrainsApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        GeekBrainsApp.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        GeekBrainsApp.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is OnBackPressedListener && it.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}