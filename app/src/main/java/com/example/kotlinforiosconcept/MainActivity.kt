package com.example.kotlinforiosconcept

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jetbrains.handson.mpp.mobile.MainContract
import com.jetbrains.handson.mpp.mobile.MainPresenter
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage
import com.jetbrains.handson.mpp.mobile.entities.SomeObject
import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler
import com.jetbrains.handson.mpp.mobile.rxProxy.factories.Sleeper
import com.jetbrains.handson.mpp.mobile.the_rx.Observable
import com.jetbrains.handson.mpp.mobile.the_rx.factories.ObservableFactory
import com.jetbrains.handson.mpp.mobile.the_rx.factories.RxFactories
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import rxProxy.ObservableImpl
import rxProxy.SchedulerImpl
import rxProxy.SchedulerModuleOld
import rxProxy.factories.RxFactoriesImpl

class MainActivity : AppCompatActivity(),MainContract.View {

    private var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_text.text = createApplicationScreenMessage()

        presenter = MainPresenter(this, RxFactoriesImpl())
    }

    override fun showMessage(message: String) {
        Log.d("marc", message)
        small_text_view.text = message
    }

    override fun displaySomeObject(someObject: SomeObject) {
        Log.d("marc", someObject.str)
        small_text_view.text = someObject.str
        button.text = someObject.number.toString()
    }

    override fun onStart() {
        super.onStart()
        presenter?.onViewStart()
    }
}
