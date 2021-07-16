package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtName, edtFamily, edtAge, edtEmail;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtFamily = findViewById(R.id.edtFamily);
        edtEmail = findViewById(R.id.edtEmail);

        CreateSQLiteDir.cSQLDir.creatSqliteDir();
        CreateSQLiteDir.cSQLDir.createDatabase();


        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(edtId.getText().toString());
                String name = edtName.getText().toString();
                String family = edtFamily.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());
                String email = edtEmail.getText().toString();


                try {
                    String queryInsert = "INSERT INTO 'Persons'('PersonID','Name','Family','Email','Age') VALUES (id,name,family,email,age)";
                    CreateSQLiteDir.database.execSQL(queryInsert);
                }catch (Exception e){

                }
            }
        });


    }
}