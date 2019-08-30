package com.example.navigationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DrugDeliveryActivity extends AppCompatActivity {

    private Button button;
    private EditText name,contact,email,address;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_delivery);

        name = (EditText)findViewById(R.id.name);
        contact = (EditText)findViewById(R.id.contact);
        email = (EditText)findViewById(R.id.email);
        address = (EditText)findViewById(R.id.address);
        checkBox = (CheckBox)findViewById(R.id.checkBoxDrugDelivery);

        VideoActivity();
    }

    public void VideoActivity(){

        button = (Button)findViewById(R.id.btnAddPrescription);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!validate()) {
                    Toast.makeText(DrugDeliveryActivity.this, "Order Sendig Faild", Toast.LENGTH_LONG).show();   // If data is invalid show toast message
                }

            }
        });
    }

    public boolean validate(){
        boolean valid = true;

        if (name.getText().toString().isEmpty()) { //check whether name field is empty
            name.setError("Please enter Name");  // show error message
            valid = false;
        }

        if (email.getText().toString().isEmpty()){
            email.setError("Enter email");  //show error message
            valid = false;
        }
        if (address.getText().toString().isEmpty()){
            address.setError("Enter address");      // show error message
            valid = false;
        }
        if (contact.getText().toString().isEmpty() || contact.getText().toString().length() != 10){
            contact.setError("Enter valid contact number");   // show error message
            valid = false;
        }
        return valid;    // return the result
    }
}
