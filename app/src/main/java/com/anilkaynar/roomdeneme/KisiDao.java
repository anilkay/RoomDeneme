package com.anilkaynar.roomdeneme;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by anilkaynar on 6.12.2017.
 */
@Dao
public interface KisiDao {
    @Query("SELECT * FROM kisi")
    List<Kisi> getAll();
    @Query("Select * from kisi where ogrenciNumarasi=:Userids")
            List<Kisi> getSome(int Userids);
    @Insert
    void insertAll(Kisi... users);
    @Delete
    void delete(Kisi user);
    @Insert
    void insert1(Kisi user);
}
