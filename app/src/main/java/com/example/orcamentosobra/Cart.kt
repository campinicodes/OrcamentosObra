package com.example.orcamentosobra

object Cart {
    val produtos = mutableListOf<Produto>()

    fun adicionar(produto: Produto) {
        produtos.add(produto)
    }
    fun total() : Double {
        return produtos.sumOf { it.preco }
    }
}