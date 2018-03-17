package com.example.litepaltest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class QueryDataActivity extends AppCompatActivity {

    private TextView title;

    private List<Book>  books;

    private EditText bookName;

    private EditText bookAuthor;

    private Button queryBook;

    private Button queryReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_data);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        title = (TextView) findViewById(R.id.title_text);
        title.setText("Query Book");

        books = DataSupport.findAll(Book.class);

        bookName = (EditText) findViewById(R.id.query_book_name);

        bookAuthor = (EditText) findViewById(R.id.query_book_author);

        queryBook = (Button) findViewById(R.id.query_book);

        queryReset = (Button) findViewById(R.id.query_reset);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(QueryDataActivity.this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        BookAdapter adapter = new BookAdapter(books);
        recyclerView.setAdapter(adapter);

        queryBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = bookName.getText().toString();

                String inputAuthor = bookAuthor.getText().toString();

                Log.d("MainActivity", inputAuthor);


                if (inputAuthor.isEmpty() && inputName.isEmpty()){
                    books = DataSupport.findAll(Book.class);
                }else if(inputName.isEmpty()) {
                    books = DataSupport.where("author = ?", inputAuthor).find(Book.class);
                }else if(inputAuthor.isEmpty()){
                    books = DataSupport.where("name = ?", inputName).find(Book.class);
                }else {
                    books = DataSupport.where("name = ? and author = ?",inputName, inputAuthor).find(Book.class);
                }

                /*for (Book book : books){
                    book.setPages(100);
                    book.save();
                }*/


                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                LinearLayoutManager layoutManager = new LinearLayoutManager(QueryDataActivity.this);
                //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                BookAdapter adapter = new BookAdapter(books);
                recyclerView.setAdapter(adapter);

                for (Book book : books){
                    Log.d("MainActivity", "book id is " + book.getId());
                    Log.d("MainActivity", "book name is " + book.getName());
                    Log.d("MainActivity", "book author is " + book.getAuthor());
                    Log.d("MainActivity", "book price is " + book.getPrice());
                    Log.d("MainActivity", "book pages is   " + book.getPages());
                }

            }
        });

        queryReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookName.setText(null);
                bookAuthor.setText(null );
            }
        });



    }
}
