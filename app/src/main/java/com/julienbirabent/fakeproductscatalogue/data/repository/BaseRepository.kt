package com.julienbirabent.fakeproductscatalogue.data.repository

import com.julienbirabent.fakeproductscatalogue.app.ThisApplication
import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import com.julienbirabent.fakeproductscatalogue.di.DatabaseInfo
import javax.inject.Inject

abstract class BaseRepository<M : Model> {

    protected abstract val dataSource: NoSQLDataSource
    protected abstract val collectionName: String

}

