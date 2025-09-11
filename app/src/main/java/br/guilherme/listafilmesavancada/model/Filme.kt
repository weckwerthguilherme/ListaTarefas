package br.guilherme.listafilmesavancada.model

data class Filme(
    val nomeFilme: String,
    val diretorFilme: String,
    val generos: List<String>,
    val avaliacao: Int,
    var concluida: Boolean = false, //adicionei isso aqui pra fazer o checkbox funcionar, explico mais no FilmeAdapter

)
