package br.guilherme.listafilmesavancada.model

interface FilmeDao {
    fun adicionarFilme(filme: Filme)
    fun obterFilmes(): List<Filme>
}