package com.android.gk_popular_libraries

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {
    fun setTextFirstBtn(text: String)
    fun setTextSecondBtn(text: String)
    fun setTextThirdBtn(text: String)
}