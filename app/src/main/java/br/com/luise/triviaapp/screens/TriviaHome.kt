package br.com.luise.triviaapp.screens

import androidx.compose.runtime.Composable
import br.com.luise.triviaapp.components.Question

@Composable
fun TriviaHome(viewModel: QuestionsViewModel) {
    Question(viewModel)
}