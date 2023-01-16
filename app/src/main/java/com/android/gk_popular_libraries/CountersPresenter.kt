package com.android.gk_popular_libraries

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onCLickFirstButton(index: Int) {
        val nextValue = model.next(index)
        view.setTextFirstBtn(nextValue.toString())
    }

    fun onClickSecondButton(index: Int) {
        val nextValue = model.next(index)
        view.setTextSecondBtn(nextValue.toString())
    }

    fun onClickThirdButton(index: Int) {
        val nextValue = model.next(index)
        view.setTextThirdBtn(nextValue.toString())
    }
}