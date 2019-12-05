package rxProxy

import com.jetbrains.handson.mpp.mobile.rxProxy.Scheduler

class SchedulerImpl(
    val scheduler: io.reactivex.Scheduler
): Scheduler {
}