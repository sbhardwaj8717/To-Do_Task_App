package com.example.tasks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val allNotes:LiveData<List<Notes>>
    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repo = NotesRepo(dao)
        allNotes = repo.allNotes
    }
}