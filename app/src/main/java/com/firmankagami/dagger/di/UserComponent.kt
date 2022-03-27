package com.firmankagami.dagger.di

import com.firmankagami.dagger.MainActivity
import dagger.Component

@Component(
    modules = [
        UserModule::class,
        UserRepositoryModule::class,
        UserViewModelModule::class
    ]
)
interface UserComponent {
    fun inject(activity: MainActivity)
}