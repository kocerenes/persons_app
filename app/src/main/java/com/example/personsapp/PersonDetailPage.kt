package com.example.personsapp

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personsapp.entity.Persons
import com.example.personsapp.viewmodel.HomePageViewModel
import com.example.personsapp.viewmodel.PersonDetailPageViewModel
import com.example.personsapp.viewmodelfactory.HomePageViewModelFactory
import com.example.personsapp.viewmodelfactory.PersonDetailPageViewModelFactory

@Composable
fun PersonDetailPage(person:Persons) {

    val tfPersonName = remember {
        mutableStateOf("")
    }
    val tfPersonTelNo = remember {
        mutableStateOf("")
    }
    //geri tuşuna bastığımızda textFieldlardaki seçimi kaldırıcaz
    val localFocusManager = LocalFocusManager.current

    val context = LocalContext.current
    val viewmodel: PersonDetailPageViewModel = viewModel(
        factory = PersonDetailPageViewModelFactory(context.applicationContext as Application)
    )
    
    LaunchedEffect(key1 = true){
        tfPersonName.value = person.person_name
        tfPersonTelNo.value = person.person_tel
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Kişi Detay") })
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = tfPersonName.value,
                    onValueChange = { tfPersonName.value = it },
                    label = { Text(text = "Kişi Adı") }
                )
                TextField(
                    value = tfPersonTelNo.value,
                    onValueChange = { tfPersonTelNo.value = it },
                    label = { Text(text = "Kişi Tel No") }
                )
                Button(
                    onClick = {
                        val person_name = tfPersonName.value
                        val person_tel = tfPersonTelNo.value
                        viewmodel.update(person.person_id,person_name,person_tel)
                        localFocusManager.clearFocus()
                    },
                    modifier = Modifier.size(250.dp, 50.dp)
                ) {
                    Text(text = "Güncelle")
                }

            }
        }
    )
}