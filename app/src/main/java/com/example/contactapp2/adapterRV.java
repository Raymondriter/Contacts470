package com.example.contactapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterRV extends RecyclerView.Adapter<adapterRV.ContactsViewHolder> {

    private ArrayList<Contacts> mContactsList;
    private Context mCtx;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public adapterRV(Context mCtx, ArrayList<Contacts> ContactsList) {
        this.mCtx = mCtx;
        this.mContactsList = ContactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.contact_card_main, null);
        return new ContactsViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        Contacts contact = mContactsList.get(position);
        holder.cardFname.setText(contact.getFname());
        holder.cardLname.setText(contact.getLname());
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        TextView cardFname, cardLname, cardPnum, cardEmail;
        CardView cv;

        public ContactsViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            cardFname = (TextView) itemView.findViewById(R.id.cardFname);
            cardLname = (TextView) itemView.findViewById(R.id.cardLname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}