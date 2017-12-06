package com.anilkaynar.roomdeneme;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by anilkaynar on 6.12.2017.
 */
class Address {
    public String street;
    public String state;
    public String city;
    @ColumnInfo(name = "post_code")
    public int postCode;
}
@Entity(indices = {@Index("isim")})
public class Kisi {
    @Embedded
    public Address adres;
    @PrimaryKey
    int ogrenciNumarasi;
    @ColumnInfo(name = "isim")
    String isim;
    String Soyisim;

    @Override
    public  String toString(){
        return ogrenciNumarasi+"  "+isim+"  "+Soyisim+" "+adres.city+" "+adres.state;
    }
}
