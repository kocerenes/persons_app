package com.example.personsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDAORepsitory

class PersonRegisteryViewModel(application: Application) : AndroidViewModel(application) {

    var personRepo = PersonDAORepsitory(application)

    fun register(person_name:String,person_tel:String){
        personRepo.personRegister(person_name , person_tel)
    }


}