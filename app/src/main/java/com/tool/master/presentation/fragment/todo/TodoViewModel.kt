package com.tool.master.presentation.fragment.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel(
    private val getTodoListUseCase: com.tool.master.domain.usecase.todo.GetTodoListUseCase,
    private val removeTodoUseCase: com.tool.master.domain.usecase.todo.RemoveTodoUseCase,
    private val saveTodoUseCase: com.tool.master.domain.usecase.todo.SaveTodoUseCase,
    private val updateTodoUseCase: com.tool.master.domain.usecase.todo.UpdateTodoUseCase
) : ViewModel() {

    private val _todoListLive = MutableLiveData<com.tool.master.domain.model.TodoList>()
    val todoListLive: LiveData<com.tool.master.domain.model.TodoList> = _todoListLive

    fun getTodoList() {
        _todoListLive.value = getTodoListUseCase.execute()
    }

    fun removeTodo(todo: com.tool.master.domain.model.Todo) {
        removeTodoUseCase.execute(todo = todo)
        getTodoList()
    }

    fun saveTodo(todo: com.tool.master.domain.model.Todo) {
        saveTodoUseCase.execute(todo = todo)
        getTodoList()
    }

    fun updateTodo(todo: com.tool.master.domain.model.Todo) {
        updateTodoUseCase.execute(todo = todo)
        getTodoList()
    }
}