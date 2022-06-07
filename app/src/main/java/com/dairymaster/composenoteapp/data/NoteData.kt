package com.dairymaster.composenoteapp.data

import com.dairymaster.composenoteapp.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note>{
        return listOf(
        Note(title = "A good day", info = "We went on a vacation by the lake"),
        Note(title = "Android Compose", info = "Working on Android Compose course today"),
        Note(title = "Keep at it...", info = "Sometimes things just happen"),
        Note(title = "A movie day", info = "Watching a movie with family today"),
        Note(title = "A movie day", info = "Watching a movie with family today"),
        Note(title = "A movie day", info = "Watching a movie with family today"),
        Note(title = "A movie day", info = "Watching a movie with family today"),
        Note(title = "A movie day", info = "Watching a movie with family today"),
        Note(title = "A movie day", info = "Watching a movie with family today"),
        Note(title = "A movie day", info = "Watching a movie with family")
        )
    }
}