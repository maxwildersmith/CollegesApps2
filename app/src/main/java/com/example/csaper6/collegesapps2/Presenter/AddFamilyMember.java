package com.example.csaper6.collegesapps2.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegesapps2.Model.Guardian;
import com.example.csaper6.collegesapps2.Model.Person;
import com.example.csaper6.collegesapps2.Model.Sibling;
import com.example.csaper6.collegesapps2.R;

public class AddFamilyMember extends AppCompatActivity {

    EditText fName,lName,info;
    NumberPicker age;
    Button cancel, submit;
    Switch toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);
        fName = (EditText)findViewById(R.id.first_name);
        lName = (EditText)findViewById(R.id.last_name);
        info = (EditText)findViewById(R.id.info);
        age = (NumberPicker)findViewById(R.id.age);
        cancel = (Button)findViewById(R.id.Cancel);
        submit = (Button)findViewById(R.id.submit);
        toggle = (Switch)findViewById(R.id.toggle);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    info.setHint("Relationship");
                else
                    info.setHint("Occupation");
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        age.setMaxValue(1);
        age.setMaxValue(150);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String appId = "DA83E066-DE62-8A6D-FFFD-C61E2024A500",secretKey="C1E67877-4996-0EF1-FFD5-43FE6C023500",version ="v1";

                Backendless.initApp(AddFamilyMember.this, appId, secretKey, version );
                BackendlessUser user = Backendless.UserService.CurrentUser();

                Person p;

                if (toggle.isChecked())
                    p = new Sibling(fName.getText().toString(),lName.getText().toString(),info.getText().toString(),age.getValue());
                else
                    p = new Guardian(fName.getText().toString(),lName.getText().toString(),info.getText().toString(),age.getValue());

                p.setOwnerId(BackendlessUser.ID_KEY);


                Backendless.Persistence.of(Person.class).save(p, new AsyncCallback<Person>() {
                    @Override
                    public void handleResponse(Person response) {
                        Toast.makeText(AddFamilyMember.this, "Saved", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(AddFamilyMember.this, fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });



                finish();
            }
        });
    }
}
