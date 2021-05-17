package com.example.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InterfaceNewsAdapter {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this,this)
        recView.adapter = adapter


        viewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory(application)).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {list->
            list?.let{
                adapter.updateList(it)
            }
        })



    }

    override fun onItemClicked(note : Notes){
        viewModel.deleteNode(note)
        Toast.makeText(this,"Item deleted" , Toast.LENGTH_LONG).show()
    }

    fun addData(view: View) {
        val noteText = addTask.text.toString()
        addTask.setText("")
        if (noteText.isNotEmpty()){
            viewModel.insertNode(Notes(noteText))
        }else{
            Toast.makeText(this,"Empty Note..." , Toast.LENGTH_SHORT).show()
        }
    }

}