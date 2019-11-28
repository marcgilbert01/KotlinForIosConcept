package com.jetbrains.handson.mpp.mobile.the_rx

interface Observable {

    //fun subscribe( onNext:(T) -> Unit , onError:(Throwable) -> Unit ): Disposable

    fun subscribe( onNext:(String) -> Unit , onError:(Throwable) -> Unit ): Disposable

//    companion object {
//        var global: Global = EmptyGlobal()
//    }
//    interface Global {
//        fun <T>just(t: T): Observable<T>
//    }
//
//    class EmptyGlobal : Global {
//        override fun <T> just(t: T): Observable<T> {
//            return object : Observable<T> {
//                override fun subscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit): Disposable {
//                    return object : Disposable {
//                        override fun dispose() {
//
//                        }
//
//                        override fun isDisposed(): Boolean {
//                            return true
//                        }
//                    }
//                }
//            }
//        }
//    }
}

