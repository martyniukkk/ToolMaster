package com.tool.master.presentation.fragment.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tool.master.R
import com.tool.master.domain.model.TodoList
import com.kongzue.dialogx.dialogs.MessageDialog
import com.kongzue.dialogxmaterialyou.style.MaterialYouStyle

class TodoRecyclerAdapter(
    private val context: Context,
    private val todoList: com.tool.master.domain.model.TodoList,
    private val todoViewModel: TodoViewModel
) : RecyclerView.Adapter<TodoRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoRecyclerHolder {
        val todoView = LayoutInflater.from(context).inflate(R.layout.todo_item, parent, false)
        return TodoRecyclerHolder(itemView = todoView)
    }

    override fun onBindViewHolder(holder: TodoRecyclerHolder, position: Int) {
        val todo = todoList.list[position]
        holder.text.text = todo.text
        holder.checkBox.isChecked = todo.isChecked
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            todo.isChecked = isChecked
            todoViewModel.updateTodo(todo)
        }
        holder.root.setOnClickListener {
            TodoDialogHelper.showInputDialog("Edit item", "Save", todo.text) { inputText ->
                todo.text = inputText
                todoViewModel.updateTodo(todo)
            }
        }
        holder.root.setOnLongClickListener {
            val dialog = MessageDialog.build()
            dialog.style = MaterialYouStyle()
            dialog.title = "Delete item"
            dialog.message = "Do you really want to delete the item?"
            dialog.setOkButton("Yes") { _, _ ->
                todoViewModel.removeTodo(todo = todo)
                dialog.dismiss()
                true
            }
            dialog.setCancelButton("No") { _, _ ->
                dialog.dismiss()
                true
            }
            dialog.show()
            true
        }
    }

    override fun getItemCount(): Int {
        return todoList.list.size
    }
}