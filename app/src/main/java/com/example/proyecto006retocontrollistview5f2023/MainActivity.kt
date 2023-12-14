package com.example.proyecto006retocontrollistview5f2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val button=findViewById<Button>(R.id.button)
        val tv1=findViewById<TextView>(R.id.tv1)
        val list1=findViewById<ListView>(R.id.list1)
        val tareas = mutableListOf<String>()
        val mensajes = mutableListOf<String>()
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tareas)
        list1.adapter = adaptador1
        button.setOnClickListener {
            val nuevaTarea = et1.text.toString().trim()
            val nuevomensaje = et2.text.toString().trim()

            if (nuevaTarea.isNotEmpty()){
                tareas.add(nuevaTarea)
                adaptador1.notifyDataSetChanged()
                mensajes.add(nuevomensaje)
            }
            }
        list1.setOnItemClickListener { adapterView, view, i, l ->
            tv1.text = "Se entrega el: ${mensajes[i]}"
        }
    }
}