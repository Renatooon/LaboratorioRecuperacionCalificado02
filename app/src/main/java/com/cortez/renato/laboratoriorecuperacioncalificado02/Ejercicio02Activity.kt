package com.cortez.renato.laboratoriorecuperacioncalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cortez.renato.laboratoriorecuperacioncalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()
    }
    fun observeComponents() {
        binding.btnGuardar.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                goDetailActivity()
            }
        }
    }

    fun goDetailActivity() {
        val fullName = binding.edtNombre.text.toString()
        val phoneNumber= binding.edtNumeroCelular.text.toString()
        val lastName = binding.edtApellidos.text.toString()
        val address = binding.edtDireccion.text.toString()

        val intent = Intent(this, Ejercicio02DetailsActivity::class.java)
        intent.putExtra(FULL_NAME_KEY, fullName)
        intent.putExtra(LASTNAME_KEY, lastName)
        intent.putExtra(PHONE_NUMBER_KEY, phoneNumber)
        intent.putExtra(ADDRESS_KEY, address)
        startActivity(intent)
    }
    fun isEmptyInputs(): Boolean {
        return binding.edtNombre.text.isEmpty() ||
                binding.edtNumeroCelular.text.isEmpty() ||
                binding.edtApellidos.text.isEmpty() ||
                binding.edtDireccion.text.isEmpty()
    }
}