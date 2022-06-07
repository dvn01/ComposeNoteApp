package com.dairymaster.composenoteapp.screen.notes

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dairymaster.composenoteapp.data.NotesDataSource
import com.dairymaster.composenoteapp.model.Note

class NoteViewModel :ViewModel(){
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }
    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
}