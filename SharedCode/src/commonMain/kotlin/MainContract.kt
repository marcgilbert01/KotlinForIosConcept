package com.jetbrains.handson.mpp.mobile

interface MainContract {

    interface View {

        fun showMessage(message: String)

    }

    interface Presenter {

        fun onViewStart()

    }

}