package com.cortez.renato.laboratoriorecuperacioncalificado02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cortez.renato.laboratoriorecuperacioncalificado02.databinding.ActivityEjercicio1Binding

class Ejercicio1Activity : AppCompatActivity() {
    private lateinit var binding:ActivityEjercicio1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()
    }
    private fun listenerComponentUi() {
        binding.btnMostrar.setOnClickListener {
            Mostrar()
        }
        binding.btnOcultar.setOnClickListener {
            Ocultar()
        }
    }
    private fun Mostrar() {
        binding.cardVerde.visibility = View.VISIBLE

    }
    private fun Ocultar() {
        binding.cardVerde.visibility = View.GONE
    }
}

