package com.example.personsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personsapp.entity.Persons
import com.example.personsapp.repo.PersonDAORepsitory

class HomePageViewModel(application: Application) :AndroidViewModel(application) {

    var personRepo = PersonDAORepsitory(application)
    var personList = MutableLiveData<List<Persons>>()

    init {
        personsLoad()
        personList = personRepo.getPersons()
    }

    fun personsLoad(){
        personRepo.getAllPerson()
    }

    fun search(searchWord : String){
        personRepo.searchPerson(searchWord)
    }

    fun delete(person_id:Int){
        personRepo.personDelete(person_id)
    }

}