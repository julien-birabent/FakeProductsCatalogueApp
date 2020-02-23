package com.julienbirabent.fakeproductscatalogue.di

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseInfo(val value: String = "")