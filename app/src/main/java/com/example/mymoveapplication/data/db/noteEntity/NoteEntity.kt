package com.example.mymoveapplication.data.db.noteEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class NoteEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo var noteTitle: String = "",
    @ColumnInfo var noteDescription: String = ""
)