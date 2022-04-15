package com.example.personsapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.personsapp.entity.CRUDAnswer
import com.example.personsapp.entity.Persons
import com.example.personsapp.entity.PersonsAnswer
import com.example.personsapp.retrofit.ApiUtils
import com.example.personsapp.retrofit.PersonsDAOInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonDAORepsitory(var application: Application) {
    var personList = MutableLiveData<List<Persons>>()
    //var db : MyDatabase
    var personDAOInterface:PersonsDAOInterface

    init {
        //db = MyDatabase.accessDatabase(application)!!
        personDAOInterface = ApiUtils.getPersonDAOInterface()
        personList = MutableLiveData()
    }

    fun getPersons():MutableLiveData<List<Persons>>{
        return personList
    }

    fun getAllPerson(){

        personDAOInterface.allPersons().enqueue(object :Callback<PersonsAnswer>{
            override fun onFailure(call: Call<PersonsAnswer>?, t: Throwable?) { }

            override fun onResponse(
                call: Call<PersonsAnswer>,
                response: Response<PersonsAnswer>
            ) {
                val list = response.body().kisiler
                personList.value = list
            }
        })

        /*val job:Job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = db.personsDao().allPersons()
        }*/
    }

    fun searchPerson(searchWord : String){

        personDAOInterface.searchPerson(searchWord).enqueue(object : Callback<PersonsAnswer>{
            override fun onFailure(call: Call<PersonsAnswer>?, t: Throwable?) {}
            override fun onResponse(
                call: Call<PersonsAnswer>,
                response: Response<PersonsAnswer>
            ) {
                val list = response.body().kisiler
                personList.value = list
            }
        })

        /*val job:Job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = db.personsDao().searchPerson(searchWord)
        }*/
    }

    fun personRegister(person_name:String,person_tel:String){

        personDAOInterface.addPerson(person_name,person_tel).enqueue(object : Callback<CRUDAnswer>{
            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {}
            override fun onResponse(call: Call<CRUDAnswer>, response: Response<CRUDAnswer>) {

            }
        })

        /*val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0,person_name,person_tel)
            db.personsDao().addPerson(newPerson)
        }*/
    }

    fun personUpdate(person_id:Int,person_name:String,person_tel:String){

        personDAOInterface.updatePerson(person_id,person_name,person_tel).enqueue(object : Callback<CRUDAnswer>{
            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {}
            override fun onResponse(call: Call<CRUDAnswer>, response: Response<CRUDAnswer>) {

            }
        })

        /*val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Persons(person_id,person_name,person_tel)
            db.personsDao().updatePerson(updatedPerson)
        }*/
    }

    fun personDelete(person_id:Int){

        personDAOInterface.deletePerson(person_id).enqueue(object : Callback<CRUDAnswer>{
            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {}
            override fun onResponse(call: Call<CRUDAnswer>, response: Response<CRUDAnswer>) {
                getAllPerson()
            }
        })

        /*val job:Job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Persons(person_id,"","")
            db.personsDao().deletePerson(deletedPerson)
            getAllPerson()
        }*/
    }

}