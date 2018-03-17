package com.example.litepaltest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class deleteDataActivity extends AppCompatActivity {

    private TextView title;

    private Button deleteData;

    private EditText nameEdit;

    private EditText authorEidt;

    private EditText priceEdit1, priceEdit2;

    private EditText pagesEdit1, pagesEdit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        title = (TextView) findViewById(R.id.title_text);
        title.setText("Delete Book");
        deleteData = (Button) findViewById(R.id.delete_data);
        nameEdit = (EditText) findViewById(R.id.need_delete_book_name);
        authorEidt = (EditText) findViewById(R.id.need_delete_book_author);
        priceEdit1 = (EditText) findViewById(R.id.need_delete_book_price_low);
        priceEdit2 = (EditText) findViewById(R.id.need_delete_book_price_height);
        pagesEdit1 = (EditText) findViewById(R.id.need_delete_book_pages_low);
        pagesEdit2 = (EditText) findViewById(R.id.need_delete_book_pages_height);

        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                String author = authorEidt.getText().toString();
                double priceLow = Double.parseDouble(priceEdit1.getText().toString());
                double priceHight = Double.parseDouble(priceEdit2.getText().toString());
                int pagesLow = Integer.parseInt(pagesEdit1.getText().toString());
                int pagesHight = Integer.parseInt(pagesEdit2.getText().toString());


            }
        });

    }
}
