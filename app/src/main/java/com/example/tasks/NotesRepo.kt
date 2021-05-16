package com.example.tasks

import androidx.lifecycle.LiveData

class NotesRepo(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()
    suspend fun insert(notes: Notes){
        noteDao.insert(notes)
    }
    suspend fun  delete (notes: Notes){
        noteDao.delete(notes)
    }
}