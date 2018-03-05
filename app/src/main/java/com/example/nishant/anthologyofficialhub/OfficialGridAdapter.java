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

public class OfficialGridAdapter extends BaseAdapter {

    ArrayList names;
    String s1;
    public static Activity activity;
    public OfficialGridAdapter(Activity activity, ArrayList names) {
        this.activity = activity;
        this.names = names;
    }
public OfficialGridAdapter(){}
    @Override
    public int getCount() {return names.size();    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            convertView = vi.inflate(R.layout.activity_official_grid_adapter, null);

        }
        TextView textView = (TextView) convertView.findViewById(R.id.untext);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.unimage);
        if (names.get(position).toString().equals("Employer Details")) {
            imageView.setImageResource(R.drawable.empmain);
            textView.setText("Employer Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Employer Details";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);
             }

            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Employer Tracking")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Employer Tracking");
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
        else if (names.get(position).toString().equals("Song Details")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Song Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Song Details";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Item Details")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Item Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Item Details";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);    }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Pin-Code Details")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Pin-Code Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Pin-Code Details";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);
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
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Transaction's Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inti= new Intent(activity, UpdatePlacedOrderStatus.class);
                    activity.startActivity(inti);
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
                    Intent ageintent= new Intent(activity, SellerTransactionDetail.class);
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
        else if (names.get(position).toString().equals("Update Placed Order Status")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Update Placed Order Status");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inti= new Intent(activity, UpdatePlacedOrderStatus.class);
                    activity.startActivity(inti);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Own Details")) {
            imageView.setImageResource(R.drawable.sellermain);
            textView.setText("Own Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Own Details";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("Seller Details")) {
            imageView.setImageResource(R.drawable.sellermain);
            textView.setText("Seller Details");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Seller Details";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);
        }
        else if (names.get(position).toString().equals("Delete Any User")) {
            imageView.setImageResource(R.drawable.deleteuser);
            textView.setText("Delete Any User");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent inti= new Intent(activity, DeleteUser.class);
                    activity.startActivity(inti);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }

        else if (names.get(position).toString().equals("Response Queries")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Response Queries");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Response Queries";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);
                }
            });
            Animation anim = new ScaleAnimation(0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 3f);
            anim.setFillAfter(true);
            anim.setDuration(2000);
            anim.setRepeatMode(Animation.INFINITE);
            anim.setRepeatCount(Animation.INFINITE);
            imageView.startAnimation(anim);

        }
        else if (names.get(position).toString().equals("Response Querie")) {
            imageView.setImageResource(R.drawable.loginbutton);
            textView.setText("Response Queries");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1="Response Querie";
                    Bundle getdata=new Bundle();
                    getdata.putString("Official2",s1);


                    Intent inti= new Intent(activity, Official2.class);
                    inti.putExtras(getdata);
                    activity.startActivity(inti);
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
