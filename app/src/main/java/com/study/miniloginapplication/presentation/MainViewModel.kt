package com.study.miniloginapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.miniloginapplication.domain.entity.User
import com.study.miniloginapplication.domain.usecase.GetUserListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//
//  MainViewModel.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

class MainViewModel(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel() {

    private val _userList = MutableLiveData<ArrayList<User>>()
    val userList: LiveData<ArrayList<User>>
        get() = _userList

    fun getUserList(size: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getUserListUseCase(size)?.let { data ->
                _userList.postValue(data.results)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}
