package com.julienbirabent.fakeproductscatalogue.data.entity.product

interface Rating<Unit> {
    var value: Unit
    var maximumValue: Unit
    var minimumValue: Unit
}