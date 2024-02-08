package com.example.selfmd.data.databases.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    fun insert(noteEntity: NoteEntity): Long

    @Update
    fun update(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: Long): NoteEntity?

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll(): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE isFavorite = 1 ORDER BY id DESC")
    fun getFavoriteNotes(): List<NoteEntity>
}