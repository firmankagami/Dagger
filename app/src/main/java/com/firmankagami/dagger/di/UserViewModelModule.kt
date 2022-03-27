package com.firmankagami.dagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firmankagami.dagger.utils.ViewModelKey
import com.firmankagami.dagger.viewmodel.UserViewModel
import com.firmankagami.dagger.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindViewModel(viewModel: UserViewModel): ViewModel
}