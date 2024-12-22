package com.tool.master.domain.usecase.todo

import com.tool.master.domain.model.TodoList
import com.tool.master.domain.repository.TodoRepository

class GetTodoListUseCase(private val todoRepository: TodoRepository) {

    fun execute(): TodoList {
        return todoRepository.getTodoList()
    }
}