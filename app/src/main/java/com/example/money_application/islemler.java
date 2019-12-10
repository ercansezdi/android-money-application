package com.example.money_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class islemler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_islemler);

        List<String> islem = new ArrayList<String>();
        List<String> money = new ArrayList<String>();
        List<String> tur   = new ArrayList<String>();

        SQLiteDatabase mydatabase = openOrCreateDatabase("test_x",MODE_PRIVATE,null);
        Cursor cursor = mydatabase.rawQuery("Select * from TutorialsPoint",null);
        if (cursor.moveToFirst()) {
            do {
                islem.add(cursor.getString(0));
                money.add(cursor.getString(1) + "TL");
                tur.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        ListView listemiz = (ListView) findViewById(R.id.listview_1);

        final ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, tur){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position,convertView,parent);
                if(position % 2 == 1)
                    view.setBackgroundColor(Color.parseColor("#F80000"));
                else
                    view.setBackgroundColor(Color.parseColor("#00BCD4"));

                return view;
            }
        };
        listemiz.setAdapter(veriAdaptoru);

        ListView liste = (ListView) findViewById(R.id.listview_2);

        final ArrayAdapter<String> veriAdaptor = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, money){
            @Override
            public View getView(int position, View convertView, ViewGroup parent3){
                View view = super.getView(position,convertView,parent);
                if(position % 2 == 1)
                    view.setBackgroundColor(Color.parseColor("#F80000"));
                else
                    view.setBackgroundColor(Color.parseColor("#00BCD4"));
                return view;
            }
        };
        liste.setAdapter(veriAdaptor);

    }


    public void come_back(View view)
    {
        startActivity(new Intent(islemler.this, MainActivity.class));
    }

}
