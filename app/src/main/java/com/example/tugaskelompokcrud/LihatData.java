package com.example.tugaskelompokcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn_kembali;
    TextView tv_nama, tv_email, tv_alamat, tv_noHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        dbHelper = new DataHelper(this);
        tv_nama = (TextView) findViewById(R.id.tv_nama);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_alamat = (TextView) findViewById(R.id.tv_alamat);
        tv_noHp = (TextView) findViewById(R.id.tv_noHp);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Usertable WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            tv_nama.setText(cursor.getString(1).toString());
            tv_email.setText(cursor.getString(2).toString());
            tv_alamat.setText(cursor.getString(3).toString());
            tv_noHp.setText(cursor.getString(4).toString());
        }
        btn_kembali = (Button) findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }
}