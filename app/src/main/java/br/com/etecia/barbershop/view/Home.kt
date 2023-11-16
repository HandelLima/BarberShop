package br.com.etecia.barbershop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.etecia.barbershop.R
import br.com.etecia.barbershop.R.*
import br.com.etecia.barbershop.adapter.ServicosAdapter
import br.com.etecia.barbershop.databinding.ActivityHomeBinding
import br.com.etecia.barbershop.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)  // Correção aqui
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem-Vindo(a), $nome"
        val recyclerViewServicos = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()
    }


    private fun getServicos (){

        val servico1 = Servicos (R.drawable.img1,"Corte de Cabelo")
        listaServicos.add(servico1)

        val servico2 = Servicos (R.drawable.img2,"Corte de Barba")
        listaServicos.add(servico2)

        val servico3 = Servicos (R.drawable.img3,"Lavagem de Cabelo")
        listaServicos.add(servico3)

        val servico4 = Servicos (R.drawable.img4,"Tratamento de Cabelo")
        listaServicos.add(servico4)

    }

}