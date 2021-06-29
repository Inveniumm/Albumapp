package com.example.albumapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface AlbumsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(albums: PostModel) : Completable

    @Query("SELECT * FROM table_album")
    fun getTitles() : Single<List<PostModel>>

    @Query("SELECT * FROM `table_album` WHERE id  ORDER BY title")
    fun sortTitle(id : Int, status : Boolean) : Completable

    @Query("DELETE from table_album")
    fun clearTable() : Completable


}