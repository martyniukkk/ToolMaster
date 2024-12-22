package com.tool.master.domain.usecase.todo

import com.tool.master.domain.model.Todo
import com.tool.master.domain.repository.TodoRepository

class SaveTodoUseCase(private val todoRepository: TodoRepository) {

    fun execute(todo: Todo): Boolean {
        return todoRepository.saveTodo(todo = todo)
    }
}