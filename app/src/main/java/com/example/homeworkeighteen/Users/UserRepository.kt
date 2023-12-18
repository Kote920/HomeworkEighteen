package com.example.homeworkeighteen.Users

import com.example.homeworkeighteen.service.UsersService
import com.example.homeworksixteen.network.Network

class UsersRepository() {
        fun getUsersPagingSource(): UsersPagingSource {
            return UsersPagingSource(Network.apiService())
        }
    }