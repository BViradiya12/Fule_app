package com.example.vehiclemaintanacesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Driver extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        databaseHelper = new DatabaseHelper(this);
    }
    public void submit(View view) {
        EditText e1 = findViewById(R.id.edt1);
        EditText e2 = findViewById(R.id.edt2);
        EditText e3 = findViewById(R.id.edt3);
        EditText e4 = findViewById(R.id.edt4);
        EditText e5 = findViewById(R.id.edt5);
        EditText e6 = findViewById(R.id.edt6);
        EditText e7 = findViewById(R.id.edt7);

        String valVno, valDate, valName, valRno, valKm, valLtr, valPrice;
        valVno = e1.getText().toString();
        valDate = e2.getText().toString();
        valName = e3.getText().toString();
        valRno = e4.getText().toString();
        valKm = e5.getText().toString();
        valLtr = e6.getText().toString();
        valPrice = e7.getText().toString();

        if(databaseHelper.insertData(valVno,valDate,valName,valRno,valKm,valLtr,valPrice))
        {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data insertion failed", Toast.LENGTH_SHORT).show();
        }

        Intent a1 = new Intent(this,Admin.class);
        startActivity(a1);
        finish();

    }
}