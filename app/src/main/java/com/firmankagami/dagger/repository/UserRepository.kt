package com.firmankagami.dagger.repository

import androidx.lifecycle.LiveData
import com.firmankagami.dagger.model.ResponseUser
import com.firmankagami.dagger.utils.Result

interface UserRepository {
    fun getUserList(page: String): LiveData<Result<ResponseUser>>
}