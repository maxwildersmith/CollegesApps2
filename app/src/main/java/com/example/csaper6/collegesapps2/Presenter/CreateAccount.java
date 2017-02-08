package com.example.csaper6.collegesapps2.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegesapps2.R;

public class CreateAccount extends AppCompatActivity {

    TextInputEditText name,password,confirmP,fname,lname,email;
    Button login,back;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        pd = new ProgressDialog(this,ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("Creating Account...");
        fname = (TextInputEditText)findViewById(R.id.first_name);
        lname = (TextInputEditText)findViewById(R.id.last_name);
        email = (TextInputEditText)findViewById(R.id.email);
        name = (TextInputEditText)findViewById(R.id.create_name);
        password = (TextInputEditText)findViewById(R.id.create_password);
        confirmP = (TextInputEditText)findViewById(R.id.create_password_confirm);
        login = (Button)findViewById(R.id.submit);
        back = (Button) findViewById(R.id.Cancel);

       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setResult(1,new Intent().putExtra("name", name.getText().toString()).putExtra("pass", password.getText().toString()));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("asdf",password.getText()+"  "+confirmP.getText());

                if(password.getText().toString().equals(confirmP.getText().toString())) {
                    setResult(1,new Intent().putExtra("name", name.getText().toString()).putExtra("pass", password.getText().toString()));

                    pd.show();
                    userAdd();

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
    public void userAdd(){
        String appId = "DA83E066-DE62-8A6D-FFFD-C61E2024A500",secretKey="C1E67877-4996-0EF1-FFD5-43FE6C023500",version ="v1";
        Backendless.initApp(this, appId, secretKey, version ); // where to get the argument values for this call
        BackendlessUser user = new BackendlessUser();
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        user.setProperty("first_name",fname.getText().toString());
        user.setProperty("last_name",lname.getText().toString());
        user.setProperty("username",name.getText().toString());

        Backendless.UserService.register(user,createUserCallback());


    }

    private AsyncCallback<BackendlessUser> createUserCallback() {
        return new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                //Toast.makeText(CreateAccount.this, "Thumbs up", Toast.LENGTH_SHORT).show();
                pd.cancel();
                finish();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                pd.cancel();
                Toast.makeText(CreateAccount.this, fault.getMessage(), Toast.LENGTH_LONG).show();

            }
        };
    }

}
