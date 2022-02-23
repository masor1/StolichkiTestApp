package com.masorone.stolichkitestapp.domain.interactor

import com.masorone.stolichkitestapp.data.ProductRepository
import com.masorone.stolichkitestapp.domain.model.Product
import io.reactivex.rxjava3.core.Single

class ProductInteractor(
    private val productRepository: ProductRepository
) {

    fun getCurrencyProducts(): Single<List<Product>> {
        return productRepository.getCurrentProducts()
    }
}