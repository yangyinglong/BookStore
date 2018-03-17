package com.example.litepaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        Button addData = (Button) findViewById(R.id.add_data);
        Button updateData = (Button) findViewById(R.id.update_data);
        Button deleteData = (Button) findViewById(R.id.delete_data);
        Button queryData = (Button) findViewById(R.id.query_data);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_addData = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(intent_addData);
                Toast.makeText(MainActivity.this, "You clicked addData button", Toast.LENGTH_SHORT).show();
            }
        });

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_update = new Intent(MainActivity.this, UpdateDataActivity.class);
                startActivity(intent_update);
                Toast.makeText(MainActivity.this, "You clicked updateData button", Toast.LENGTH_SHORT).show();
            }
        });

        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_deleteData = new Intent(MainActivity.this, deleteDataActivity.class);
                startActivity(intent_deleteData);
                Toast.makeText(MainActivity.this, "You clicked deleteData button", Toast.LENGTH_SHORT).show();
            }
        });

        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_queryData = new Intent(MainActivity.this, QueryDataActivity.class);
                startActivity(intent_queryData);
                Toast.makeText(MainActivity.this, "You clicked query button", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
