package com.example.personsapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDAORepsitory

class PersonRegisteryViewModel: ViewModel() {

    var personRepo = PersonDAORepsitory()

    fun register(person_name:String,person_tel:String){
        personRepo.personRegister(person_name , person_tel)
    }


}