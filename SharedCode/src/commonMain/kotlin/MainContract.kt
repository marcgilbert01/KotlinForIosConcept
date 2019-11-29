package com.jetbrains.handson.mpp.mobile

import com.jetbrains.handson.mpp.mobile.entities.SomeObject

interface MainContract {

    interface View {

        fun showMessage(message: String)

        fun displaySomeObject(someObject: SomeObject)

    }

    interface Presenter {

        fun onViewStart()

    }

}