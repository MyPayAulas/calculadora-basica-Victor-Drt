package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    val historico = HistoricoCalculos(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        btHistorico.setOnClickListener {
            val intent = Intent(this, HistoricoActivityCustomizada::class.java)

            historico.listaCalculos.add(Calculo("${txtExpressao.text}", "${txtResultado.text}"))
            intent.putExtra("testeObjeto", historico)
            startActivity(intent)

        }

        //LISTENER DOS NUMEROS
        numero_zero.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "0",
                limpar_dados = true
            )
        }
        numero_um.setOnClickListener { AcrescentarUmaExpressao(string = "1", limpar_dados = true) }
        numero_dois.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "2",
                limpar_dados = true
            )
        }
        numero_tres.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "3",
                limpar_dados = true
            )
        }
        numero_quatro.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "4",
                limpar_dados = true
            )
        }
        numero_cinco.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "5",
                limpar_dados = true
            )
        }
        numero_seis.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "6",
                limpar_dados = true
            )
        }
        numero_sete.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "7",
                limpar_dados = true
            )
        }
        numero_oito.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "8",
                limpar_dados = true
            )
        }
        numero_nove.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "9",
                limpar_dados = true
            )
        }
        ponto.setOnClickListener { AcrescentarUmaExpressao(string = ".", limpar_dados = true) }

        //LISTENER DOS OPERADORES
        adicao.setOnClickListener { AcrescentarUmaExpressao(string = "+", limpar_dados = false) }
        subtracao.setOnClickListener { AcrescentarUmaExpressao(string = "-", limpar_dados = false) }
        multiplicacao.setOnClickListener {
            AcrescentarUmaExpressao(
                string = "*",
                limpar_dados = false
            )
        }
        divisao.setOnClickListener { AcrescentarUmaExpressao(string = "/", limpar_dados = false) }

        //LISTENER DOS BOTOES DE APAGAR
        limpar.setOnClickListener {
            txtExpressao.text = ""
            txtResultado.text = ""
        }

        backspace.setOnClickListener {

            val string = txtExpressao.text.toString()
            if (string.isNotBlank()) {
                txtExpressao.text = string.substring(0, string.length - 1)
            }
            txtResultado.text = ""
        }

        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(txtExpressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val resultadoLong = resultado.toLong()

                if (resultado == resultadoLong.toDouble()) {
                    txtResultado.text = resultadoLong.toString()
                } else {
                    txtResultado.text = resultado.toString()
                }
            } catch (e: Exception) {

            }
        }
    }

    fun AcrescentarUmaExpressao(string: String, limpar_dados: Boolean) {

        if (txtResultado.text.isNotEmpty()) {
            txtExpressao.text = ""
        }

        if (limpar_dados) {
            txtResultado.text = ""
            txtExpressao.append(string)
        } else {
            txtExpressao.append(txtResultado.text)
            txtExpressao.append(string)
            txtResultado.text = ""
        }
    }
}
