package com.example.kotlinforiosconcept

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jetbrains.handson.mpp.mobile.MainContract
import com.jetbrains.handson.mpp.mobile.MainPresenter
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage
import com.jetbrains.handson.mpp.mobile.entities.SomeObject
import com.jetbrains.handson.mpp.mobile.rxProxy.SchedulerImpl
import kotlinx.android.synthetic.main.activity_main.*
import com.jetbrains.handson.mpp.mobile.rxProxy.factories.RxFactoriesImpl
import com.jetbrains.handson.mpp.mobile.rxProxy.factories.SchedulerModuleImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), MainContract.View {

    private var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_text.text = createApplicationScreenMessage()

        val schedulerModuleImpl = SchedulerModuleImpl(
            SchedulerImpl(Schedulers.io()),
            SchedulerImpl(AndroidSchedulers.mainThread()),
            SchedulerImpl(Schedulers.computation())
        )

        presenter = MainPresenter(
            this,
            RxFactoriesImpl(schedulerModuleImpl)
        )
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
