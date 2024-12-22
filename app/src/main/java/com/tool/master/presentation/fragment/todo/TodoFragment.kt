package com.tool.master.presentation.fragment.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tool.master.databinding.FragmentTodoBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class TodoFragment : Fragment() {

    private lateinit var binding: FragmentTodoBinding
    private val viewModel by activityViewModel<TodoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoBinding.inflate(layoutInflater)
        viewModel.getTodoList()
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        viewModel.todoListLive.observe(viewLifecycleOwner) { todoList ->
            val completedTasksAmount = todoList.list.count { it.isChecked }
            binding.completed.text = completedTasksAmount.toString()
            binding.tasks.text = todoList.list.size.toString()
            binding.emptyText.isVisible = todoList.list.isEmpty()
            binding.recycler.adapter = TodoRecyclerAdapter(requireContext(), todoList, viewModel)
        }

        binding.buttonAdd.setOnClickListener {
            TodoDialogHelper.showInputDialog("Add item", "Add") { inputText ->
                viewModel.saveTodo(
                    todo = com.tool.master.domain.model.Todo(
                        text = inputText,
                        isChecked = false
                    )
                )
            }
        }
        return binding.root
    }
}