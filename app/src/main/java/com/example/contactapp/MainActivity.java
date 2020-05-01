package com.example.contactapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;

public class MainActivity extends AppCompatActivity {

    adapterRV adapter;
    ArrayList<Contacts> mContactsList;
    private RecyclerView.LayoutManager layoutManager;
    String fname,lname,pnum,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_add_black_24dp);
        fab.setOnClickListener(onAddingListener());
        //setting recycler view
        RecyclerView rv = (RecyclerView) findViewById(R.id.contactRV);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rv.setHasFixedSize(true);

        // use a linear layout manager
        rv.setLayoutManager(new LinearLayoutManager(this));
        // specify an adapter (see also next example)
        mContactsList = new ArrayList<>();


        adapter = new adapterRV(this, mContactsList);
        rv.setAdapter(adapter);
    }

    private View.OnClickListener onAddingListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_contact); //layout for dialog
                dialog.setTitle("Add a new friend");
                dialog.setCancelable(false); //none-dismiss when touching outside Dialog
                // set the custom dialog components - texts and image
                EditText fname = (EditText) dialog.findViewById(R.id.fnamedia);
                EditText lname = (EditText) dialog.findViewById(R.id.lnamedia);
                EditText pnum = (EditText) dialog.findViewById(R.id.pnumdia);
                EditText email = (EditText) dialog.findViewById(R.id.emaildia);
                View btnAdd = dialog.findViewById(R.id.btn_ok);
                View btnCancel = dialog.findViewById(R.id.btn_cancel);
                btnAdd.setOnClickListener(onConfirmListener(fname, lname, pnum, email, dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));

                dialog.show();
            }
        };
    }

    private View.OnClickListener onConfirmListener(final EditText fname, final EditText lname, final EditText pnum, final EditText email, final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacts contacts = new Contacts(fname.getText().toString().trim(), lname.getText().toString().trim(), pnum.getText().toString().trim(), email.getText().toString().trim());

                //adding new object to arraylist
                mContactsList.add(contacts);

                //notify data set changed in RecyclerView adapter
                adapter.notifyDataSetChanged();

                //close dialog after all
                dialog.dismiss();
            }
        };
    }

    private View.OnClickListener onCancelListener(final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
