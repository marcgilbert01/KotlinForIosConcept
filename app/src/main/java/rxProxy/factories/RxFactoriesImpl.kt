package rxProxy.factories

import com.jetbrains.handson.mpp.mobile.rxProxy.factories.Sleeper
import com.jetbrains.handson.mpp.mobile.the_rx.factories.ObservableFactory
import com.jetbrains.handson.mpp.mobile.the_rx.factories.RxFactories

class RxFactoriesImpl: RxFactories {

    private val observableFactory = ObservableFactoryImpl()
    private val schedulerModule = SchedulerModuleImpl()

    override fun getObservableFactory(): ObservableFactory {
        return observableFactory
    }

    override fun getSchedulerModule(): com.jetbrains.handson.mpp.mobile.rxProxy.factories.SchedulerModule {
        return schedulerModule
    }

    override fun getSleeper(): Sleeper {
        return object: Sleeper {
            override fun sleepFor(millisec: Long) {
                Thread.sleep(millisec)
            }
        }
    }
}