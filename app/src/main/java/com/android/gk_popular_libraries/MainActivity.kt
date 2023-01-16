package com.android.gk_popular_libraries

import android.os.Bundle
import com.android.gk_popular_libraries.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { CountersPresenter(CountersModel())  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnCounter1.setOnClickListener { presenter.onCLickFirstButton(0) }
            btnCounter2.setOnClickListener { presenter.onClickSecondButton(1) }
            btnCounter3.setOnClickListener { presenter.onClickThirdButton(2) }
        }
    }

    override fun setTextFirstBtn(counter: String) {
        binding.btnCounter1.text = counter
    }

    override fun setTextSecondBtn(counter: String) {
        binding.btnCounter2.text = counter
    }

    override fun setTextThirdBtn(counter: String) {
        binding.btnCounter3.text = counter
    }
}
