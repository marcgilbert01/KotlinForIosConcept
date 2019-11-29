package com.example.kotlinforiosconcept

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jetbrains.handson.mpp.mobile.MainContract
import com.jetbrains.handson.mpp.mobile.MainPresenter
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage
import com.jetbrains.handson.mpp.mobile.entities.SomeObject
import com.jetbrains.handson.mpp.mobile.the_rx.Observable
import com.jetbrains.handson.mpp.mobile.the_rx.factories.ObservableFactory
import com.jetbrains.handson.mpp.mobile.the_rx.factories.RxFactories
import kotlinx.android.synthetic.main.activity_main.*
import rxProxy.ObservableImpl

class MainActivity : AppCompatActivity(),MainContract.View {

    private var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_text.text = createApplicationScreenMessage()

        val rxFactories = object : RxFactories {
            override fun getObservableFactory(): ObservableFactory {

                return object : ObservableFactory {
                    override fun <T> just(t: T): Observable<T> {

                        return ObservableImpl(io.reactivex.Observable.just(t))
                    }
                }


//                return object : ObservableFactory{
//                    override fun just(str: String): Observable {
//                        return ObservableImpl(io.reactivex.Observable.just(str))
//                    }
//                }
            }
        }

        presenter = MainPresenter(this, rxFactories)
    }

    override fun showMessage(message: String) {
        small_text_view.text = message
    }

    override fun displaySomeObject(someObject: SomeObject) {
        small_text_view.text = someObject.str
        button.text = someObject.number.toString()
    }

    override fun onStart() {
        super.onStart()
        presenter?.onViewStart()
    }
}
