package com.example.mymoveapplication.data.db.noteRepository

import com.example.mymoveapplication.data.db.noteEntity.NoteEntity

interface NoteRepository {

    suspend fun allNote(): List<NoteEntity>
    suspend fun insertNote(noteEntity: NoteEntity)
}