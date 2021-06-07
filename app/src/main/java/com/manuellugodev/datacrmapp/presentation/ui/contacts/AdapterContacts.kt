package com.manuellugodev.datacrmapp.presentation.ui.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manuellugodev.datacrmapp.R
import com.manuellugodev.datacrmapp.domain.contact.Contact

class AdapterContacts(private val context: Context):RecyclerView.Adapter<AdapterContacts.MyContactsHolder>() {
    private var listContacts:List<Contact> =listOf()

    fun updateDataList(contacts:List<Contact>){
        listContacts=contacts
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyContactsHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.item_contacts,parent,false)

        return MyContactsHolder(view)
    }

    override fun onBindViewHolder(holder: MyContactsHolder, position: Int) {
       val contact=listContacts[position]

        with(holder){
            idContact.text=contact.id
            contactNo.text=contact.contactNo
            lastNameContact.text=contact.lastName
            createdTime.text=contact.createdTime
        }
    }

    override fun getItemCount(): Int = listContacts.size

    inner class MyContactsHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val idContact:TextView
        val contactNo:TextView
        val lastNameContact:TextView
        val createdTime:TextView

        init {

            idContact=itemView.findViewById(R.id.idContacts)
            contactNo=itemView.findViewById(R.id.contactNo)
            lastNameContact=itemView.findViewById(R.id.lastNameContacts)
            createdTime=itemView.findViewById(R.id.createdTimeContacts)


        }

    }
}