package com.example.dbs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class DeleteActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText et_deleteId;
    Button btn_delete,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        databaseHelper = new DatabaseHelper(this);
        et_deleteId = findViewById(R.id.et_delete_id);
        btn_delete = findViewById(R.id.btn_delete_donor);
        back = findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows =
                        databaseHelper.deleteDonor(et_deleteId.getText().toString());
                if (deletedRows > 0) {
                    Toast.makeText(DeleteActivity.this, "Data Deleted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DeleteActivity.this, "Data not found",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
