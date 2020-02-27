package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<TypeBook> typeBookList = new ArrayList<>();

    ListView typelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypeAdapter typeAdapter = new TypeAdapter(this);


//        this.typelist = typelist; //odebranie listy wydarzeń z asyncTask
//        ListAdapter adapter = new SimpleAdapter(typeBookList, new String[] { "name"}, new int[] {R.id.typeNameText}){
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
////                HashMap<String, String > map = new HashMap<>();
////                map = typelist.get(position);
//                TextView typeMessage=view.findViewById(R.id.typeNameText);
//
//                return view;
//            }
//        };
//        typelist.setAdapter(adapter);

//        Bundle bundle = getIntent().getExtras();
//        if(bundle.getInt("Id_type")!=0){
//            idType=bundle.getInt("Id_type");
//        }
//
//        typelist = findViewById(R.id.);
//        typeNameText = findViewById(R.id.typeNameText);
//        back=findViewById(R.id.backButton);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }


    }
}
