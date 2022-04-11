package com.example.personsapp.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persons(
    var person_id: Int,
    var person_name: String,
    var person_tel: String
):Parcelable