package br.com.etecia.barbershop.view

import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.etecia.barbershop.R
import br.com.etecia.barbershop.databinding.ActivityAgendamentoBinding
import br.com.etecia.barbershop.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Agendamento : AppCompatActivity() {


    private lateinit var binding: ActivityAgendamentoBinding
    private val  calendar: Calendar = Calendar.getInstance()
    private var data: String = ""
    private var hora: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_YEAR, dayOfMonth)

            var dia = dayOfMonth.toString()
            var mes = (monthOfYear + 1).toString() // Inicialize com o valor do mês

            if (dayOfMonth < 10) {
                dia = "0$dayOfMonth"
            }
            if (monthOfYear + 1 < 10) {
                mes = "0${monthOfYear + 1}"
            }

            data = "$dia / $mes / $year"
        }


        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val minuto: String

            if(minute <10){
                minuto = "0$minute"
            } else{
                minuto = minute.toString()
            }
            hora = "$hourOfDay:$minuto"
        }
        binding.timePicker.setIs24HourView(true)

        binding.btAgendar.setOnClickListener {

            val barbeiro1 = binding.barbeiro1
            val barbeiro2 = binding.barbeiro2
            val barbeiro3 = binding.barbeiro3
            val barbeiro4 = binding.barbeiro4

            when {
                hora.isEmpty() ->{
                    mensagem(it,"Preencha o Horário", "#FF0000")
                }
                hora < "8:00" && hora > "20:00" -> {
                    mensagem(it,"Barbeiro Indisponivel - atendimento das 08:00 as 20:00", "#FF0000")
                }
                data.isEmpty() ->{
                    mensagem(it,"Coloque uma data!", "#FF0000")
                }
                barbeiro1.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it,"Agendamento Realizado com Sucesso!", "#FF03DAC")
                }
                barbeiro2.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it,"Agendamento Realizado com Sucesso!", "#FF03DAC")
                }
                barbeiro3.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it,"Agendamento Realizado com Sucesso!", "#FF03DAC")
                }
                barbeiro4.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it,"Agendamento Realizado com Sucesso!", "#FF03DAC")
                }
                else -> {
                    mensagem(it,"Escolha um Barbeiro!", "#FF03DAC")
                }
            }
        }
    }

    private fun mensagem(view: View, mensagem: String, cor: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setActionTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }

}
