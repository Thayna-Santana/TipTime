package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botaoCalcular.setOnClickListener{CalculateTip()}
    }
    fun CalculateTip(){
        val stringInTextField = binding.custoServico.text.toString()
        val custoServico = stringInTextField.toDouble()
        val selecaoId = binding.botaogrupo.checkedRadioButtonId

        val tipoPorcentagem = when (selecaoId){
            R.id.botaoAmazing -> 0.20
            R.id.botaoGood-> 0.18
            else -> 0.15
        }

        var tipo = tipoPorcentagem * custoServico
        val roundUp = binding.Switch.isChecked
        if(roundUp){
            tipo = kotlin.math.ceil(tipo)
        }
        val tipoFormatacao = NumberFormat.getCurrencyInstance().format(tipo)
        binding.Resultado.text = (tipoFormatacao)
        }

}
