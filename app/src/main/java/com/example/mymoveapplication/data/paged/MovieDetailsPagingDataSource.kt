package com.example.mymoveapplication.data.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mymoveapplication.data.net.RetrofitServieces
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieResponse

class MovieDetailsPagingDataSource(
//    private val movieService: RetrofitServieces,
    val movieRetrofitData: suspend (page:Int) -> MovieResponse
) : PagingSource<Int, MovieData>() {

    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {

        return try {


            val nextPageNumber = params.key ?: 1
            val response = movieRetrofitData(nextPageNumber)
            val data = response.results

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                //nextKey = response.page!! + 1
                nextKey = nextPageNumber.plus(1)
//                prevKey = if (nextPageNumber == 1) {
//                    null
//                } else nextPageNumber - 1,
//                nextKey = response.page!! + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
