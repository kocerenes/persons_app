package com.example.personsapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getPersonDAOInterface():PersonsDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(PersonsDAOInterface::class.java)
        }
    }
}