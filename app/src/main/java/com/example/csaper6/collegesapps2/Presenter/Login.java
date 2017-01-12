package com.example.csaper6.collegesapps2.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csaper6.collegesapps2.R;

public class Login extends AppCompatActivity {

    TextInputEditText name,password;
    Button login;
    TextView newA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (TextInputEditText)findViewById(R.id.login_name);
        password = (TextInputEditText)findViewById(R.id.login_password);
        login = (Button)findViewById(R.id.submit);
        newA = (TextView)findViewById(R.id.newA);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.toString().trim().equals("")&&!password.toString().trim().equals(""))
                    startActivity(new Intent(Login.this, MainActivity.class));
                else
                    Toast.makeText(Login.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
            }
        });

        newA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Login.this, CreateAccount.class),1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            Log.e("asdf","o");
            // Make sure the request was successful
                Log.e("asdf","k");
                name.setText(data.getStringExtra("name"));
                password.setText(data.getStringExtra("pass"));

        }
    }
}
