package br.guilherme.listatarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.guilherme.listatarefas.R
import br.guilherme.listatarefas.model.Filme

class FilmeAdapter(private val filmes: List<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNomeF: TextView = itemView.findViewById(R.id.txv_nome_filme)
        val txvNomeD: TextView = itemView.findViewById(R.id.txv_nome_diretor)
        val cbConcluida: CheckBox = itemView.findViewById<CheckBox>(R.id.cb_concluida) //Importei o checkbox
        val txvGeneros: TextView = itemView.findViewById<TextView>(R.id.txv_generos)
        val txvAvaliacao: TextView = itemView.findViewById<TextView>(R.id.txv_avaliacao)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val filme = filmes[position]
        holder.txvNomeF.text = "Titulo: " + filme.nomeFilme
        holder.txvNomeD.text = "Diretor: " + filme.diretorFilme

        holder.txvGeneros.text = "Generos: " + filme.generos.toString()
        holder.txvAvaliacao.text = filme.avaliacao.toString() + " Estrelas"

        holder.cbConcluida.isChecked = filme.concluida //defini o estado inicial do checkbox
        holder.cbConcluida.setOnCheckedChangeListener { _, isChecked -> //precisa disso aqui pra fazer o listener de mudança do cb funcionar
            filme.concluida = isChecked //Atualiza a propriedade 'concluida' do objeto Filme na lista
        }

    }

    override fun getItemCount(): Int {
        return filmes.size
    }







}