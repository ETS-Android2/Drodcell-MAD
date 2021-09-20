package com.jovanovic.stefan.sqlitetutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList medi_id, medi_pid, medi_preid,medi_doc,medi_name,medi_address,medi_contact, medi_nic;

    CustomAdapter(Activity activity, Context context, ArrayList medi_id, ArrayList medi_pid, ArrayList medi_preid,
                  ArrayList   medi_doc      ,  ArrayList medi_name    ,  ArrayList  medi_address  ,  ArrayList   medi_contact      ,

                  ArrayList medi_nic){
        this.activity = activity;
        this.context = context;
        this.medi_id = medi_id;
        this.medi_pid = medi_pid;
        this.medi_preid = medi_preid;
        this.medi_doc=medi_doc;
        this.medi_name=medi_name;
        this.medi_address=medi_address;
        this.medi_contact=medi_contact;
        this.medi_nic = medi_nic;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.medi_id_txt.setText(String.valueOf(medi_id.get(position)));
        holder.medi_pid_txt.setText(String.valueOf(medi_pid.get(position)));
        holder.medi_preid_txt.setText(String.valueOf(medi_preid.get(position)));
        holder.medi_doc_txt.setText(String.valueOf(medi_doc.get(position)));
        holder.medi_name_txt.setText(String.valueOf(medi_name.get(position)));

        holder.medi_address_txt.setText(String.valueOf(medi_address.get(position)));
        holder.medi_contact_txt.setText(String.valueOf(medi_contact.get(position)));
        holder.medi_nic_txt.setText(String.valueOf(medi_nic.get(position)));


        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(medi_id.get(position)));
                intent.putExtra("pid", String.valueOf(medi_pid.get(position)));
                intent.putExtra("preid", String.valueOf(medi_preid.get(position)));
                intent.putExtra("doc", String.valueOf(medi_doc.get(position)));
                intent.putExtra("name", String.valueOf(medi_name.get(position)));
                intent.putExtra("address", String.valueOf(medi_contact.get(position)));
                intent.putExtra("contact", String.valueOf(medi_contact.get(position)));


                intent.putExtra("nic", String.valueOf(medi_nic.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return medi_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView medi_id_txt, medi_pid_txt, medi_preid_txt, medi_doc_txt, medi_name_txt,medi_address_txt, medi_contact_txt,                       medi_nic_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            medi_id_txt = itemView.findViewById(R.id.medi_id_txt);
            medi_pid_txt = itemView.findViewById(R.id.medi_pid_txt);
            medi_preid_txt = itemView.findViewById(R.id.medi_preid_txt);
            medi_doc_txt = itemView.findViewById(R.id.medi_doc_txt);
            medi_name_txt = itemView.findViewById(R.id.medi_name_txt);
            medi_address_txt = itemView.findViewById(R.id.medi_address_txt);
            medi_contact_txt = itemView.findViewById(R.id.medi_contact_txt);

            medi_nic_txt = itemView.findViewById(R.id.medi_nic_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
