package com.tool.master.data.todo_storage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.tool.master.data.todo_storage.dto.TodoDto

class TodoDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "todo_database.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "todos"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TEXT = "text"
        private const val COLUMN_IS_CHECKED = "isChecked"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_TEXT TEXT UNIQUE,"
                + "$COLUMN_IS_CHECKED INTEGER)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    private fun getMaxId(): Int {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT MAX($COLUMN_ID) FROM $TABLE_NAME", null)
        var maxId = 0
        if (cursor.moveToFirst()) {
            maxId = cursor.getInt(0)
        }
        cursor.close()
        return maxId
    }

    fun insertTodo(todo: TodoDto): Boolean {
        val db = this.writableDatabase
        val newId = maxOf(getMaxId() + 1, 5)
        val values = ContentValues().apply {
            put(COLUMN_ID, newId)
            put(COLUMN_TEXT, todo.text)
            put(COLUMN_IS_CHECKED, if (todo.isChecked) 1 else 0)
        }
        val result = db.insert(TABLE_NAME, null, values)
        return result != -1L
    }

    fun updateTodo(todo: TodoDto): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TEXT, todo.text)
            put(COLUMN_IS_CHECKED, if (todo.isChecked) 1 else 0)
        }
        val result = db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(todo.id.toString()))
        return result > 0
    }

    fun deleteTodo(todo: TodoDto): Boolean {
        val db = this.writableDatabase
        val result = db.delete(TABLE_NAME, "$COLUMN_TEXT=?", arrayOf(todo.text))
        return result > 0
    }

    fun getAllTodos(): List<TodoDto> {
        val todoList = mutableListOf<TodoDto>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val columnId = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val text = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXT))
                val isChecked = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IS_CHECKED)) == 1
                todoList.add(TodoDto(columnId.toInt(), text, isChecked))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return todoList
    }
}