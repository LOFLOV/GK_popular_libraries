package com.android.gk_popular_libraries

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CountersPresenter(
    private val model: CountersModel
) : MvpPresenter<MainView>() {

    fun onCLickFirstButton(index: Int) {
        viewState.setTextFirstBtn(model.next(index).toString())
    }

    fun onClickSecondButton(index: Int) {
        viewState.setTextSecondBtn(model.next(index).toString())
    }

    fun onClickThirdButton(index: Int) {
        viewState.setTextThirdBtn(model.next(index).toString())
    }
}