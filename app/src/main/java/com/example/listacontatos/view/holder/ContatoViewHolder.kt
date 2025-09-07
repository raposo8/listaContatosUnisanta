package com.example.listacontatos.view.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listacontatos.R

class ContatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgPerfil = itemView.findViewById<ImageView>(R.id.img_perfil)
    val txvNome = itemView.findViewById<TextView>(R.id.txv_nome)
    val txvWhatsapp = itemView.findViewById<TextView>(R.id.txv_whatsapp)
}