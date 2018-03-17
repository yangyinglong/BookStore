package com.example.litepaltest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {

    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        title = (TextView) findViewById(R.id.title_text);
        title.setText("Add Book");
        Button add_book = (Button) findViewById(R.id.add_book);
        Button reset = (Button) findViewById(R.id.reset);
        final EditText nameEdit = (EditText) findViewById(R.id.name);
        final EditText authorEdit = (EditText) findViewById(R.id.author);
        final EditText pagesEdit = (EditText) findViewById(R.id.pages);
        final EditText priceEdit = (EditText) findViewById(R.id.price);


        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName(nameEdit.getText().toString());
                book.setAuthor(authorEdit.getText().toString());
                book.setPrice(Double.parseDouble(priceEdit.getText().toString()));
                book.setPages(Integer.parseInt(pagesEdit.getText().toString()));
                book.save();
                Toast.makeText(AddDataActivity.this, "Add book success", Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEdit.setText(null);
                authorEdit.setText(null);
                priceEdit.setText(null);
                pagesEdit.setText(null);
            }
        });



    }
}
