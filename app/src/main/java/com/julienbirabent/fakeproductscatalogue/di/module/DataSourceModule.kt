package com.julienbirabent.fakeproductscatalogue.di.module

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import com.julienbirabent.fakeproductscatalogue.data.source.firestore.FireStoreDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideExampleDataSource(): NoSQLDataSource = FireStoreDataSource()

    @Provides
    fun fireStoreDataBase(): FirebaseFirestore = Firebase.firestore
}

