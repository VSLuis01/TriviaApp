package br.com.luise.triviaapp.repository

import android.util.Log
import br.com.luise.triviaapp.data.DataOrException
import br.com.luise.triviaapp.models.Question
import br.com.luise.triviaapp.network.QuestionApi
import javax.inject.Inject
import kotlin.Exception

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<Question>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<Question>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()

            if (!dataOrException.data.isNullOrEmpty()) dataOrException.loading = false

        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exception Loading", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }

        return dataOrException
    }

}