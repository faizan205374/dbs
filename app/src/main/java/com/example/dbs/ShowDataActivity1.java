package com.example.dbs;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class ShowDataActivity1 extends AppCompatActivity {
    DatabaseHelper1 db;
    TextView tvData;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data1);
        db = new DatabaseHelper1(this);
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
        Cursor res = db.getAllData1();
        if (res.getCount() == 0) {
            // Show message
            showMessage("Error", "No data found");
            return;
        }
        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("Id : ").append(res.getString(0)).append("\n");
            buffer.append("User Name : ").append(res.getString(1)).append("\n");
            buffer.append("E_mail : ").append(res.getString(2)).append("\n");
            buffer.append("Phone Number : ").append(res.getString(3)).append("\n");
            buffer.append("City : ").append(res.getString(4)).append("\n");
            buffer.append("Address: ").append(res.getString(5)).append("\n");
            buffer.append("Payment Paid : ").append(res.getString(6)).append("\n");
            buffer.append("Payment Paid To : ").append(res.getString(7)).append("\n\n");
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
