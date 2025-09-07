package com.example.listacontatos.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listacontatos.R
import com.example.listacontatos.dao.ContatosDAO
import com.example.listacontatos.view.recycler.adapter.ContatoAdapter

class ListaContatosActivity : AppCompatActivity(R.layout.activity_lista_contatos) {
    private val contatosDAO = ContatosDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rvContatos = findViewById<RecyclerView>(R.id.rv_contatos)
        val contatos = contatosDAO.get()

        rvContatos.layoutManager = LinearLayoutManager(this)
        rvContatos.adapter = ContatoAdapter(contatos)
    }
}