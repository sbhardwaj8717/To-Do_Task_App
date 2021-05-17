package com.example.tasks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val allNotes:LiveData<List<Notes>>
    private val repo : NotesRepo
    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repo = NotesRepo(dao)

        allNotes = repo.allNotes
    }

    fun deleteNode(note:Notes) = viewModelScope.launch(Dispatchers.IO){
        repo.delete(note)
    }
    fun insertNode(note  :Notes) = viewModelScope.launch( Dispatchers.IO ){
        repo.insert(note)
    }
}