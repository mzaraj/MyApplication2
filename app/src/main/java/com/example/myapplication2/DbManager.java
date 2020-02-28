package com.example.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbManager extends SQLiteOpenHelper {

    final static String BOOKTYPE = "BOOKTYPE";
    final static String BOOKS = "BOOKS";
    final static String BOOK_TYPE_COL1 = "id";
    final static String BOOK_TYPE_COL2 = "name";

    final static String BOOKS_COL1 = "id";
    final static String BOOKS_COL2 = "title";
    final static String BOOKS_COL3 = "description";
    final static String BOOKS_COL4 = "photo";


    public DbManager(Context context){
        super(context,"ksiazki", null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + BOOKTYPE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT)";
        db.execSQL(createTable);

//        String createBookType
//        db.execSQL("create table " + "ksiazki" + " (ID integer primary key autoincrement, name text )");
//
//        db.execSQL("" +
//                "create table BOOKS (" +
//                "id integer primary key autoincrement," +
//                "title text, " +
//                "description text," +
//                "photo text);");

//        System.out.println("stworzylo baze danych");

//        addBookType(new BookType("Thriller2"));
//        addBookType(new BookType("Romance2"));
//        addBookType(new BookType("Fantasy"));


//        System.out.println("wystko ok przy tworzeniu!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BOOKTYPE);
        onCreate(db);
    }

    public Cursor getBookTypes(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + BOOKTYPE ;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getBooks(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + BOOKS ;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteBookType(int id ){
//        System.out.println("usuwanie dziala");
//        id = id -1;
//        System.out.println("id do usuniecie to: " + id);
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(BOOKTYPE, BOOK_TYPE_COL1 + "=" + 2, null);


//        System.out.println("blablaba");
        String query = "DELETE FROM " + BOOKTYPE + " WHERE id = " + id;
//        System.out.println("Query do usuniecia jest takie !!!!! : " + query);
//////                + BOOK_TYPE_COL1 + " = '" + 1  + "'";
        Log.d("booktype1", "delete  book type id: " + id + query);
        db.execSQL(query);
    }

    public void deleteBooks(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + BOOKS + " WHERE "
                + "ID" + " = '" + id + "'";
        Log.d("books1", "delete  book type id: " + id + query);
        db.execSQL(query);
    }

    public void addBookType(BookType bookType){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOK_TYPE_COL1, bookType.getId());
        contentValues.put(BOOK_TYPE_COL2, bookType.getName());

        Log.d("dodano book type", "addData: Adding " + bookType );

        long result = db.insert(BOOKTYPE, null, contentValues);
        if (result == -1)
            Log.d("nie dodało typu", "d");
    }


    public void addBooks(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOKS_COL1, book.getId());
        contentValues.put(BOOKS_COL2, book.getTitle());
        contentValues.put(BOOKS_COL3, book.getDescription());
        contentValues.put(BOOKS_COL4, book.getPhotoAdress());

        Log.d("dodano book ", "addData: Adding " + book.getId() );

        long result = db.insert(BOOKS, null, contentValues);
        if (result == -1)
            Log.d("nie dodało ksiazki", "d");
    }






}
