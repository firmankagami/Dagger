package com.firmankagami.dagger.viewmodel

import androidx.lifecycle.ViewModel
import com.firmankagami.dagger.repository.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor (
    private val userRepository: UserRepository
    ): ViewModel() {

    fun getUserList(page: String) = userRepository.getUserList(page)
}