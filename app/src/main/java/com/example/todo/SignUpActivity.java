package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignup;
    private Button signUpBtn;
    private DataBaseHelperUser myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        emailSignUp=findViewById(R.id.Signupemail);
        usernameSignUp=findViewById(R.id.SignupUsername);
        passwordSignup=findViewById(R.id.SignupPassword);
        signUpBtn=findViewById(R.id.Signupbtn);

        myDB=new DataBaseHelperUser(this );
        insertUser();
    }

    private void insertUser(){
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString() , emailSignUp.getText().toString() , passwordSignup.getText().toString());
                if(var){
                    Toast.makeText(SignUpActivity.this, "User Registerd Successfully !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Registration Error!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}