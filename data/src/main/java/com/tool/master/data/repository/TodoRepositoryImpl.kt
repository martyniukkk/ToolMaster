package com.tool.master.data.repository

import com.tool.master.data.todo_storage.TodoStorage
import com.tool.master.data.todo_storage.dto.TodoDto
import com.tool.master.domain.model.Todo
import com.tool.master.domain.model.TodoList
import com.tool.master.domain.repository.TodoRepository

class TodoRepositoryImpl(private val todoStorage: TodoStorage) : TodoRepository {

    override fun getTodoList(): TodoList {
        val todoList = mutableListOf<Todo>()
        val storageTodoList = todoStorage.getTodoList()
        for (storageTodo in storageTodoList.list) {
            todoList.add(
                Todo(
                    id = storageTodo.id,
                    text = storageTodo.text,
                    isChecked = storageTodo.isChecked
                )
            )
        }
        return TodoList(list = todoList)
    }

    override fun saveTodo(todo: Todo): Boolean {
        val todoDto = TodoDto(id = todo.id, text = todo.text, isChecked = todo.isChecked)
        return todoStorage.saveTodo(todoDto = todoDto)
    }

    override fun removeTodo(todo: Todo): Boolean {
        val todoDto = TodoDto(id = todo.id, text = todo.text, isChecked = todo.isChecked)
        return todoStorage.removeTodo(todoDto = todoDto)
    }

    override fun updateTodo(todo: Todo): Boolean {
        val todoDto = TodoDto(id = todo.id, text = todo.text, isChecked = todo.isChecked)
        return todoStorage.updateTodo(todoDto = todoDto)
    }
}