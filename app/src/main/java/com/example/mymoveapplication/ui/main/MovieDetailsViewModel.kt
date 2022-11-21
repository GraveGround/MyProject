package com.example.mymoveapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.usecase.GetMovieDetailsUseCase
import com.example.mymoveapplication.domain.usecase.GetMovieCommentListUseCase
import com.example.mymoveapplication.domain.usecase.GetMovieSaveCommentUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class MovieDetailsViewModel(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getMovieCommentListUseCase: GetMovieCommentListUseCase,
    private val getMovieSaveCommentUseCase: GetMovieSaveCommentUseCase
) : ViewModel() {

    private val _secondLiveData: MutableLiveData<MovieDetails> = MutableLiveData()
    val secondML: LiveData<MovieDetails>
        get() = _secondLiveData

    private val _commentLiveData: MutableLiveData<List<String>> = MutableLiveData()
    val commentLiveData: MutableLiveData<List<String>>
        get() = _commentLiveData

    fun moveSecondLiveData(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieDetails = getMovieDetailsUseCase.execute(id)
                _secondLiveData.postValue(movieDetails)
            }catch (e:Exception){
//                _errorExp.postValue(e)
            }
            withContext(Dispatchers.Main) {
                _secondLiveData.value = getMovieDetailsUseCase.execute(id)
            }
        }
    }
    fun setMovieComments(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val saveComment = getMovieSaveCommentUseCase.execute(text)
                saveComment.plus(_commentLiveData.value)

            } catch (e: Exception) {
//                _errorExp.postValue(e)
            }
            withContext(Dispatchers.Main) {
                getMovieSaveCommentUseCase.execute(text)
            }
        }
    }

    fun getMovieCommentList(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val commentShared = getMovieCommentListUseCase.execute()
                _commentLiveData.postValue(commentShared)
            }catch (e:Exception){

            }
            withContext(Dispatchers.Main){
                _commentLiveData.value = getMovieCommentListUseCase.execute()
            }
        }
    }
    fun addComment(comment: String) {
        val commentList = ArrayList<String>()
        val currentList = _commentLiveData.value
        if (currentList != null) {
            commentList.addAll(currentList)
        }
        commentList.add(comment)
        _commentLiveData.value = commentList
    }


}
//else {
//    commentList.addAll(ArrayList()) !!!!
//}
//        val currentList = ArrayList<String>(_commentLiveData.value)
//        commentList.addAll(currentList)

//viewModelScope.launch(Dispatchers.IO) {
//    try {
//        val movieCommentDetails = getMoveCommentDetailsUseCase.execute(text)
//        _commentLiveData.value = listOf(text)
//        _commentLiveData.postValue(movieCommentDetails)
//    } catch (e:Exception){
//
//    }
//    withContext(Dispatchers.Main) {
//        _commentLiveData.value = getMoveCommentDetailsUseCase.execute(text)
//    }
//}