package com.example.dbs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class UpdateActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText et_id, et_name, et_hall_no, et_city, et_Cid, et_date , et_dishes, et_guests;
    Button btn_update,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        databaseHelper = new DatabaseHelper(this);
        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_event_name);
        et_hall_no = findViewById(R.id.et_hall_no);
        et_city = findViewById(R.id.et_city);
        et_Cid = findViewById(R.id.et_customer_id);
        et_date = findViewById(R.id.et_date);
        et_dishes = findViewById(R.id.et_dishes);
        et_guests = findViewById(R.id.et_guests);
        btn_update = findViewById(R.id.btn_update);
        back = findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = databaseHelper.updateDonor(
                        et_id.getText().toString(),
                        et_name.getText().toString(),
                        et_hall_no.getText().toString(),
                        et_city.getText().toString(),
                        et_Cid.getText().toString(),
                        et_date.getText().toString(),
                        et_dishes.getText().toString(),
                        et_guests.getText().toString());
                if (isUpdated) {
                    Toast.makeText(UpdateActivity.this, "Data Updated",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateActivity.this, "Data Update Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}