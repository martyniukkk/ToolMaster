package com.tool.master.domain.repository

import com.tool.master.domain.model.Todo
import com.tool.master.domain.model.TodoList

interface TodoRepository {

    fun getTodoList(): TodoList

    fun saveTodo(todo: Todo): Boolean

    fun removeTodo(todo: Todo): Boolean

    fun updateTodo(todo: Todo): Boolean
}