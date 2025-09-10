package br.guilherme.listatarefas.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
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
        val txvEstrelas = findViewById<TextView>(R.id.txv_estrelas)
        val sbAvaliacao = findViewById<SeekBar>(R.id.sb_avaliacao)
        val cbAcao = findViewById<CheckBox>(R.id.cb_acao)
        val cbDrama = findViewById<CheckBox>(R.id.cb_drama)
        val cbRomance = findViewById<CheckBox>(R.id.cb_romance)
        val cbTerror = findViewById<CheckBox>(R.id.cb_terror)


        sbAvaliacao.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Este método é chamado sempre que o valor da seekbar muda.
                // O valor atual da seekbar está na variável 'progress'.

                // Você pode usar o valor aqui para atualizar um TextView, por exemplo:
                txvEstrelas.text = "$progress"

                // Exemplo: mostrar o valor no logcat
                //Log.d("SeekBar", "Valor atual: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Este método é chamado quando o usuário começa a arrastar a seekbar.
                // Você pode deixar este método vazio se não precisar de nenhuma ação neste momento.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Este método é chamado quando o usuário solta a seekbar.
                // Você pode usar o valor final aqui se precisar.

                // Por exemplo, você pode salvar o valor no banco de dados.
                val valorFinal = seekBar?.progress
            }
        })




        btnCadastrar.setOnClickListener {
            val nomeF = edtNomeFilme.text.toString()
            val nomeD = edtNomeDiretor.text.toString()
            val avaliacao = txvEstrelas.text.toString().toInt()
            val generos = mutableListOf<String>()
            val checkBoxGeneros = listOf(cbDrama, cbAcao, cbTerror, cbRomance)

            for (checkbox in checkBoxGeneros) {
                if (checkbox.isChecked) {
                    generos.add(checkbox.text.toString())
                }
            }



            val filme = Filme(nomeF, nomeD,generos, avaliacao )
            filmeDao.adicionarFilme(filme)

            edtNomeDiretor.text.clear()
            edtNomeFilme.text.clear()

            //pra fazer uma mensagem de feedback do cadastro
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastro de filme OK")
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