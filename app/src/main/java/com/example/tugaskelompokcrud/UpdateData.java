package com.example.tugaskelompokcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class UpdateData extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn_update, btn_kembali;
    EditText up_nama, up_email, up_alamat, up_noHp, ed_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        dbHelper = new DataHelper(this);
        ed_id = (EditText) findViewById(R.id.ed_id);
        up_nama = (EditText) findViewById(R.id.up_nama);
        up_email = (EditText) findViewById(R.id.up_email);
        up_alamat = (EditText) findViewById(R.id.up_alamat);
        up_noHp = (EditText) findViewById(R.id.up_noHp);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Usertable WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ed_id.setText(cursor.getString(0).toString());
            up_nama.setText(cursor.getString(1).toString());
            up_email.setText(cursor.getString(2).toString());
            up_alamat.setText(cursor.getString(3).toString());
            up_noHp.setText(cursor.getString(4).toString());
        }
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_kembali = (Button) findViewById(R.id.btn_back);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE Usertable SET nama='" +
                        up_nama.getText().toString() + "', email='" +
                        up_email.getText().toString() + "', alamat='" +
                        up_alamat.getText().toString() + "', noHp='" +
                        up_noHp.getText().toString() + "'WHERE id='" +
                        ed_id.getText().toString() + "'");
                Toast.makeText(getApplicationContext(), "Data Berhasil Diupdate", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

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
        return true;
    }
}






