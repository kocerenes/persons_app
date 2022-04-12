package com.example.personsapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personsapp.entity.Persons

class PersonDAORepsitory {
    var personList = MutableLiveData<List<Persons>>()

    init {
        personList = MutableLiveData()
    }

    fun getPersons():MutableLiveData<List<Persons>>{
        return personList
    }

    fun getAllPerson(){
        val list = mutableListOf<Persons>()
        val person1 = Persons(1, "Enes Koçer", "5418743127")
        val person2 = Persons(2, "Arda Güler", "5433783192")
        list.add(person1)
        list.add(person2)
        personList.value= list
    }

    fun searchPerson(searchWord : String){
        Log.e("search",searchWord)
    }

    fun personRegister(person_name:String,person_tel:String){
        Log.e("kayıt", "$person_name -- $person_tel")
    }

    fun personUpdate(person_id:Int,person_name:String,person_tel:String){
        Log.e("güncelle", "${person_id} -- $person_name -- $person_tel")
    }

    fun personDelete(person_id:Int){
        Log.e("sil", "${person_id}")
    }

}