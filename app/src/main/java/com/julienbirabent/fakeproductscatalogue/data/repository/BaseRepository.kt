package com.julienbirabent.fakeproductscatalogue.data.repository

import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource

abstract class BaseRepository<M : Model> {

    protected abstract val dataSource: NoSQLDataSource

}

