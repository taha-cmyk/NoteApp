package com.example.selfmd

import com.example.selfmd.data.databases.local.NoteDao
import com.example.selfmd.data.notes.repository.INoteRepository
import com.example.selfmd.data.notes.repository.OfflineNoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideNoteRepo(noteDao: NoteDao): INoteRepository {
        return OfflineNoteRepository(noteDao)
    }

}