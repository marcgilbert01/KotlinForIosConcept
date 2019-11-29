package com.jetbrains.handson.mpp.mobile

import com.jetbrains.handson.mpp.mobile.entities.SomeObject
import com.jetbrains.handson.mpp.mobile.the_rx.factories.RxFactories

class MainPresenter(
    private val view: MainContract.View,
    private val rxFactories: RxFactories
): MainContract.Presenter {

    override fun onViewStart() {

        rxFactories.getObservableFactory().just(SomeObject("nice message ", 123))
            .subscribe({
               view.displaySomeObject(it)

            }, {
                view.showMessage(it.message?:"unknow error")
            })

        //view.showMessage("the message from the presenter")
    }
}