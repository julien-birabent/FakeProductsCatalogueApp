package com.julienbirabent.fakeproductscatalogue.data.entity.product

import com.google.firebase.firestore.IgnoreExtraProperties
import com.julienbirabent.fakeproductscatalogue.data.entity.ImageResource
import java.io.Serializable

@IgnoreExtraProperties
open class Product(
    var title: String = "",
    var description: String = "",
    var colors: List<ColorResource<*>> = listOf(),
    var dimensions: Dimensions = Dimensions(),
    var price: Float = 0f,
    var quantity: Int = 0,
    var imageResource: ImageResource<*>? = null,
    var rating: Rating<*>? = null
) : Serializable