package com.manuellugodev.datacrmapp.presentation.ui.contacts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuellugodev.datacrmapp.data.repository.ContactsRepository
import com.manuellugodev.datacrmapp.domain.contact.Contact
import com.manuellugodev.datacrmapp.domain.vo.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsViewModel(private val repository: ContactsRepository):ViewModel() {

    private val _statusContacts=MutableLiveData<DataResult<List<Contact>>>()
    val statusContacts get() = _statusContacts

    private val _statusNumberContacts=MutableLiveData<DataResult<Int>>()
    val statusNumberContacts get() = _statusNumberContacts

    fun getContacts(sessionName:String){
        viewModelScope.launch(Dispatchers.IO) {
            _statusContacts.postValue(DataResult.Loading())
            try {

                val result=repository.getContancts(sessionName)

                _statusContacts.postValue(result)

            }catch (e:Exception){

                _statusContacts.postValue(DataResult.Failure(e))

                Log.e("Error",e.message.toString())
            }
        }
    }

    fun getNumberContacts(sessionName: String){
        viewModelScope.launch(Dispatchers.IO){

            try {
                val resultNumber=repository.getNumberContacts(sessionName)

                _statusNumberContacts.postValue(resultNumber)
            }catch (e:Exception){

                _statusNumberContacts.postValue(DataResult.Failure(e))
            }
        }
    }

}