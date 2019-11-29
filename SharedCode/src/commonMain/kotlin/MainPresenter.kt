package com.jetbrains.handson.mpp.mobile

import com.jetbrains.handson.mpp.mobile.the_rx.factories.RxFactories

class MainPresenter(
    private val view: MainContract.View,
    private val rxFactories: RxFactories
): MainContract.Presenter {

    override fun onViewStart() {

        rxFactories.getObservableFactory().just("object from the observable with rx proxy factory")
            .subscribe({
                view.showMessage(it)
            },{
                view.showMessage(it.message?:"unknow error")
            })

//        Observable.global.just("some string from the observable")
//            .subscribe({
//                view.showMessage(it)
//            },{
//                view.showMessage(it.message?:"unknow error")
//            })

        //view.showMessage("the message from the presenter")
    }
}