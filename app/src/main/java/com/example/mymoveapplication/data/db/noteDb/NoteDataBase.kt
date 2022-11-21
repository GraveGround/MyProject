package com.example.mymoveapplication.data.db.noteDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymoveapplication.data.db.dao.NoteDao
import com.example.mymoveapplication.data.db.noteEntity.NoteEntity


//Сменить версию при любом изменении Room комонентов после запуска приложения
@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
//
//    val dataBase =
//
//    val userDao = dataBase.getNoteDao()
//    val users: List<NoteEntity> = userDao.getAllNotes()

}

