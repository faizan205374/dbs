package com.example.dbs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseHelper = new DatabaseHelper(this);
        // OnClickListener for View All button
    }
    public void openShowDataActivity(View view) {
        Intent intent = new Intent(MainActivity2.this,
                ShowDataActivity.class);
        startActivity(intent);
    }
    public void openAddActivity(View view) {
        Intent intent = new Intent(MainActivity2.this, AddActivity.class);
        startActivity(intent);
    }
    public void openUpdateActivity(View view) {
        Intent intent = new Intent(MainActivity2.this, UpdateActivity.class);
        startActivity(intent);
    }
    public void openDeleteActivity(View view) {
        Intent intent = new Intent(MainActivity2.this, DeleteActivity.class);
        startActivity(intent);
    }
}
