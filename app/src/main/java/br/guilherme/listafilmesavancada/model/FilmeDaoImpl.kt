package br.guilherme.listafilmesavancada.model

class FilmeDaoImpl: FilmeDao {
    companion object {
        private val filmes = mutableListOf<Filme>()
    }

    override fun adicionarFilme(filme: Filme) {
        Companion.filmes.add(filme)
    }

    override fun obterFilmes(): List<Filme> {
        return Companion.filmes
    }

}