package com.manuellugodev.datacrmapp.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuellugodev.datacrmapp.data.repository.LoginRepository
import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.domain.vo.LoginResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult<LoginUser>>()
    val loginResult: LiveData<LoginResult<LoginUser>> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loginResult.postValue(LoginResult.Loading())
            try {
                val token=challenge(username)

                val result = loginRepository.loginUser(username,password,token)

                _loginResult.postValue(result)


            }catch (e:Exception){
                _loginResult.postValue(LoginResult.Failure(e))

            }
        }
    }

    private suspend fun challenge(username: String):String{

        val resultToken=loginRepository.getToken(username)
        return if(resultToken is DataResult.Success){
            resultToken.data.token
        }else{
            ""
        }

    }


}