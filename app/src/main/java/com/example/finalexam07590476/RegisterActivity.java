package com.example.finalexam07590476;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        final SQLiteDatabase sqliteMyDB;
        final MyDbHelper myDataHelper;
        myDataHelper = new MyDbHelper(this);
        sqliteMyDB = myDataHelper.getWritableDatabase();
        final EditText editName = (EditText) findViewById(R.id.full_name_edit_text);
        final EditText editUser = (EditText) findViewById(R.id.username_edit_text);
        final EditText editPassword = (EditText) findViewById(R.id.password_edit_text);
        Button regbutton = (Button) findViewById(R.id.register_button);


        regbutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final String name =  editName.getText().toString();
                final String user = editUser.getText().toString();
                final String password = editPassword.getText().toString();
                if (name.isEmpty()||user.isEmpty()||password.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Please insert all data",Toast.LENGTH_SHORT).show();
                }
                else{
                    long flg1 = myDataHelper.InsertData(user,password, name);
                    if(flg1 > 0){
                        Toast.makeText(RegisterActivity.this,"Insert Data Successfully",
                                Toast.LENGTH_LONG).show();
                        Log.v("Username", user);
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Insert Data Failed.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
