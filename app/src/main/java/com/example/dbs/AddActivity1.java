package com.example.dbs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class AddActivity1 extends AppCompatActivity {
    DatabaseHelper1 databaseHelper;
    EditText et_name, et_hall_no, et_city, et_Cid, et_date , et_dishes, et_guests;
    Button btn_submit,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1);
        databaseHelper = new DatabaseHelper1(this);
        et_name = findViewById(R.id.et_event_name);
        et_hall_no = findViewById(R.id.et_hall_no);
        et_city = findViewById(R.id.et_city);
        et_Cid = findViewById(R.id.et_customer_id);
        et_date= findViewById(R.id.et_event_date);
        et_dishes = findViewById(R.id.et_no_of_dishes);
        et_guests = findViewById(R.id.et_no_of_guests);
        btn_submit = findViewById(R.id.btn_add_donor);
        back = findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertDonor1(
                        et_name.getText().toString(),
                        et_name.getText().toString(),
                        et_city.getText().toString(),
                        et_Cid.getText().toString(),
                        et_date.getText().toString(),
                        et_dishes.getText().toString(),
                        et_guests.getText().toString()
                );
                if (isInserted) {
                    Toast.makeText(AddActivity1.this, "Data Inserted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddActivity1.this, "Data insertion Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}