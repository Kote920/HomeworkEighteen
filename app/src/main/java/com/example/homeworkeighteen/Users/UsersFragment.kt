package com.example.homeworkeighteen.Users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkeighteen.BaseFragment
import com.example.homeworkeighteen.R
import com.example.homeworkeighteen.databinding.FragmentUsersBinding
import com.example.homeworkeighteen.service.UsersService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UsersFragment : BaseFragment<FragmentUsersBinding>(FragmentUsersBinding::inflate) {

    private val viewModel: UsersViewModel by viewModels()
    private lateinit var usersAdapter: UsersRecyclerAdapter


    override fun setUp() {
        setUpRecycler()
        viewModel.getUsers()
        bindObserves()

    }

    override fun listeners() {

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED){
                        viewModel.pagingDataFlow.collect(){
                                usersAdapter.submitData(it)
                        }

                }
        }


    }

    private fun setUpRecycler() {
        usersAdapter = UsersRecyclerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = usersAdapter
    }
//
//    private fun createUsersRepository(): UsersRepository {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://reqres.in/api/")
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//
//        val apiService = retrofit.create(UsersService::class.java)
//
//        return UsersRepository(apiService)
//    }


}