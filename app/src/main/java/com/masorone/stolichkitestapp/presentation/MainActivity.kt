package com.masorone.stolichkitestapp.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.masorone.stolichkitestapp.R
import com.masorone.stolichkitestapp.data.ProductRepository
import com.masorone.stolichkitestapp.data.StoreDataRepository
import com.masorone.stolichkitestapp.domain.interactor.ProductInteractor
import com.masorone.stolichkitestapp.domain.interactor.StoreInteractor
import com.masorone.stolichkitestapp.domain.model.Store
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val listOfStore = mutableListOf<Store>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storeDataRepository = StoreDataRepository()
        val storeInteractor = StoreInteractor(storeDataRepository)

        val productRepository = ProductRepository()
        val productInteractor = ProductInteractor(productRepository)

        val tvStores = findViewById<TextView>(R.id.text_active_stores)
        val tvProducts = findViewById<TextView>(R.id.text_view_products)

        compositeDisposable.add(
            storeInteractor.getActiveStores()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tvStores.text = "Задание 1:\n$it\n\n"
                    listOfStore.addAll(it)
                }, {
                    Log.d("MainActivity", "onCreate: ${it.message}")
                })
        )

        compositeDisposable.add(
            productInteractor.getCurrencyProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ products ->
                    listOfStore.forEach {
                        it.currentProducts = products
                    }

                    val store = listOfStore[1]
                    tvProducts.text = "\n\nЗадание 2:\n${store.showProductsForPurchase()}"

                }, {
                    Log.d("MainActivity", "onCreate: ${it.message}")
                })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}