package br.com.luise.triviaapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.luise.triviaapp.data.DataOrException
import br.com.luise.triviaapp.models.Question
import br.com.luise.triviaapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {
    val data: MutableState<DataOrException<ArrayList<Question>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, false, Exception("")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()

            if (!data.value.data.isNullOrEmpty()) {
                data.value.loading = false
            }
        }
    }

}