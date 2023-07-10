package com.example.dbs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity3 extends AppCompatActivity {
    DatabaseHelper1 databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        databaseHelper = new DatabaseHelper1(this);
        // OnClickListener for View All button
    }
    public void openShowDataActivity(View view) {
        Intent intent = new Intent(MainActivity3.this,ShowDataActivity1.class);
        startActivity(intent);
    }
    public void openAddActivity(View view) {
        Intent intent = new Intent(MainActivity3.this, AddActivity1.class);
        startActivity(intent);
    }
    public void openUpdateActivity(View view) {
        Intent intent = new Intent(MainActivity3.this, UpdateActivity1.class);
        startActivity(intent);
    }
    public void openDeleteActivity(View view) {
        Intent intent = new Intent(MainActivity3.this, DeleteActivity1.class);
        startActivity(intent);
    }
}
