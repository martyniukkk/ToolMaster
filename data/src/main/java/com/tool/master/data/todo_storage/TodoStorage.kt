package com.tool.master.data.todo_storage

import com.tool.master.data.todo_storage.dto.TodoDto
import com.tool.master.data.todo_storage.dto.TodoListDto

interface TodoStorage {

    fun getTodoList(): TodoListDto

    fun saveTodo(todoDto: TodoDto): Boolean

    fun removeTodo(todoDto: TodoDto): Boolean

    fun updateTodo(todoDto: TodoDto): Boolean
}