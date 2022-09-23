package by.lexshi.rxjavaprojectexample.screens.images

import androidx.lifecycle.ViewModel
import by.lexshi.rxjavaprojectexample.screens.images.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(private val repository: ImagesRepository) : ViewModel() {

    fun getImages() {

        repository.usingSubject()
       // repository.filterImageResponse()
    }

    fun getNumbers() {
        repository.getMultiplyNumbers()
        repository.getConcatenationNumbers()
        repository.getNumbersDebounce()
    }

    fun mergeObservable() {
        repository.mergeObservable()
    }

    override fun onCleared() {
        repository.clearedCompositeDisposable()

        super.onCleared()
    }
}