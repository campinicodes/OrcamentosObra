package com.example.orcamentosobra

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView

class Carrinho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carrinho)
        val txtProdutos = findViewById<TextView>(R.id.txtProdutos)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        val lista = intent.getStringExtra("lista")
        val total = intent.getDoubleExtra("total", 0.0)

        txtProdutos.text = lista
        txtTotal.text = "Total: R$ %.2f".format(total)

        val btnConfirmar = findViewById<Button>(R.id.confirmarCompra)
        btnConfirmar.setOnClickListener {
            val intent = Intent(this, Finalizacao::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}