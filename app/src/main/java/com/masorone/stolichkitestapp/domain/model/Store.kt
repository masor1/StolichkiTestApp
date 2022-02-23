package com.masorone.stolichkitestapp.domain.model

data class Store(
    val id: Int,
    val name: String,
    val address: String,
    var currentProducts: List<Product> = emptyList()
) {

    fun showProductsForPurchase(): String {
        var result = ""
        currentProducts.forEach {
            result += "product: name - ${it.name} / price - ${it.details.price}\n"
        }
        return result
    }
}
