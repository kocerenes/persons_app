package com.example.personsapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personsapp.entity.Persons
import com.example.personsapp.room.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonDAORepsitory(var application: Application) {
    var personList = MutableLiveData<List<Persons>>()
    var db : MyDatabase

    init {
        db = MyDatabase.accessDatabase(application)!!
        personList = MutableLiveData()
    }

    fun getPersons():MutableLiveData<List<Persons>>{
        return personList
    }

    fun getAllPerson(){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = db.personsDao().allPersons()
        }

        /*val list = mutableListOf<Persons>()
        val person1 = Persons(1, "Enes Koçer", "5418743127")
        val person2 = Persons(2, "Arda Güler", "5433783192")
        list.add(person1)
        list.add(person2)
        personList.value= list*/
    }

    fun searchPerson(searchWord : String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = db.personsDao().searchPerson(searchWord)
        }
    }

    fun personRegister(person_name:String,person_tel:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0,person_name,person_tel)
            db.personsDao().addPerson(newPerson)
        }
    }

    fun personUpdate(person_id:Int,person_name:String,person_tel:String){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Persons(person_id,person_name,person_tel)
            db.personsDao().updatePerson(updatedPerson)
        }
    }

    fun personDelete(person_id:Int){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Persons(person_id,"","")
            db.personsDao().deletePerson(deletedPerson)
            getAllPerson()
        }
    }

}