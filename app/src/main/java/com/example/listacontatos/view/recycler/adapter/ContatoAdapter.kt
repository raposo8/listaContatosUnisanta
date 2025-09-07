package com.example.listacontatos.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listacontatos.model.Contato
import com.example.listacontatos.view.holder.ContatoViewHolder
import com.example.listacontatos.R

class ContatoAdapter(
    private val contatos: MutableList<Contato>
) : RecyclerView.Adapter<ContatoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_contato, parent, false)

        return ContatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = contatos[position]

        Glide
            .with(holder.itemView.context)
            .load(contato.linkImagem)
            .into(holder.imgPerfil)

        holder.txvNome.text = contato.nome
        holder.txvWhatsapp.text = contato.whatsapp
    }

    override fun getItemCount(): Int {
        return contatos.size
    }
}