package com.example.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Notes(@ColumnInfo(name ="text") val test : String) {
    @PrimaryKey(autoGenerate = true) var id =0;

}