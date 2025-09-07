package com.example.listacontatos.dao

import com.example.listacontatos.model.Contato

class ContatosDAO {
    companion object {
        val contatos = mutableListOf<Contato>()
    }

    fun get(): MutableList<Contato> {
        return contatos
    }

    fun has(whatsapp: String): Boolean {
        return contatos.any { it.whatsapp == whatsapp }
    }

    fun add(contato: Contato) {
        if (!contato.whatsapp.matches(Regex("^\\d+\$"))) {
            throw IllegalArgumentException("O WhatsApp deve conter apenas números")
        }

        if (has(contato.whatsapp)) {
            throw IllegalArgumentException("Contato com WhatsApp ${contato.whatsapp} já existe")
        }

        contatos.add(contato)
    }
}