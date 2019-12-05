package rxProxy

import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object SchedulerModuleOld {

    private var ioSheduler: Scheduler? = null
    private var uiScheduler: Scheduler? = null

    fun io() = ioSheduler ?: synchronized(this) {
        ioSheduler ?: SchedulerImpl(Schedulers.io()).also { ioSheduler = it }
    }

    fun ui() = uiScheduler ?: synchronized(this) {
        uiScheduler?: SchedulerImpl(AndroidSchedulers.mainThread()).also { uiScheduler = it }
    }


}