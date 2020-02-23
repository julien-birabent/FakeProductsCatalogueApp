package com.julienbirabent.fakeproductscatalogue.data.entity.product

class StarRating(override var value: Int) : Rating<Int> {

    override var maximumValue: Int = 0
    override var minimumValue: Int = 5

}