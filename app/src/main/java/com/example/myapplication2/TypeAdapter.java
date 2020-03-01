package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//android adapter list view

public class TypeAdapter extends BaseAdapter {

    ArrayList<BookType> bookTypeList ;
    Context context;
//    DbManager dbManager;
    DbManager dbManager;


    public TypeAdapter(Context context, ArrayList<BookType> bookTypeList, DbManager dbManager) {
        this.context=context;
        this.bookTypeList = bookTypeList;
        this.dbManager = dbManager;
//        this.dbManager = dbManager;
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
        return bookTypeList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookTypeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.type_layout,parent,false);
        TextView type = (TextView) row.findViewById(R.id.typeNameText);
        Button editTypeButton = (Button)  row.findViewById(R.id.edit_type_button);
        Button deleteTypeButton = (Button)  row.findViewById(R.id.delete_type_button);
         BookType temp = bookTypeList.get(position);
         final BookType numerID = bookTypeList.get(position);

        editTypeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("to jest przycisk edit!!!!!!!!!!1");
            }
        });
        type.setText(temp.getName());

//        deleteTypeButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                dbManager.deleteBookType(numerID.getId());
//
////                this.notifyDataSetChanged();
////                System.out.println(numerID.getId());
//            }
//        });


        return row;
    }
}
