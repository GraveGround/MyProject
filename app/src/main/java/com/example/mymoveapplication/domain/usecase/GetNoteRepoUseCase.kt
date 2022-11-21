package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.db.noteEntity.NoteEntity
import com.example.mymoveapplication.data.db.noteRepository.NoteRepository

class GetNoteRepoUseCase(

    private val noteRepo: NoteRepository
) {
    suspend fun execute(): List<NoteEntity>{
        return noteRepo.allNote()
    }

}