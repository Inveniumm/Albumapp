package com.example.albumapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_album")
data class PostModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=0,
    var userId:Int?=0,
    var title:String?="",
    var body:String?=""
)