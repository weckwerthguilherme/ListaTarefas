package br.guilherme.listatarefas.model

data class Filme(
    val nomeFilme: String,
    val diretorFilme: String,
    var concluida: Boolean = false //adicionei isso aqui pra fazer o checkbox funcionar, explico mais no FilmeAdapter
)
