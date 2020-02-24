package com.julienbirabent.fakeproductscatalogue.data

import android.content.Context
import android.graphics.Color
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.entity.ImageResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.ColorResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Dimensions
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RandomProductsGenerator @Inject constructor(private val context: Context) {

    private val random = Random()

    private val titles = listOf(
        stringRes(R.string.random_title_1),
        stringRes(R.string.random_title_2),
        stringRes(R.string.random_title_3),
        stringRes(R.string.random_title_4),
        stringRes(R.string.random_title_5)
    )

    private val descriptions = listOf(
        stringRes(R.string.random_description_1),
        stringRes(R.string.random_description_2),
        stringRes(R.string.random_description_3),
        stringRes(R.string.random_description_4),
        stringRes(R.string.random_description_5)
    )

    private val thumbnail = listOf(
        ImageResource(R.drawable.bag_1),
        ImageResource(R.drawable.bag_2),
        ImageResource(R.drawable.bag_3),
        ImageResource(R.drawable.bag_4),
        ImageResource(R.drawable.bag_5)
    )

    fun generateRandomProductList(count: Int): List<Product> {
        val list = mutableListOf<Product>()

        (1 until count).forEach { _ ->
            list.add(generateRandomProduct())
        }

        list.add(random.nextInt(list.size - 1), generateOutOfStockProduct())
        return list
    }

    private fun generateRandomProduct(): Product {
        return Product(
            title = titles.random(),
            description = descriptions.random(),
            imageResource = thumbnail.random(),
            colors = randomColorList(),
            price = random.nextInt(200).toFloat(),
            dimensions = Dimensions(
                random.nextInt(200).toFloat(),
                random.nextInt(200).toFloat(),
                random.nextInt(200).toFloat()
            ),
            quantity = random.nextInt(100)
        )
    }

    private fun generateOutOfStockProduct(): Product {
        return generateRandomProduct().apply { quantity = 0 }
    }

    private fun randomColorList(): List<ColorResource<*>> {
        val list = mutableListOf<ColorResource<*>>()

        (1..random.nextInt(5)).forEach { _ ->
            list.add(ColorResource(randomHexColor()))
        }
        return list
    }

    private fun randomHexColor(): String {
        val randRgbValue =
            Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        return String.format("#%06x", randRgbValue)
    }

    private fun stringRes(resId: Int): String = context.getString(resId)
}