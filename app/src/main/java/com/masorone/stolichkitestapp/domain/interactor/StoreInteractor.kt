package com.masorone.stolichkitestapp.domain.interactor

import com.masorone.stolichkitestapp.data.StoreDataRepository
import com.masorone.stolichkitestapp.domain.model.Store
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction

class StoreInteractor(
    private val storeDataRepository: StoreDataRepository
) {

    // Метод получения активных магазинов
    fun getActiveStores(): Single<List<Store>> {

        val zipper = BiFunction<List<Store>, List<Int>, List<Store>> { stores, ids ->
            val activeStore = mutableListOf<Store>()
            ids.forEach { id ->
                stores.forEach { store ->
                    if (id == store.id) {
                        activeStore.add(store)
                    }
                }
            }
            return@BiFunction activeStore
        }

        return Single.zip(
            storeDataRepository.getStores(),
            storeDataRepository.getActiveStoreIds(),
            zipper
        )
    }
}