package kz.step.stepeducation182.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.*

abstract class BaseUseCase<T> {

    var compositeDisposable = CompositeDisposable()

    fun execute(disposableObserver: DisposableObserver<T>){
        var observable = createObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        var observer = observable.subscribeWith(disposableObserver)

        compositeDisposable.add(observer)
    }

    fun initiateClear(){
        compositeDisposable.clear()
    }

    fun initiateDispose(){
        compositeDisposable.dispose()
    }

    abstract fun createObservable(): Observable<T>
}