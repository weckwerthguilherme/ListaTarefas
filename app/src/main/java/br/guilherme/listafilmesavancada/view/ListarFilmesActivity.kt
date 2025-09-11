package br.guilherme.listafilmesavancada.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.guilherme.listafilmesavancada.R
import br.guilherme.listafilmesavancada.adapter.FilmeAdapter
import br.guilherme.listafilmesavancada.model.FilmeDaoImpl

class ListarFilmesActivity : AppCompatActivity(R.layout.activity_listar_filmes) {

    private val filmeDao = FilmeDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvFilmes = findViewById<RecyclerView>(R.id.rv_filmes)
        val filmes = filmeDao.obterFilmes()
        rvFilmes.layoutManager = LinearLayoutManager(this)
        rvFilmes.adapter = FilmeAdapter(filmes)
    }



}