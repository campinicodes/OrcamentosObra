package com.example.orcamentosobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class LogActivity : AppCompatActivity() {

    private val TAG = "ciclo_vida"

    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf(".")+1)
        }

}