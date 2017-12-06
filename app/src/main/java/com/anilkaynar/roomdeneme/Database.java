package com.anilkaynar.roomdeneme;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by anilkaynar on 6.12.2017.
 */
@android.arch.persistence.room.Database(entities = {Kisi.class},version = 1)
public abstract class Database extends RoomDatabase {
      private static Database Singleton;
      public abstract KisiDao kisiDao();
    public static Database getAppDatabase(Context context) {
        if (Singleton == null) {
            Singleton =
                    Room.databaseBuilder(context.getApplicationContext(), Database.class, "Kisidb")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return Singleton;
    }
    public static void DestroyInstance(){
        Singleton=null;
    }
}
