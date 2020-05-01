package com.example.contactapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapterRV extends RecyclerView.Adapter<adapterRV.ContactsViewHolder> {

    private ArrayList<Contacts> mContactsList;
    private Context mCtx;


    public adapterRV(Context mCtx, ArrayList<Contacts> ContactsList) {
        this.mCtx = mCtx;
        this.mContactsList = ContactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.contact_card, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        Contacts contact = mContactsList.get(position);
        holder.cardFname.setText(contact.getFname());
        holder.cardLname.setText(contact.getLname());
        holder.cardPnum.setText(contact.getPhonenum());
        holder.cardEmail.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {
        TextView cardFname, cardLname, cardPnum, cardEmail;
        CardView cv;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            cardFname = (TextView) itemView.findViewById(R.id.cardFname);
            cardLname = (TextView) itemView.findViewById(R.id.cardLname);
            cardPnum = (TextView) itemView.findViewById(R.id.cardPnum);
            cardEmail = (TextView) itemView.findViewById(R.id.cardEmail);
        }
    }
}