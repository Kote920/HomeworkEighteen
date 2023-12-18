package com.example.homeworkeighteen.Users

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.homeworksixteen.network.Network
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UsersViewModel() : ViewModel() {

    private val _pagingDataFlow = MutableStateFlow<PagingData<User>>(PagingData.empty())
    val pagingDataFlow: StateFlow<PagingData<User>> = _pagingDataFlow

    fun getUsers() {
        Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {UsersRepository().getUsersPagingSource()}
        ).flow
            .cachedIn(viewModelScope)
            .onEach { pagingData ->
                _pagingDataFlow.value = pagingData
            }
            .launchIn(viewModelScope)
    }
}