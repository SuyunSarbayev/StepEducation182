package kz.step.stepeducation182.domain

import io.reactivex.Observable
import kz.step.stepeducation182.data.network.ReturnData

interface CurrencyRepository {
    fun initiateRequestCurrencies(): Observable<ReturnData>
}