package kz.step.stepeducation182.data

import io.reactivex.Observable
import kz.step.stepeducation182.data.network.RetrofitCreator
import kz.step.stepeducation182.data.network.ReturnData
import kz.step.stepeducation182.domain.CurrencyRepository
import java.lang.Exception

class CurrencyRepository : CurrencyRepository {

    var api = RetrofitCreator().initializeApiInterface()

    override fun initiateRequestCurrencies(): Observable<ReturnData> {
        return api.initiateGetData().map{
            if(it.isSuccessful){
                it.body()
            }else{
                throw Exception("Error")
            }
        }
    }
}