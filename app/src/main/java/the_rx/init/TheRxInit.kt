package the_rx.init

import io.reactivex.Completable

class TheRxInit {

    fun initialise(): Completable {
        val completables = ArrayList<Completable>()
        completables.add(InitForObservable().initialise())

        return  Completable.merge(completables)
    }

}