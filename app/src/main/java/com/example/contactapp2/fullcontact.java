package com.example.contactapp2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fullcontact extends AppCompatActivity {

    String fname,lname,pnum,email;
    TextView firstname, lastname, phonenumber, emailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_card_full);
        firstname = findViewById(R.id.cardFnameFull);
        lastname = findViewById(R.id.cardLnameFull);
        phonenumber = findViewById(R.id.cardPnumFull);
        emailText = findViewById(R.id.cardEmailFull);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            fname = extras.getString("first");
            lname = extras.getString("last");
            pnum = extras.getString("phone");
            email = extras.getString("email");
            firstname.setText(fname);
            lastname.setText(lname);
            phonenumber.setText(pnum);
            emailText.setText(email);
        }

    }
}