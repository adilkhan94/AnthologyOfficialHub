package com.example.nishant.anthologyofficialhub;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.System.exit;

public class FragmentGridAdapter extends BaseAdapter {
    ArrayList names;
    public static Activity activity;
    public FragmentGridAdapter(Activity activity, ArrayList names) {
        this.activity = activity;
        this.names = names;
    }
    @Override
    public int getCount() {
        return  names.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            convertView = vi.inflate(R.layout.activity_fragment_grid_adapter, null);

        }
        TextView textView = (TextView) convertView.findViewById(R.id.untext);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.unimage);

        if (names.get(position).toString().equals("Add New Employer")) {
            imageView.setImageResource(R.drawable.empadd);
            textView.setText("Add New Employer");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, AdminEmpRegistration.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Update Details")) {
            imageView.setImageResource(R.drawable.empupdate);
            textView.setText("Update Employer's Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, UpdateEmp.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Delete any Employer")) {
            imageView.setImageResource(R.drawable.empdelete);
            textView.setText("Delete any Employer");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, DeleteEmp.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Transaction Details")) {
            imageView.setImageResource(R.drawable.empupdate);
            textView.setText("Transaction Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, TransactionDetail.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Delete Any Seller")) {
            imageView.setImageResource(R.drawable.empdelete);
            textView.setText("Delete any Seller");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, DeleteSeller.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Add New Pin-Code")) {
            imageView.setImageResource(R.drawable.empadd);
            textView.setText("Insert New Pin-Code");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, AddPincode.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Update Pin-Code's Details")) {
            imageView.setImageResource(R.drawable.empupdate);
            textView.setText("Update Pin-Code's Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, UpdatePincode.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Delete Any Pin-Code")) {
            imageView.setImageResource(R.drawable.empdelete);
            textView.setText("Delete Any Pin-Code");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, DeletePincode.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Employer")) {
            imageView.setImageResource(R.drawable.empadd);
            textView.setText("Employer");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, AdminEmpRegistration.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Seller")) {
            imageView.setImageResource(R.drawable.empupdate);
            textView.setText("Seller");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, UpdateEmp.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("User")) {
            imageView.setImageResource(R.drawable.empdelete);
            textView.setText("User");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ageintent= new Intent(activity, DeleteEmp.class);
                    activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Add New Song")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Add New Song");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emiintent= new Intent(activity, InsertSong.class);
                    activity.startActivity(emiintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Update Song's Details")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Update Song's Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emiintent= new Intent(activity, UpdateSong.class);
                    activity.startActivity(emiintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Delete Any Category")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Delete Any Category");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emiintent= new Intent(activity, DeleteCategory.class);
                    activity.startActivity(emiintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Delete Any Album")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Delete Any Album");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emiintent= new Intent(activity, DeleteAlbum.class);
                    activity.startActivity(emiintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Delete Any Song")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Delete Any Song");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emiintent= new Intent(activity, DeleteSong.class);
                    activity.startActivity(emiintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Add New Item")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Add New Item");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //   Intent ageintent= new Intent(activity, AGE_Calculator.class);
                    // activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("Update Item's Details")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Update Item's Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //   Intent ageintent= new Intent(activity, AGE_Calculator.class);
                    // activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("Delete Any Item")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Delete Any Item");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //   Intent ageintent= new Intent(activity, AGE_Calculator.class);
                    // activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("View Own Detail")) {
            imageView.setImageResource(R.drawable.sellerview);
            textView.setText("View Own Detail");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //   Intent ageintent= new Intent(activity, AGE_Calculator.class);
                    // activity.startActivity(ageintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("Update Own's Details")) {
            imageView.setImageResource(R.drawable.sellerupdate);
            textView.setText("Update Own's Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emiintent= new Intent(activity, UpdateOwnSeller.class);
                    activity.startActivity(emiintent);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("Exit")) {
            imageView.setImageResource(R.drawable.exit);
            textView.setText("Exit");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exit(0);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        return convertView;
    }
}
