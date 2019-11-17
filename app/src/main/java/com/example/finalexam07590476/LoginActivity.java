package com.example.finalexam07590476;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase sqliteMyDB;
        MyDbHelper myDataHelper;
        Cursor myDBCursor;

        myDataHelper = new MyDbHelper(this);
        sqliteMyDB = myDataHelper.getWritableDatabase();


        Button btn = (Button)findViewById(R.id.register_button);
        Button loginbutton = (Button)findViewById(R.id.login_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        final EditText editUser = (EditText) findViewById(R.id.username_edit_text);
        final EditText editPassword = (EditText) findViewById(R.id.password_edit_text);


        loginbutton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View view) {
                final String User = editUser.getText().toString();
                final String Pass = editPassword.getText().toString();
                if(User.isEmpty()||Pass.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please insert all data",Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });


    }
}
