package kz.step.stepeducation182.ui.presenter

import android.util.Log
import kz.step.stepeducation182.di.ApplicationModule
import kz.step.stepeducation182.di.DaggerApplicationComponent
import kz.step.stepeducation182.domain.RetrieveStudentsUseCase
import kz.step.stepeducation182.ui.contract.EnterFragmentContract
import javax.inject.Inject

class EnterFragmentPresenter : EnterFragmentContract.Presenter {

    @Inject
    lateinit var retrieveStudentsUseCase: RetrieveStudentsUseCase

    var enterFragmentView: EnterFragmentContract.View? = null

    override fun setView(view: EnterFragmentContract.View) {
        this.enterFragmentView = view
        initializeDependencies()
    }

    fun initializeDependencies(){
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
            .inject(this)
    }

    override fun initiateRetrieveStudents() {
        if(enterFragmentView != null){
            Log.d("PRESENTER", "VIEW NOT NULL")
        }
        Log.d("PRESENTER", retrieveStudentsUseCase.provideStudents().toString())
        enterFragmentView?.initializeAdapter(
            retrieveStudentsUseCase.provideStudents())
    }
}