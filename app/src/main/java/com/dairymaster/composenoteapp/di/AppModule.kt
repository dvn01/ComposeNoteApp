package com.dairymaster.composenoteapp.di

import android.content.Context
import androidx.room.Room
import com.dairymaster.composenoteapp.data.NoteDatabase
import com.dairymaster.composenoteapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDatabase): NoteDatabaseDao = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase
    = Room.databaseBuilder(context, NoteDatabase::class.java, "notes_db")
        .fallbackToDestructiveMigration()
        .build()
}