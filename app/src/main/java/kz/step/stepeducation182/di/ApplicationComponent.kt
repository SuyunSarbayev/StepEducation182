package kz.step.stepeducation182.di

import dagger.Component
import kz.step.stepeducation182.ui.fragments.EnterFragment
import kz.step.stepeducation182.ui.presenter.EnterFragmentPresenter

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(enterFragment: EnterFragment)
    fun inject(enterFragmentPresenter: EnterFragmentPresenter)
}