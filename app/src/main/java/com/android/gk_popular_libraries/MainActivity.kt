package com.android.gk_popular_libraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gk_popular_libraries.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = CountersPresenter(this)

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

    override fun setTextFirstBtn(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setTextSecondBtn(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setTextThirdBtn(text: String) {
        binding.btnCounter3.text = text
    }
}
