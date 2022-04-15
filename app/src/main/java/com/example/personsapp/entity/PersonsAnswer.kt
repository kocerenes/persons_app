package com.example.personsapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonsAnswer(
    @SerializedName("kisiler")
    @Expose
    var kisiler:List<Persons>,
    @SerializedName("success")
    @Expose
    var success:Int
)