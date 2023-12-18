package com.example.homeworkeighteen.Users

import android.util.Log.d
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homeworkeighteen.service.UsersService

class UsersPagingSource(private val api: UsersService) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = api.getUsers()

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return 0
    }
}