package com.example.mymoveapplication.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.mymoveapplication.data.paged.MovieDetailsPagingDataSource
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.domain.usecase.GetMovieResponseUseCase
import com.example.mymoveapplication.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieResponseUseCase: GetMovieResponseUseCase
) : ViewModel() {

    private val _movesLD: MutableLiveData<List<MovieData>> = MutableLiveData()
    val movesLD: MutableLiveData<List<MovieData>>
        get() = _movesLD


    private val _errorExp: MutableLiveData<Throwable> = MutableLiveData()
    val errorExp: LiveData<Throwable>
        get() = _errorExp


    val movies: Flow<PagingData<MovieData>> = Pager(PagingConfig(pageSize = 20)) {
        MovieDetailsPagingDataSource { getMovieResponseUseCase.execute(it) }

    }.flow
        .cachedIn(viewModelScope)

    fun moveList(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieDetails = getMoviesUseCase.execute(page)
                _movesLD.postValue(movieDetails)
            }catch (e:Exception){
//                _errorExp.postValue(e)
            }
            withContext(Dispatchers.Main) {
                _movesLD.value = getMoviesUseCase.execute(page)
            }
        }
    }
}


//    fun moveList() {
//        viewModelScope.launch(Dispatchers.IO) {
//            if (!isLoading && !isLastPageLoad) {
//                var gettingMovies: List<MovieData> = listOf()
//                isLoading = true
//                page++
//                try {
//                    gettingMovies = getMoviesUseCase.execute(page)
//                    isLoading = false
//                } catch (e: Exception) {
//                    _errorExp.postValue(e)
//                }
//
//                withContext(Dispatchers.Main) {
//                    val list: MutableList<MovieData> = mutableListOf()
//                    list.addAll(_movesLD.value ?: emptyList())
//                    list.addAll(gettingMovies)
//                    _movesLD.value = list
//                }
//
//            }
//        }
//    }


//        try {
//            val movieList = getMoviesUseCase.execute(page)
//            _movesLD.postValue(movieList)
//        } catch (e: Exception) {
//            _errorExp.postValue(e)
//        }
//        withContext(Dispatchers.Main) {
//            _movesLD.value = getMoviesUseCase.execute(page)
//        }


//    val movies: Flow<PagingData<MovieData>> = Pager(PagingConfig(pageSize = 20)) {
//        MovieDetailsPagingDataSource()
//    }.flow
//        .cachedIn(viewModelScope)

//    fun pagingData(movieService: RetrofitServieces){
//        val movies: Flow<PagingData<MovieData>> = Pager(PagingConfig(pageSize = 20)) {
//            MovieDetailsPagingDataSource(movieService)
//        }.flow
//            .cachedIn(viewModelScope)
//    }


