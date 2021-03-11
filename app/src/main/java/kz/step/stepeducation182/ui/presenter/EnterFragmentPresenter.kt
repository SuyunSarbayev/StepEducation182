package kz.step.stepeducation182.ui.presenter

import android.util.Log
import kz.step.stepeducation182.domain.RetrieveStudentsUseCase
import kz.step.stepeducation182.ui.contract.EnterFragmentContract

class EnterFragmentPresenter : EnterFragmentContract.Presenter {

    var enterFragmentView: EnterFragmentContract.View? = null
    var retrieveStudentsUseCase: RetrieveStudentsUseCase = RetrieveStudentsUseCase()

    override fun setView(view: EnterFragmentContract.View) {
        this.enterFragmentView = view
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