package com.jetbrains.handson.mpp.mobile

import com.jetbrains.handson.mpp.mobile.entities.SomeObject
import com.jetbrains.handson.mpp.mobile.the_rx.factories.RxFactories

class MainPresenter(
    private val view: MainContract.View,
    private val rxFactories: RxFactories
): MainContract.Presenter {

    override fun onViewStart() {

        rxFactories.getObservableFactory()
            .just(SomeObject("moves rx swift implementation in shared code", 345))
            .delay(3000)
            .subscribeOn(rxFactories.getSchedulerModule().io())
            .observeOn(rxFactories.getSchedulerModule().ui())
            .subscribe({
               //rxFactories.getSleeper().sleep(3000)
               view.displaySomeObject(it)
            }, {
                view.showMessage(it.message?:"unknow error")
            })
        view.showMessage("the message from the presenter")
    }
}