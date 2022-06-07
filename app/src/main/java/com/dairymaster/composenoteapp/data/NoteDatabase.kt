package com.dairymaster.composenoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dairymaster.composenoteapp.util.DateConverter
import com.dairymaster.composenoteapp.util.UUIDConverter
import com.dairymaster.composenoteapp.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}