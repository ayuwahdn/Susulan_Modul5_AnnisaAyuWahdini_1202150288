package com.example.android.Susulan_Modul5_AnnisaAyuWahdini_1202150288;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {
    //inisialisasi variabel
    DBHelper eDbHelper;
    private Button bSubmit;
    private EditText tNama,tDeskripsi, tPrioritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtodo);
        tNama = (EditText) findViewById(R.id.tNama);
        tDeskripsi = (EditText) findViewById(R.id.tDeskripsi);
        tPrioritas = (EditText) findViewById(R.id.tPrioritas);
        eDbHelper = new DBHelper(this);
    }

    public void tambah(View view) {
        String nama = tNama.getText().toString();
        String deskripsi = tDeskripsi.getText().toString();
        String prioritas = tPrioritas.getText().toString();
        AddData(nama, deskripsi,prioritas);

    }

    public void AddData(String nama,String deskripsi,String prioritas ){
        boolean insertData = eDbHelper.addData(nama,deskripsi,prioritas);

        if (insertData){ //jika data dimasukkan
            Toast.makeText(this,"Succeed", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show();
        }
    }

    public void tampilData(View view) { //mengoper data ke mainactivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
