package com.example.personsapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.personsapp.repo.PersonDAORepsitory

class PersonDetailPageViewModel: ViewModel() {

    var personRepo = PersonDAORepsitory()

    fun update(person_id:Int,person_name:String,person_tel:String){
        personRepo.personUpdate(person_id,person_name,person_tel)
    }

}