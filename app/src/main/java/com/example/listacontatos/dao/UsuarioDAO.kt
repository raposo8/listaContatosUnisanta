package com.example.listacontatos.dao

import com.example.listacontatos.model.Usuario

class UsuarioDAO {
    companion object {
        val usuarios = mutableListOf<Usuario>()
    }

    fun get(): MutableList<Usuario> {
        return usuarios
    }

    fun has(whatsapp: String): Boolean {
        return usuarios.any { it.whatsapp == whatsapp }
    }

    fun add(usuario: Usuario) {
        if (!usuario.whatsapp.matches(Regex("^\\d+\$"))) {
            throw IllegalArgumentException("O WhatsApp deve conter apenas números")
        }

        if (has(usuario.whatsapp)) {
            throw IllegalArgumentException("Usuário com WhatsApp ${usuario.whatsapp} já existe")
        }

        usuarios.add(usuario)
    }
}