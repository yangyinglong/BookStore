package com.example.litepaltest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class UpdateDataActivity extends AppCompatActivity {

    private TextView title;

    private List<Book> updateBookList;

    private Book book;

    private int lengthOfBooks;

    private int index;

    private String name, oldName;

    private String author, oldAuthor;

    private int pages, oldPages;

    private double price, oldPrice;

    private EditText needUpdateBookName;

    private EditText needUpdateBookAuthor;

    private EditText updateName;

    private EditText updateAuthor;

    private EditText updatePrice;

    private EditText updatePages;

    private Button needUpdateBookReset;

    private Button needUpdateBookQuery;

    private Button updatePrevious;

    private Button updateNext;

    private Button updateRecovery;

    private Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        title = (TextView) findViewById(R.id.title_text);
        title.setText("Update Book");

        needUpdateBookName = (EditText) findViewById(R.id.query_need_update_book_name);
        needUpdateBookAuthor = (EditText) findViewById(R.id.query_need_update_book_author);
        updateName = (EditText) findViewById(R.id.update_book_name);
        updateAuthor = (EditText) findViewById(R.id.update_book_author);
        updatePages = (EditText) findViewById(R.id.update_book_pages);
        updatePrice = (EditText) findViewById(R.id.update_book_price);

        needUpdateBookReset = (Button) findViewById(R.id.query_need_update_reset);
        needUpdateBookQuery = (Button) findViewById(R.id.query_need_update_book);
        updatePrevious = (Button) findViewById(R.id.result_previous);
        updateNext = (Button) findViewById(R.id.result_next);
        updateRecovery = (Button) findViewById(R.id.reset_input);
        update = (Button) findViewById(R.id.update_book_data);

        needUpdateBookReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needUpdateBookName.setText(null);
                needUpdateBookAuthor.setText(null);
                Toast.makeText(UpdateDataActivity.this, "reset input", Toast.LENGTH_SHORT).show();
            }
        });

        needUpdateBookQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = needUpdateBookName.getText().toString();
                String inputAuthor = needUpdateBookAuthor.getText().toString();
                if (inputAuthor.isEmpty() && inputName.isEmpty()){
                    Toast.makeText(UpdateDataActivity.this, "Please input book name or author!", Toast.LENGTH_SHORT).show();
                }else if(inputName.isEmpty()){
                    updateBookList = DataSupport.where("author = ?", inputAuthor).find(Book.class);
                }else {
                    updateBookList = DataSupport.where("name = ?", inputName).find(Book.class);
                }

                index = 0;

                if(updateBookList !=null && !updateBookList.isEmpty()){
                    lengthOfBooks = updateBookList.size();
                    Log.d("UpdateDataActivity", "lengthOfBooks is "+String.valueOf(lengthOfBooks));
                    book = updateBookList.get(index);
                    Log.d("UpdateDataActivity", "book name is " + book.getName());
                    Log.d("UpdateDataActivity", "book author is " + book.getAuthor());
                    book = updateBookList.get(index);
                    oldName = book.getName();
                    oldAuthor = book.getAuthor();
                    oldPages = book.getPages();
                    oldPrice = book.getPrice();
                    updateName.setText(book.getName());
                    updateAuthor.setText(book.getAuthor());
                    updatePrice.setText(String.valueOf(book.getPrice()));
                    updatePages.setText(String.valueOf(book.getPages()));
                }else {
                    Toast.makeText(UpdateDataActivity.this, "no book data", Toast.LENGTH_SHORT).show();
                    Log.d("UpdateDataActivity", "no book data");
                }




            }
        });

        updatePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(updateBookList !=null && !updateBookList.isEmpty()){
                    index = index - 1;
                    if(index < 0){
                        index = index + 1;
                        Toast.makeText(UpdateDataActivity.this, "this is the first book data", Toast.LENGTH_SHORT).show();
                    }else {
                        book = updateBookList.get(index);
                        oldName = book.getName();
                        oldAuthor = book.getAuthor();
                        oldPages = book.getPages();
                        oldPrice = book.getPrice();
                        updateName.setText(book.getName());
                        updateAuthor.setText(book.getAuthor());
                        updatePrice.setText(String.valueOf(book.getPrice()));
                        updatePages.setText(String.valueOf(book.getPages()));
                        Toast.makeText(UpdateDataActivity.this, "this is the "+(index+1)+"/"+lengthOfBooks+" book data", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(UpdateDataActivity.this, "no book data", Toast.LENGTH_SHORT).show();
                }


            }
        });

        updateNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(updateBookList !=null && !updateBookList.isEmpty()){
                    index = index + 1;
                    if(index > lengthOfBooks - 1){
                        index = index - 1;
                        Toast.makeText(UpdateDataActivity.this, "this is the last book data", Toast.LENGTH_SHORT).show();
                    }else {
                        book = updateBookList.get(index);
                        oldName = book.getName();
                        oldAuthor = book.getAuthor();
                        oldPages = book.getPages();
                        oldPrice = book.getPrice();
                        updateName.setText(book.getName());
                        updateAuthor.setText(book.getAuthor());
                        updatePrice.setText(String.valueOf(book.getPrice()));
                        updatePages.setText(String.valueOf(book.getPages()));
                        Toast.makeText(UpdateDataActivity.this, "this is the "+(index + 1)+"/"+lengthOfBooks+" book data", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(UpdateDataActivity.this, "no book data", Toast.LENGTH_SHORT).show();
                }

            }
        });

        updateRecovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateName.setText(oldName);
                updateAuthor.setText(oldAuthor);
                updatePrice.setText(String.valueOf(oldPrice));
                updatePages.setText(String.valueOf(oldPages));
                Toast.makeText(UpdateDataActivity.this, "recovery data success", Toast.LENGTH_SHORT).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(updateBookList != null && !updateBookList.isEmpty()){
                    name = updateName.getText().toString();
                    author = updateAuthor.getText().toString();
                    price = Double.parseDouble(updatePrice.getText().toString());
                    pages = Integer.parseInt(updatePages.getText().toString());
                    book.setName(name);
                    book.setAuthor(author);
                    book.setPages(pages);
                    book.setPrice(price);
                    book.save();
                    Toast.makeText(UpdateDataActivity.this, "Update success", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}
