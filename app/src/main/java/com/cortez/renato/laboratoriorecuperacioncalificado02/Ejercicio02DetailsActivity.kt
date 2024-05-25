package com.cortez.renato.laboratoriorecuperacioncalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cortez.renato.laboratoriorecuperacioncalificado02.databinding.ActivityEjercicio02DetailsBinding

class Ejercicio02DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02DetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02DetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()
        intent.extras?.let {
            showData(it)
        }
    }
    private fun showData(paramExtras: Bundle) {
        val nombreCliente = paramExtras.getString(FULL_NAME_KEY)
        val phone = paramExtras.getString(PHONE_NUMBER_KEY)
        val apellidos = paramExtras.getString(LASTNAME_KEY)
        val direccion = paramExtras.getString(ADDRESS_KEY)

        binding.tvnombre.text = nombreCliente
        binding.tvPhoneNumber.text = phone
        binding.tvApellidos.text = apellidos
        binding.tvAddress.text = direccion
    }

    private fun listenerComponentUi() {
        binding.btnPhone.setOnClickListener {
            Call()
        }
        binding.btnWsp.setOnClickListener {
            WhatsappMessage()
        }
        binding.btnMap.setOnClickListener {
            abrirEnGoogleMaps(binding.tvAddress.text.toString())
        }
    }

    private fun WhatsappMessage() {
        val phoneNumber = binding.tvPhoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }

    private fun Call() {
        val phoneNumber = binding.tvPhoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }

    private fun abrirEnGoogleMaps( lugar: String) {
        if ( lugar.isBlank()) {
            Log.e("Maps", "Localidad o lugar están vacíos")
            return
        }

        val lugarFormateado = lugar.replace(" ", "+")

        val uri = Uri.parse("geo:0,0?q=+$lugarFormateado")
        Log.d("Maps", "URI: $uri")

        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage("com.google.android.apps.maps")
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Google Maps no está instalado. Por favor, instálelo para usar esta función.", Toast.LENGTH_LONG).show()
        }
    }
}