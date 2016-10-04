package com.pocstudentproject.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pocstudentproject.studentpocproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by renan on 03/10/2016.
 */

public class StudentAdapter extends ArrayAdapter<Student> {
    private int resource;

    public StudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);

        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(resource, parent, false);
            convertView.setTag(viewHolder);

            viewHolder.titleName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.textAge = (TextView) convertView.findViewById(R.id.txtAge);
            viewHolder.textAddress = (TextView) convertView.findViewById(R.id.txtAddress);
            viewHolder.studentImage = (ImageView) convertView.findViewById(R.id.imgFoto);
            viewHolder.btnDelete = (Button) convertView.findViewById(R.id.btnDelete);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student student = getItem(position);
        viewHolder.titleName.setText(student.getNome());
        viewHolder.textAge.setText(student.getIdade().toString());
        viewHolder.textAddress.setText(student.getEndereco());
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
            }
        });
        Picasso.with(getContext()).load(student.getFotoUrl()).into(viewHolder.studentImage);

        return convertView;
    }

    static class ViewHolder {
        ImageView studentImage;
        TextView titleName;
        TextView textAge;
        TextView textAddress;
        Button btnDelete;
    }
}
