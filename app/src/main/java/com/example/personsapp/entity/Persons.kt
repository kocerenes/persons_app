package com.example.personsapp.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull


//@Entity(tableName = "persons")
@Parcelize
data class Persons(

    @SerializedName("kisi_id")
    @Expose
    var kisi_id:Int,
    @SerializedName("kisi_ad")
    @Expose
    var kisi_ad:String,
    @SerializedName("kisi_tel")
    @Expose
    var kisi_tel:String

    /*@PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var person_id : Int,
    @ColumnInfo(name = "person_name") @NotNull var person_name : String,
    @ColumnInfo(name = "person_tel") @NotNull var person_tel : String*/
):Parcelable

