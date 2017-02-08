package com.example.csaper6.collegesapps2.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.csaper6.collegesapps2.Model.Guardian;
import com.example.csaper6.collegesapps2.Model.Person;
import com.example.csaper6.collegesapps2.Model.Sibling;
import com.example.csaper6.collegesapps2.R;

import java.util.List;


public class FamilyAdapter extends ArrayAdapter<Person>{
    public FamilyAdapter(Context context, List<Person> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //if not given a view, we need to make one
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_family_list, null);
        }
        //get the item at the position where we are
        Person familyMember = getItem(position);

        //wire up our view
        TextView nameText = (TextView) convertView.findViewById(R.id.name);
        TextView infoText = (TextView) convertView.findViewById(R.id.info);
        TextView ageText = (TextView) convertView.findViewById(R.id.ageT);

        //put the text of the hero into the appropriate views
        nameText.setText(familyMember.getFirstName());
        ageText.setText(familyMember.getAge()+"");
        if(familyMember instanceof Guardian)
            infoText.setText(""+((Guardian)familyMember).getOccupation());
        else
            infoText.setText(((Sibling)familyMember).getRelationship());


        //return the view that you had edited
        return convertView;

    }
}
