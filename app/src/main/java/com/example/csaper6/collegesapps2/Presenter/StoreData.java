package com.example.csaper6.collegesapps2.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegesapps2.Model.Guardian;
import com.example.csaper6.collegesapps2.Model.Person;
import com.example.csaper6.collegesapps2.Model.Sibling;
import com.example.csaper6.collegesapps2.R;

public class StoreData extends AppCompatActivity {

    private Button b;
    public TextView t;
    private Guardian g;
    private Sibling s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);
        b = (Button)findViewById(R.id.button1);
        t = (TextView)findViewById(R.id.txt1);

        g = new Guardian();
        s = new Sibling();

        String appId = "DA83E066-DE62-8A6D-FFFD-C61E2024A500",secretKey="C1E67877-4996-0EF1-FFD5-43FE6C023500",version ="v1";
        Backendless.initApp(this, appId, secretKey, version );


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backendless.Persistence.of(Person.class).save(g, new AsyncCallback<Person>() {
                    @Override
                    public void handleResponse(Person response) {
                        Toast.makeText(StoreData.this, "saved", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(StoreData.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
