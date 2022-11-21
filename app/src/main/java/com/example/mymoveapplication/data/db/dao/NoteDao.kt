package com.example.mymoveapplication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymoveapplication.data.db.noteEntity.NoteEntity


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteEntity: NoteEntity)

    @Query("SELECT * from note_table")
    fun getAllNotes(): List<NoteEntity>
}