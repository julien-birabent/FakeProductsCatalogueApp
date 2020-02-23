package com.julienbirabent.fakeproductscatalogue.thread
import io.reactivex.Scheduler

interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun mainThread(): Scheduler
}