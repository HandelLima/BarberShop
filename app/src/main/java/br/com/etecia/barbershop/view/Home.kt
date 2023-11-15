package br.com.etecia.barbershop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.etecia.barbershop.R
import br.com.etecia.barbershop.R.*
import br.com.etecia.barbershop.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val_nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text ="Bem-vindo(a),$nome"
    }
}