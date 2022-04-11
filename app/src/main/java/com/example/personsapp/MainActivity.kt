package com.example.personsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.personsapp.entity.Persons
import com.example.personsapp.ui.theme.PersonsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PagePass()
                }
            }
        }
    }
}

@Composable
fun PagePass(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page"){
        composable("home_page"){
            HomePage(navController = navController)
        }
        composable("person_register_page"){
            PersonRegistrPage()
        }
        composable("person_detail_page/{person}"){
            val personObject = navController.previousBackStackEntry?.savedStateHandle?.get<Persons>("selectedPerson")
            personObject?.let {
                PersonDetailPage(person = it)
            }
        }
    }
}

@Composable
fun HomePage(navController: NavController) {

    val isMakeSearch = remember {
        mutableStateOf(false)
    }
    val tfSearch = remember {
        mutableStateOf("")
    }
    val personList = remember {
        mutableStateListOf<Persons>()
    }

    LaunchedEffect(key1 = true) {
        val person1 = Persons(1, "Enes Koçer", "5418743127")
        val person2 = Persons(1, "Arda Güler", "5433783192")
        personList.add(person1)
        personList.add(person2)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isMakeSearch.value) {
                        TextField(
                            value = tfSearch.value,
                            onValueChange = { tfSearch.value = it },
                            label = { Text(text = "Ara") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White,
                                unfocusedIndicatorColor = Color.White
                            )
                        )
                    } else {
                        Text(text = "Kişiler")
                    }
                },
                actions = {
                    if (isMakeSearch.value) {
                        IconButton(onClick = {
                            isMakeSearch.value = false
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.close_img),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    } else {
                        IconButton(onClick = {
                            isMakeSearch.value = true
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search_img),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        },
        content = {
            LazyColumn {
                items(
                    count = personList.count(),
                    itemContent = {
                        val person = personList[it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.clickable {
                                    navController.currentBackStackEntry?.savedStateHandle?.set("selectedPerson",person)
                                    navController.navigate("person_detail_page/{person}")
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "${person.person_name} - ${person.person_tel}")
                                    IconButton(onClick = {
                                        Log.e("sil","${person.person_name} silindi")
                                    }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.delete_img),
                                            contentDescription = "", tint = Color.Gray
                                        )
                                    }

                                }
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("person_register_page")
                },
                backgroundColor = colorResource(id = R.color.teal_200),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.add_img),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PersonsAppTheme {

    }
}