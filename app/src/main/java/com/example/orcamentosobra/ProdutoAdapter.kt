package com.example.orcamentosobra

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProdutoAdapter(
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nome = itemView.findViewById<TextView>(R.id.txtNome)
        val descricao = itemView.findViewById<TextView>(R.id.txtDescricao)
        val preco = itemView.findViewById<TextView>(R.id.txtPreco)
        val botao = itemView.findViewById<Button>(R.id.btnAdicionar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)

        return ProdutoViewHolder(view)
    }

    override fun getItemCount() = produtos.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        val produto = produtos[position]

        holder.nome.text = produto.nome
        holder.descricao.text = produto.descricao
        holder.preco.text = "R$ %.2f".format(produto.preco)

        holder.botao.setOnClickListener {

            Cart.adicionar(produto)

            Toast.makeText(
                holder.itemView.context,
                "${produto.nome} adicionado",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}