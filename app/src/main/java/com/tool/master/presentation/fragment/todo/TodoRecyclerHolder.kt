package com.tool.master.presentation.fragment.todo

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tool.master.R

class TodoRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text: TextView = itemView.findViewById(R.id.text)
    val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)
    val root: View = itemView.findViewById(R.id.root)
}