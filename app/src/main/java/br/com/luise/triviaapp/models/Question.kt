package br.com.luise.triviaapp.models

data class Question(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)