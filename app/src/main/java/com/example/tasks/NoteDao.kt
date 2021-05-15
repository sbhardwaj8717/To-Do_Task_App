package com.example.tasks


import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Notes)
    @Delete
    suspend fun delete(note: Notes)
    @Query("select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Notes>>
}