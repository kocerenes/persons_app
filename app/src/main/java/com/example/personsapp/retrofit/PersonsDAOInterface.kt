package com.example.personsapp.retrofit

import com.example.personsapp.entity.CRUDAnswer
import com.example.personsapp.entity.PersonsAnswer
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonsDAOInterface {

    @GET("kisiler/tum_kisiler.php")
    fun  allPersons():Call<PersonsAnswer>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded //Türkçe desteği
    fun searchPerson(@Field("kisi_ad") kisi_ad:String):Call<PersonsAnswer>

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun deletePerson(@Field("kisi_id") kisi_id:Int):Call<CRUDAnswer>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun addPerson(
        @Field("kisi_ad") kisi_ad:String,
        @Field("kisi_tel") kisi_tel:String
    ):Call<CRUDAnswer>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun updatePerson(
        @Field("kisi_id") kisi_id:Int,
        @Field("kisi_ad") kisi_ad:String,
        @Field("kisi_tel") kisi_tel:String
    ):Call<CRUDAnswer>

}