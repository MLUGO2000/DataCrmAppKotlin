package com.manuellugodev.datacrmapp.presentation.ui.login


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.manuellugodev.datacrmapp.presentation.ui.contacts.MainActivity

import com.manuellugodev.datacrmapp.data.repository.LoginRepository
import com.manuellugodev.datacrmapp.data.repository.LoginRepositoryImpl
import com.manuellugodev.datacrmapp.databinding.ActivityLoginBinding
import com.manuellugodev.datacrmapp.domain.login.LoginUser
import com.manuellugodev.datacrmapp.domain.vo.LoginResult
import com.manuellugodev.datacrmapp.framework.DataCrmApp
import com.manuellugodev.datacrmapp.framework.di.AppComponent
import javax.inject.Inject
import javax.inject.Named


class LoginActivity : AppCompatActivity() {

    @Inject
    @Named("loginRepository")
    lateinit var repository: LoginRepositoryImpl

    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel by viewModels<LoginViewModel>{LoginViewModelProvider(repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)

        (applicationContext as DataCrmApp).appComponent.inject(this)

        loginViewModel

        val view=binding.root

        setContentView(view)

        binding.login.setOnClickListener { sendLogin()}

        loginViewModel.loginResult.observe(this, ::updateUiLogin)

        }

    private fun sendLogin(){
        val userName=binding.username.text.toString()
        val password=binding.password.text.toString()

        loginViewModel.login(userName,password)
    }

    private fun updateUiLogin(loginResult: LoginResult<LoginUser>?) {

        when(loginResult){

            is LoginResult.Loading->{
                showProgress()
            }

            is LoginResult.Success->{
                hideProgress()
                val bundle=Bundle()
                val intent=Intent(this,MainActivity::class.java)
                intent.putExtra("sessionName",loginResult.user.sessionName)
                startActivity(intent)

            }

            is LoginResult.Failure->{
                hideProgress()
                showMessage("Ocurrio un Error : ${loginResult.e.message}" )
            }

        }

    }

    private fun showProgress(){

        binding.loadingLogin.visibility = View.VISIBLE

    }
    private fun hideProgress(){

        binding.loadingLogin.visibility = View.GONE
    }

    private fun showMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }


}

