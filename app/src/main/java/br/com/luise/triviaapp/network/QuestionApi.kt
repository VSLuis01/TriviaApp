package br.com.luise.triviaapp.network

import br.com.luise.triviaapp.models.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Question
}