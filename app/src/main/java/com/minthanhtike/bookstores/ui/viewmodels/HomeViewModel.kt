package com.minthanhtike.bookstores.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minthanhtike.bookstores.data.exceptions.ApiException
import com.minthanhtike.bookstores.data.repos.BooksRepo
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.domain.CategoryContainer
import com.minthanhtike.bookstores.domain.CategoryContainerModel
import com.minthanhtike.bookstores.util.SingleLiveEvent
import kotlinx.coroutines.launch

class HomeViewModel(
    private val booksRepo: BooksRepo
) : ViewModel() {

    private val _bookUiState = MutableLiveData<BookScreenState>()
    val bookUiState: LiveData<BookScreenState> = _bookUiState

    private val _bookUiEvent = SingleLiveEvent<BookUiEvent>()
    val bookUiEvent: LiveData<BookUiEvent> = _bookUiEvent

    init {
        getCategoryList()
        getBookList()
    }

    private fun getBookList() {
        viewModelScope.launch {
            _bookUiState.value = BookScreenState.Loading
            booksRepo.getBooks()
                .onSuccess {
                    _bookUiState.value = BookScreenState.Success(it.bookContainerModel)
                }
                .onFailure { error ->
                    when (error) {
                        is ApiException -> handleApiException(error)
                        else ->
                            _bookUiEvent.value =
                                BookUiEvent.Error(error.localizedMessage ?: "an unknown error")
                    }
                }
        }
    }

    private fun getCategoryList() {
        viewModelScope.launch {
            _bookUiState.value = BookScreenState.Loading
            booksRepo.getCategory()
                .onSuccess {
                    _bookUiState.value = BookScreenState.CategorySuccess(listOf(it) )
                }
                .onFailure { error ->
                    when (error) {
                        is ApiException -> handleApiException(error)
                        else ->
                            _bookUiEvent.value =
                                BookUiEvent.Error(error.localizedMessage ?: "an unknown error")
                    }
                }
        }
    }

    private fun handleApiException(apiException: ApiException) {
        _bookUiEvent.value = BookUiEvent.Error(apiException.localizedMessage ?: "")
    }

    sealed class BookScreenState {
        data object Empty : BookScreenState()
        data object Loading : BookScreenState()
        data class Success(val books: List<BookContainerModel>) : BookScreenState()
        data class CategorySuccess(val categorise: List<CategoryContainer>) : BookScreenState()
    }

    sealed class BookUiEvent {
        data class Error(val message: String) : BookUiEvent()
    }
}