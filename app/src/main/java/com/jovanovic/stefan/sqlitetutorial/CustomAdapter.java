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
    private ArrayList adding_id, adding_doctor, adding_specialization, adding_patient, adding_pid, adding_email, adding_channel, adding_disease;

    CustomAdapter(Activity activity, Context context, ArrayList adding_id, ArrayList adding_doctor, ArrayList adding_specialization, ArrayList adding_patient, ArrayList adding_pid,ArrayList adding_email, ArrayList adding_channel,
                  ArrayList adding_disease){
        this.activity = activity;
        this.context = context;
        this.adding_id = adding_id;
        this.adding_doctor= adding_doctor;
        this.adding_specialization = adding_specialization;
        this.adding_patient= adding_patient;
        this.adding_pid= adding_pid;
        this.adding_email= adding_email;
        this.adding_channel= adding_channel;
        this.adding_disease= adding_disease;
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
        holder.adding_id_txt.setText(String.valueOf(adding_id.get(position)));
        holder.adding_doctor_txt.setText(String.valueOf(adding_doctor.get(position)));
        holder.adding_specialization_txt.setText(String.valueOf(adding_specialization.get(position)));
        holder.adding_patient_txt.setText(String.valueOf(adding_patient.get(position)));
        holder.adding_pid_txt.setText(String.valueOf(adding_pid.get(position)));
        holder.adding_email_txt.setText(String.valueOf(adding_email.get(position)));
        holder.adding_channel_txt.setText(String.valueOf(adding_channel.get(position)));
        holder.adding_disease_txt.setText(String.valueOf(adding_disease.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(adding_id.get(position)));
                intent.putExtra("doctor", String.valueOf(adding_doctor.get(position)));
                intent.putExtra("specialization", String.valueOf(adding_specialization.get(position)));
                intent.putExtra("patient", String.valueOf(adding_patient.get(position)));
                intent.putExtra("pid", String.valueOf(adding_pid.get(position)));
                intent.putExtra("email", String.valueOf(adding_email.get(position)));
                intent.putExtra("channel", String.valueOf(adding_channel.get(position)));
                intent.putExtra("disease", String.valueOf(adding_disease.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return adding_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView adding_id_txt, adding_doctor_txt, adding_specialization_txt, adding_patient_txt, adding_pid_txt, adding_email_txt, adding_channel_txt, adding_disease_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            adding_id_txt = itemView.findViewById(R.id.adding_id_txt);
            adding_doctor_txt = itemView.findViewById(R.id.adding_doctor_txt);
            adding_specialization_txt = itemView.findViewById(R.id.adding_specialization_txt);
            adding_patient_txt = itemView.findViewById(R.id.adding_patient_txt);
            adding_pid_txt = itemView.findViewById(R.id.adding_pid_txt);
            adding_email_txt = itemView.findViewById(R.id.adding_email_txt);
            adding_channel_txt = itemView.findViewById(R.id.addding_channel_txt);
            adding_disease_txt = itemView.findViewById(R.id.adding_disease_txt);

            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
