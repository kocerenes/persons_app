package com.example.personsapp.room

import androidx.room.*
import com.example.personsapp.entity.Persons

/*@Dao
interface PersonDao {

    @Query("SELECT * FROM persons")
    suspend fun allPersons() : List<Persons>

    @Insert
    suspend fun addPerson(person: Persons)

    @Update
    suspend fun updatePerson(person: Persons)

    @Delete
    suspend fun deletePerson(person: Persons)

    //arama işlemi
    @Query("SELECT * FROM persons WHERE person_name like '%' || :searchedWord || '%'")
    suspend fun searchPerson(searchedWord : String) : List<Persons>

}*/