package com.tool.master.data.todo_storage

import android.content.Context
import com.tool.master.data.todo_storage.dto.TodoDto
import com.tool.master.data.todo_storage.dto.TodoListDto

class TodoStorageImpl(context: Context) : TodoStorage {

    private val dbHelper = TodoDatabaseHelper(context)

    override fun getTodoList(): TodoListDto {
        return TodoListDto(list = dbHelper.getAllTodos())
    }

    override fun saveTodo(todoDto: TodoDto): Boolean {
        return dbHelper.insertTodo(todoDto)
    }

    override fun removeTodo(todoDto: TodoDto): Boolean {
        return dbHelper.deleteTodo(todoDto)
    }

    override fun updateTodo(todoDto: TodoDto): Boolean {
        return dbHelper.updateTodo(todoDto)
    }
}