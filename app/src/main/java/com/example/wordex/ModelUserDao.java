/*package com.example.wordex;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ModelUserDao {

    @Query("SELECT * FROM users  " )
    LiveData<List<ModelUsers>> getAll();

    @Query("SELECT * FROM users WHERE Nombre LIKE :name ")
    ModelUsers findUserByUserName(String name);


    @Insert
    void insert(ModelUsers user_tabla);

}
*/