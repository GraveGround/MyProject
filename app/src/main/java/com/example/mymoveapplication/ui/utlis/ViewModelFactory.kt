package com.example.mymoveapplication.ui.utlis


//class ViewModelFactory() : ViewModelProvider.Factory {
//
//    private val movieRepo: MovieRepo = MovieRepoImpl()
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(GetMoviesUseCase(movieRepo)) as T
//        }else if (modelClass.isAssignableFrom(MainSecondVM::class.java))
//            return MainSecondVM(GetMovieDetailsUseCase(movieRepo)) as T
//
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//
//}
