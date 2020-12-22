package com.example.calculadora

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_historico.*

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)


        val listaCalculos: MutableList<Calculo>? = intent.getParcelableExtra<HistoricoCalculos>("testeObjeto")?.listaCalculos

        if(listaCalculos != null) {
            val adapterCalculos = ArrayAdapter<Calculo>(
                this,
                android.R.layout.simple_list_item_1,
                listaCalculos
            )
            lvCalculos.adapter = adapterCalculos
        }

        lvCalculos.setOnItemClickListener { parent, view, position, _ ->
            val txt = (view as TextView).text
            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
        }
    }
}