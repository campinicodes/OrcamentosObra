package com.example.orcamentosobra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogoDeMateriais : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_catalogo_de_materiais)
        val recycler = findViewById<RecyclerView>(R.id.recyclerProdutos)
        recycler.layoutManager = LinearLayoutManager(this)
        val finalizarCompra = findViewById<Button>(R.id.finalizarCompra)
        recycler.adapter = ProdutoAdapter(Catalogo.produtos)
        finalizarCompra.setOnClickListener {
            val intento = Intent(this, Carrinho::class.java)
            startActivity(intento)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}