package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginBtn;

    private DataBaseHelperUser myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername=findViewById(R.id.loginUsername);
        loginPassword=findViewById(R.id.loginPassword);
        loginBtn=findViewById(R.id.loginbtn);

        myDb=new DataBaseHelperUser(this);
        loginUser();
    }

    private void loginUser(){
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var=myDb.chekUser(loginUsername.getText().toString() ,loginPassword.getText().toString());

                if (var){
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this , MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}