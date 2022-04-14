package com.example.personsapp.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.personsapp.viewmodel.PersonDetailPageViewModel

class PersonDetailPageViewModelFactory(var application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonDetailPageViewModel(application) as T
    }
}