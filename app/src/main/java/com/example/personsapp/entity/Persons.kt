package com.example.personsapp.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
@Entity(tableName = "persons")
class Persons(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var person_id : Int,
    @ColumnInfo(name = "person_name") @NotNull var person_name : String,
    @ColumnInfo(name = "person_tel") @NotNull var person_tel : String
):Parcelable

/*@Parcelize
data class Persons(
    var person_id: Int,
    var person_name: String,
    var person_tel: String
):Parcelable*/