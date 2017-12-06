package com.anilkaynar.roomdeneme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database db;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      db=Database.getAppDatabase(getApplicationContext());
        tv = findViewById(R.id.text2);
    }
    public void addKisi(Kisi kisi){
        try {
            db.kisiDao().insert1(kisi);
        } catch (Exception e) {
            tv.setText(e.getMessage());
            Log.e("Primary Key Error", e.getMessage());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Kisi ekle=new Kisi();
        ekle.isim="anil";
        ekle.Soyisim="kaynar";
        ekle.ogrenciNumarasi=2;
        Address adres=new Address();
        adres.state="Marmara";
        adres.city="İstanbul";
        adres.postCode=1;
        adres.street="Vadi";
        ekle.adres=adres;
        addKisi(ekle);
        getirKisi();
    }

    public void getirKisi(){
        List<Kisi> kisi=db.kisiDao().getAll();
        for(Kisi i:kisi){
            Log.e("DB",i.toString());
            tv.setText(i.toString());
        }
    }
}
/*
if Conflict in Primary Key area Throw and nasty Exception
UNIQUE constraint failed: Kisi.ogrenciNumarasi (code 1555)
 */