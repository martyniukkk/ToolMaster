package com.tool.master.domain.usecase.todo

import com.tool.master.domain.repository.TodoRepository
import com.tool.master.domain.model.TodoList

class GetTodoListUseCase(private val todoRepository: TodoRepository) {

    fun execute(): TodoList {
        return todoRepository.getTodoList()
    }
}