package com.example.android.Susulan_Modul5_AnnisaAyuWahdini_1202150288;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    DBHelper eDbHelper;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listView);
        eDbHelper = new DBHelper(this);
        showData();
    }

    //menampilkan data dari list adapter
    public void showData(){
        Cursor data = eDbHelper.getData();
        ArrayList<String> list = new ArrayList<>();
        while (data.moveToNext()){
            list.add(data.getString(6));
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);
    }
}

