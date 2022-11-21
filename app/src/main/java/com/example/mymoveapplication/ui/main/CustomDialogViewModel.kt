package com.example.mymoveapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoveapplication.data.db.noteEntity.NoteEntity
import com.example.mymoveapplication.domain.usecase.GetMovieSaveCommentUseCase
import com.example.mymoveapplication.domain.usecase.GetNoteRepoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CustomDialogViewModel(
    private val getNoteRepoUseCase: GetNoteRepoUseCase,
    private val getMovieSaveCommentUseCase: GetMovieSaveCommentUseCase
): ViewModel() {

    private val _dialogLiveData: MutableLiveData<String> = MutableLiveData()
    val dialogLiveData: LiveData<String>
        get() = _dialogLiveData


}
//
//    fun dialogLiveData(){
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val getAllNotes = getNoteRepoUseCase.execute()
//                _dialogLiveData.postValue(getAllNotes)
//            } catch (e:Exception){
//
//            }
//            withContext(Dispatchers.Main){
//                    _dialogLiveData.value = getNoteRepoUseCase.execute()
//            }
//        }
//    }
