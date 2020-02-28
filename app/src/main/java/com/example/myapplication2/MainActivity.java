package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<BookType> bookTypeList ;

    public ListView typelist;

    private Cursor cursor;

    private DbManager dbManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("1");

        dbManager = new DbManager(this);

        bookTypeList = getBookTypeData();

        if(bookTypeList.size() == 0){
            GenerateDefaultData();
        }


//        for(BookType b : bookTypeList){
//            Log.d("jest elementów" + bookTypeList.size(), "blablabla");
//        }

        TypeAdapter typeAdapter = new TypeAdapter(this, bookTypeList, dbManager);

        typelist = (ListView) findViewById(R.id.typelist);

        typelist.setAdapter(typeAdapter);



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
//        };a
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

    private void GenerateDefaultData() {
        System.out.println("2");
        dbManager.addBookType(new BookType("Thriller2"));
        dbManager.addBookType(new BookType("Romance2"));
        dbManager.addBookType(new BookType("Fantasy"));
    }


    private ArrayList<BookType> getBookTypeData(){
        Cursor data = dbManager.getBookTypes();
        ArrayList<BookType> listData = new ArrayList<>();
        BookType bookType;

        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            int id = data.getInt(0);
            String name=data.getString(1);
            bookType =  new BookType(id,name);
            listData.add(bookType);
        }
        return listData;
    }
}
