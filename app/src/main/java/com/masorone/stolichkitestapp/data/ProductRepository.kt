package com.masorone.stolichkitestapp.data

import com.masorone.stolichkitestapp.domain.model.Product
import com.masorone.stolichkitestapp.domain.model.ProductDetails
import io.reactivex.rxjava3.core.Single
import java.util.*

class ProductRepository {

    fun getCurrentProducts(): Single<List<Product>> {
        return Single.just(
            listOf(
                Product(1, "product 1", ProductDetails(1.2, Date(), 1)),
                Product(2, "product 2", ProductDetails(2.3, Date(), 2)),
                Product(3, "product 3", ProductDetails(3.4, Date(), 3)),
                Product(4, "product 4", ProductDetails(4.5, Date(), 4)),
                Product(5, "product 5", ProductDetails(5.6, Date(), 5)),
                Product(6, "product 6", ProductDetails(6.7, Date(), 6)),
                Product(7, "product 7", ProductDetails(7.8, Date(), 7)),
                Product(8, "product 8", ProductDetails(8.1, Date(), 8))
            )
        )
    }
}
