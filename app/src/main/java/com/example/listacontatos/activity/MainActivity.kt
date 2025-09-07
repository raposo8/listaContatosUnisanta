package com.example.listacontatos.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.listacontatos.R
import com.example.listacontatos.dao.ContatosDAO
import com.example.listacontatos.model.Contato

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val contatosDAO = ContatosDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtWhatsapp = findViewById<EditText>(R.id.edt_whatsapp)
        val edtLinkImagem = findViewById<EditText>(R.id.edt_link_imagem)

        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        val txvVerContatos = findViewById<TextView>(R.id.txv_ver_contatos)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val whatsapp = edtWhatsapp.text.toString()
            val linkImagem = edtLinkImagem.text.toString()

            val contato = Contato(nome, whatsapp, linkImagem)

            try {
                contatosDAO.add(contato)

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Sucesso")
                builder.setMessage("Contato cadastrado com sucesso")
                val dialog = builder.create()
                dialog.show()

                edtNome.text.clear()
                edtWhatsapp.text.clear()
                edtLinkImagem.text.clear()
            } catch (e: IllegalArgumentException) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage(e.message)
                val dialog = builder.create()
                dialog.show()
            }
        }

        txvVerContatos.setOnClickListener {
            val intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }
    }
}