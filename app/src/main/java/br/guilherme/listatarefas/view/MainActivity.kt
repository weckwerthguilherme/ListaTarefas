package br.guilherme.listatarefas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.guilherme.listatarefas.R
import br.guilherme.listatarefas.model.Filme
import br.guilherme.listatarefas.model.FilmeDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val filmeDao = FilmeDaoImpl() //Cria a instância do data access object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeFilme = findViewById<EditText>(R.id.edt_nome_filme)
        val edtNomeDiretor = findViewById<EditText>(R.id.edt_nome_diretor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar_filme)
        val fabListarLivros = findViewById<FloatingActionButton>(R.id.fab_listar_filmes)


        btnCadastrar.setOnClickListener {
            val nomeF = edtNomeFilme.text.toString()
            val nomeD = edtNomeDiretor.text.toString()
            val filme = Filme(nomeF, nomeD)
            filmeDao.adicionarFilme(filme)

            edtNomeDiretor.text.clear()
            edtNomeFilme.text.clear()

            //pra fazer uma mensagem de feedback do cadastro
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastro de atividade OK")
            val alert = builder.create()
            alert.show()
        }

        fabListarLivros.setOnClickListener {
            val intent = Intent(this, ListarFilmesActivity::class.java)
            startActivity(intent)
        }

        /* Este projeto foi criado a partir do projeto da ListaFilmes
        * para que eu pudesse clonar o projeto eu copiei e coleio projeto anterior em uma pasta (Também fiz isso sem ter controle de versionamento ativado)
        * mudei o nome do projeto em settings.gradle.kts (rootProject.name = "NomeNovo")
        * mudei o application id para um novo no build.gradle.kts a nivel de modulo (applicationId = "br.guilherme.nome novo")
        * mudei o nome do app no celular em res/values/strings (<string name="novo_app">Minhas Tarefas</string>)
        * renomeei e refatorei os pacotes e fiz algumas mudanças nas views para obter os resultados desejados
        * NÃO MUDEI NOMES DE CLASSES AINDA ESTÃO COMO FILMES*/


    }



}