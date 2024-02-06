package com.example.selfmd.data.databases.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.selfmd.data.notes.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

   @Query("SELECT * from notes WHERE id = :id")
   fun getNote(id: Int): Flow<Note>

    @Query("SELECT * from notes ORDER BY id ASC")
    fun getAllNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}