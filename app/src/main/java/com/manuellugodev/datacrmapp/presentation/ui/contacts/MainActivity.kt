package com.manuellugodev.datacrmapp.presentation.ui.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.manuellugodev.datacrmapp.data.repository.ContactsRepository
import com.manuellugodev.datacrmapp.data.repository.ContactsRepositoryImpl
import com.manuellugodev.datacrmapp.databinding.ActivityMainBinding
import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import com.manuellugodev.datacrmapp.framework.DataCrmApp
import com.manuellugodev.datacrmapp.framework.di.AppComponent

import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapterContacts: AdapterContacts

    @Inject
    @Named("contactsRepository")
    lateinit var repository: ContactsRepositoryImpl
    

    private val viewModelContacts by viewModels<ContactsViewModel> { ContactsViewModelProvider(repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as DataCrmApp).appComponent.inject(this)

        val sessionName:String=intent.extras!!.getString("sessionName","")

        if(sessionName.isNotEmpty()){
            viewModelContacts.getContacts(sessionName)
        }



        binding= ActivityMainBinding.inflate(layoutInflater)

        (applicationContext as DataCrmApp).appComponent.inject(this)

        adapterContacts= AdapterContacts(this)

        val view=binding.root
        setContentView(view)

        binding.RecyclerViewContacts.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.RecyclerViewContacts.adapter=adapterContacts
        viewModelContacts.statusContacts.observe(this,::updateUiContacts)
        

    }

    private fun updateUiContacts(dataResult: DataResult<List<Contact>>?) {
        when(dataResult){

            is DataResult.Loading->{
                showProgress()
            }
            is DataResult.Success->{
                hideProgress()
                adapterContacts.updateDataList(dataResult.data)

            }
            is DataResult.Failure->{
                hideProgress()
                showMessage(dataResult.e.message)

            }
        }
    }

    private fun showProgress(){

        binding.loadingContacts.visibility=View.VISIBLE

    }
    private fun hideProgress(){
        binding.loadingContacts.visibility=View.GONE
    }

    private fun showMessage(message:String?){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}