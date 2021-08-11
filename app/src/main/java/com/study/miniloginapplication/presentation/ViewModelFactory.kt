package com.study.miniloginapplication.presentation

//
//  ViewModelFactory.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.miniloginapplication.data.UserRepositoryImpl
import com.study.miniloginapplication.data.datasource.UserDataSourceImpl
import com.study.miniloginapplication.domain.usecase.GetUserListUseCase
import com.study.miniloginapplication.domain.usecase.GetUserListUseCaseImpl

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val getUserListUseCase: GetUserListUseCase,
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        when (modelClass::class.java) {
            MainViewModel::class.java ->
                MainViewModel(getUserListUseCase)

            else ->
                MainViewModel(getUserListUseCase)
        } as T

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance() =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE
                        ?: ViewModelFactory(
                            getUserListUseCase = GetUserListUseCaseImpl(
                                UserRepositoryImpl(
                                    UserDataSourceImpl()
                                )
                            )
                        )
                }
    }
}
