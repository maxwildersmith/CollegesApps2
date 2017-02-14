package com.example.csaper6.collegesapps2.Presenter;

/**
 * Created by csaper6 on 1/31/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegesapps2.Model.Guardian;
import com.example.csaper6.collegesapps2.Model.Person;
import com.example.csaper6.collegesapps2.Model.Sibling;

import java.util.ArrayList;
import java.util.List;

/**
 * ask for specifics
 * Most struggle w/: understanding trade offs; come up w/ a solution
 *
 * Q-Computer: degree in physics
 * ML: degree in ML
 * Min: Bachelors
 * Masters in specific field
 * Bachlors: know how to get
 * Masters: create Knowledge
 * PhD: Research
 *
 *
 * Google maybe small than the internet
 */

/**
 * Created by gshorr on 1/19/17.
 */
public class FamilyListFragment extends ListFragment {
    private List<Person> family;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        family = new ArrayList<>();

        //String appId = "DA83E066-DE62-8A6D-FFFD-C61E2024A500",secretKey="C1E67877-4996-0EF1-FFD5-43FE6C023500",version ="v1";
        //Backendless.initApp(this, appId, secretKey, version );






//        Backendless.Persistence.of(Guardian.class).find(new BackendlessCallback<BackendlessCollection<Guardian>>() {
//            @Override
//            public void handleResponse(BackendlessCollection<Guardian> response) {
//                family.addAll(response.getData());
//                FamilyAdapter adapter = new FamilyAdapter(getActivity(), family);
//
//                setListAdapter(adapter);
//
//
//            }
//
//
//        });



        updateList();

        //Comparator c = null;
        //Collections.sort(family, c);


        //fill the custom adapter
        return rootView;
    }

    public void updateList() {
        Backendless.Persistence.of(Guardian.class).find(new BackendlessCallback<BackendlessCollection<Guardian>>() {
            @Override
            public void handleResponse(BackendlessCollection<Guardian> response) {
                family.addAll(response.getData());



            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("asdf",fault.toString());
            }
        });

        Backendless.Persistence.of(Sibling.class).find(new BackendlessCallback<BackendlessCollection<Sibling>>() {
            @Override
            public void handleResponse(BackendlessCollection<Sibling> response) {
                family.addAll(response.getData());



            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("asdf",fault.toString());
            }
        });

        FamilyAdapter adapter = new FamilyAdapter(getActivity(), family);

        setListAdapter(adapter);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
