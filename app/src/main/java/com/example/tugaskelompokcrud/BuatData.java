package com.example.tugaskelompokcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn_lihat, btn_save;
    EditText ed_nama,ed_email,ed_alamat,ed_noHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_data);

        dbHelper = new DataHelper(this);
        ed_nama=(EditText) findViewById(R.id.up_nama);
        ed_email=(EditText) findViewById(R.id.up_email);
        ed_alamat=(EditText) findViewById(R.id.up_alamat);
        ed_noHp=(EditText) findViewById(R.id.up_noHp);
        btn_lihat = (Button) findViewById(R.id.btn_back);
        btn_save = (Button) findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO Usertable (nama,email,alamat,noHp) VALUES ('"+
                        ed_nama.getText().toString()+"','"+
                        ed_email.getText().toString()+"','"+
                        ed_alamat.getText().toString()+"','"+
                        ed_noHp.getText().toString()+"')");
                Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}