package com.example.mymoveapplication.data.db.noteRepository

import com.example.mymoveapplication.data.db.dao.NoteDao
import com.example.mymoveapplication.data.db.noteEntity.NoteEntity

class NoteRealisation(
    private val noteDao: NoteDao
): NoteRepository {
    override suspend fun allNote(): List<NoteEntity>{
        val allNote = noteDao.getAllNotes()
        return allNote
//        get() = noteDao.getAllNotes()
    }


    override suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }
}