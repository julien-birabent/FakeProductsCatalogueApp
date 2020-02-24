package com.julienbirabent.fakeproductscatalogue.data.repository

import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource

abstract class BaseRepository {

    protected abstract val dataSource: NoSQLDataSource
}

