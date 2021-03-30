package kz.step.stepeducation182.domain

import io.reactivex.Observable
import kz.step.stepeducation182.data.CurrencyRepository
import kz.step.stepeducation182.data.network.ReturnData

class GetRatesUseCase: BaseUseCase<ReturnData>() {

    var currencyRepository = CurrencyRepository()

    override fun createObservable(): Observable<ReturnData> {
        return currencyRepository.initiateRequestCurrencies()
    }
}