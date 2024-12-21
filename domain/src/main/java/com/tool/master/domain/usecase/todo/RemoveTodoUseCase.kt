package com.tool.master.domain.usecase.todo

import com.tool.master.domain.repository.TodoRepository
import com.tool.master.domain.model.Todo

class RemoveTodoUseCase(private val todoRepository: TodoRepository) {

    fun execute(todo: Todo): Boolean {
        return todoRepository.removeTodo(todo = todo)
    }
}