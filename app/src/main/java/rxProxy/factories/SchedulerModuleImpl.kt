package rxProxy.factories

import com.jetbrains.handson.mpp.mobile.rxProxy.factories.SchedulerModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rxProxy.SchedulerImpl

class SchedulerModuleImpl: SchedulerModule {

    private var ioSheduler = SchedulerImpl(Schedulers.io())
    private var uiScheduler = SchedulerImpl(AndroidSchedulers.mainThread())
    private var computationScheduler = SchedulerImpl(Schedulers.computation())

    override fun io() = ioSheduler

    override fun ui() = uiScheduler

    override fun computation() = computationScheduler
}