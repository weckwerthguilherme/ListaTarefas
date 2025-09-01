package br.guilherme.listatarefas.model

interface FilmeDao {
    fun adicionarFilme(filme: Filme)
    fun obterFilmes(): List<Filme>
}