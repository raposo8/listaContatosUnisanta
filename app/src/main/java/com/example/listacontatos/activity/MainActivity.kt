package com.example.listacontatos.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.listacontatos.R
import com.example.listacontatos.dao.UsuarioDAO
import com.example.listacontatos.model.Usuario

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val usuarioDAO = UsuarioDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtWhatsapp = findViewById<EditText>(R.id.edt_whatsapp)
        val edtLinkImagem = findViewById<EditText>(R.id.edt_link_imagem)

        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        val txvVerUsuarios = findViewById<TextView>(R.id.txv_ver_usuarios)

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val whatsapp = edtWhatsapp.text.toString()
            val linkImagem = edtLinkImagem.text.toString()

            val usuario = Usuario(nome, whatsapp, linkImagem)

            try {
                usuarioDAO.add(usuario)

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

        txvVerUsuarios.setOnClickListener {
            //val intent = Intent(this, )
            //startActivity(intent)
        }
    }
}