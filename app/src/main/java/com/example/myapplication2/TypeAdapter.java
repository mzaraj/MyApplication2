package com.example.myapplication2;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TypeAdapter extends BaseAdapter {

    ArrayList<TypeBook> typeBookList = new ArrayList<>();
    Context context;

    public TypeAdapter(Context context) {
        this.context=context;
        TypeBook typeBook1 = new TypeBook(1,"Thriller");
        TypeBook typeBook2 = new TypeBook(2,"Romance");
        TypeBook typeBook3 = new TypeBook(3,"Fantasy");

        typeBookList.add(typeBook1);
        typeBookList.add(typeBook2);
        typeBookList.add(typeBook3);
    }

//    private void  createDefaultBook(Context context){
//
//        this.context=context;
//        TypeBook typeBook1 = new TypeBook(1,"Thriller");
//        TypeBook typeBook2 = new TypeBook(2,"Romance");
//        TypeBook typeBook3 = new TypeBook(3,"Fantasy");
//
//        typeBookList.add(typeBook1);
//        typeBookList.add(typeBook2);
//        typeBookList.add(typeBook3);
//    }

    @Override
    public int getCount() {
        return typeBookList.size();
    }

    @Override
    public Object getItem(int position) {
        return typeBookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.type_layout,parent,false);
        TextView type = (TextView) row.findViewById(R.id.typeNameText);
        Button editTypeButton = (Button)  row.findViewById(R.id.edit_type_button);
        Button deleteTypeButton = (Button)  row.findViewById(R.id.delete_type_button);
        final TypeBook temp = typeBookList.get(position);

        editTypeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("to jest przycisk edit!!!!!!!!!!1");
            }
        });

        type.setText(temp.getName());

        return row;

    }
}
