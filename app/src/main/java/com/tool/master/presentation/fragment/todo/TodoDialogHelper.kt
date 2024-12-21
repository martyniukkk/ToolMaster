package com.tool.master.presentation.fragment.todo

import com.kongzue.dialogx.dialogs.InputDialog
import com.kongzue.dialogx.dialogs.PopTip
import com.kongzue.dialogxmaterialyou.style.MaterialYouStyle

object TodoDialogHelper {

    fun showInputDialog(
        title: String,
        okText: String,
        inputText: String = "",
        todoAction: (String) -> Unit
    ) {
        val dialog = InputDialog.build()
        dialog.style = MaterialYouStyle()
        dialog.title = title
        dialog.inputText = inputText
        dialog.inputHintText = "To do"
        dialog.setOkButton(okText) { _, _ ->
            if (dialog.inputText.isNotEmpty()) {
                todoAction(dialog.inputText)
                dialog.dismiss()
            } else {
                PopTip.show("Please enter some text first")
            }
            true
        }
        dialog.setCancelButton("Cancel") { _, _ ->
            dialog.dismiss()
            true
        }
        dialog.show()
    }
}