package com.firmankagami.dagger.di

import com.firmankagami.dagger.repository.UserRepository
import com.firmankagami.dagger.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(repo: UserRepositoryImpl): UserRepository

}