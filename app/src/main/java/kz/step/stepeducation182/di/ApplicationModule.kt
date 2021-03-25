package kz.step.stepeducation182.di

import dagger.Module
import dagger.Provides
import kz.step.stepeducation182.domain.RetrieveStudentsUseCase
import kz.step.stepeducation182.domain.SortStudentsUseCase
import kz.step.stepeducation182.domain.UseCasePersonsCount

@Module
class ApplicationModule {
    @Provides
    fun providesStudentsSortUseCase(retrieveStudentsUseCase: RetrieveStudentsUseCase): SortStudentsUseCase {
        return SortStudentsUseCase(retrieveStudentsUseCase)
    }

    @Provides
    fun providesRetrieveStudentsUseCase(useCasePersonsCount: UseCasePersonsCount): RetrieveStudentsUseCase{
        return RetrieveStudentsUseCase(useCasePersonsCount)
    }

    @Provides
    fun providesUseCasePersonsCound(): UseCasePersonsCount{
        return UseCasePersonsCount()
    }
}