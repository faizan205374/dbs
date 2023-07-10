package com.example.dbs;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class ShowDataActivity extends AppCompatActivity {
    DatabaseHelper db;
    TextView tvData;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        db = new DatabaseHelper(this);
        tvData = findViewById(R.id.tv_data);
        back = findViewById(R.id.button4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        viewAll();
    }
    public void viewAll() {
        Cursor res = db.getAllData();
        if (res.getCount() == 0) {
            // Show message
            showMessage("Error", "No data found");
            return;
        }
        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("Id : ").append(res.getString(0)).append("\n");
            buffer.append("Event Name : ").append(res.getString(1)).append("\n");
            buffer.append("Hall No : ").append(res.getString(2)).append("\n");
            buffer.append("City: ").append(res.getString(3)).append("\n");
            buffer.append("Customer ID : ").append(res.getString(4)).append("\n");
            buffer.append("Event Start Date : ").append(res.getString(5)).append("\n");
            buffer.append("No of Dishes : ").append(res.getString(6)).append("\n");
            buffer.append("No of Guests : ").append(res.getString(7)).append("\n\n");
        }
        // Show all data
        showMessage("Data", buffer.toString());
    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
