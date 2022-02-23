package com.masorone.stolichkitestapp.data

import com.masorone.stolichkitestapp.domain.model.Store
import io.reactivex.rxjava3.core.Single

class StoreDataRepository {

    fun getStores(): Single<List<Store>> {
        return Single.just(
            listOf(
                Store(1, "ac1", "ac1"),
                Store(2, "2", "2"),
                Store(3, "ac3", "ac3"),
                Store(4, "4", "4"),
                Store(5, "ac5", "ac5")
            )
        )
    }

    fun getActiveStoreIds(): Single<List<Int>> {
        return Single.just(
            listOf(
                1,
                3,
                5
            )
        )
    }
}
