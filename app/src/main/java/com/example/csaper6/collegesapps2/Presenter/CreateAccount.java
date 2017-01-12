package com.example.csaper6.collegesapps2.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.csaper6.collegesapps2.R;

public class CreateAccount extends AppCompatActivity {

    TextInputEditText name,password,confirmP;
    Button login,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name = (TextInputEditText)findViewById(R.id.create_name);
        password = (TextInputEditText)findViewById(R.id.create_password);
        confirmP = (TextInputEditText)findViewById(R.id.create_password_confirm);
        login = (Button)findViewById(R.id.submit);
        back = (Button) findViewById(R.id.Cancel);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asdf",password.getText()+"  "+confirmP.getText());

                if(password.getText().toString().equals(confirmP.getText().toString())) {
                    setResult(1,new Intent().putExtra("name", name.getText().toString()).putExtra("pass", password.getText().toString()));
                    finish();
                }
                else
                    Toast.makeText(CreateAccount.this, "Make sure there is a name entered, and that passwords match", Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
