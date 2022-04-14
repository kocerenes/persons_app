package com.example.personsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDAORepsitory

class PersonDetailPageViewModel(application: Application) : AndroidViewModel(application) {

    var personRepo = PersonDAORepsitory(application)

    fun update(person_id:Int,person_name:String,person_tel:String){
        personRepo.personUpdate(person_id,person_name,person_tel)
    }

}