package com.example.nishant.anthologyofficialhub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.nishant.anthologyofficialhub.Interface.EmpDesignationFetch;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Official extends AppCompatActivity implements EmpDesignationFetch {

    GridView gridView;
    OfficialGridAdapter adapter;
    public static Activity context;
    ArrayList<String> basicFields;
    String admin="Seller", s, Designation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official);

       s= SharedPrefManager.getInstance(this).getUserEmail();
        Bgwork bgwork = new Bgwork(this);
        String type = "EmpDesignationFetch";
        bgwork.execute(type, s);

        if(!SharedPrefManager.getInstance(this).isLoggedIn())
        {
            finish();
            startActivity(new Intent(Official.this, LoginPage.class));
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        gridView=(GridView) findViewById(R.id.gridy);

    }



    @Override
    public void sendfet(String msg) {
        if(msg.equals("Employer")) {
            Designation = msg;
        }
        else if(msg.equals("Administrator")) {
            Designation = msg;
        }
        else if(msg.equals("Seller")) {
            Designation = msg;
        }

        admin=Designation;
        basicFields= new ArrayList<>();
        context=Official.this;
        if(admin.equals("Administrator")) {
            basicFields.add("Employer Details");
            basicFields.add("Employer Tracking");
            basicFields.add("Song Details");
            basicFields.add("Item Details");
            basicFields.add("Seller Details");
            basicFields.add("Pin-Code Details");
            basicFields.add("Update Placed Order Status");
            basicFields.add("Delete Any User");
            basicFields.add("Response Queries");
            basicFields.add("Exit");
        }
        else if(admin.equals("Seller"))
        {
            basicFields.add("Item Details");
            basicFields.add("Own Details");
            basicFields.add("Transaction Details");
            basicFields.add("Exit");
        }
        else if (admin.equals("Employer")){
            basicFields.add("Song Details");
            basicFields.add("Item Details");
            basicFields.add("Pin-Code Details");
            basicFields.add("Update Placed Order Status");
            basicFields.add("Seller Details");
            basicFields.add("Delete Any User");
            basicFields.add("Response Querie");
            basicFields.add("Exit");

        }
        adapter=new OfficialGridAdapter(context,basicFields);
        gridView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.about:
                Intent intent= new Intent(Official.this, AboutUs.class);
                startActivity(intent);
                break;
            case R.id.rate:
                Uri uri=Uri.parse("market://details?id=com.developer.hp.unifiedcalculator");
                Intent rateIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(rateIntent);
                break;

            case R.id.logout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                Intent inten= new Intent(Official.this, LoginPage.class);
                startActivity(inten);
                break;
            case R.id.exit:
                exit(0);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}