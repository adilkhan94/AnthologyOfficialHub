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
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Official2 extends AppCompatActivity {

    GridView gridView;
    FragmentGridAdapter adapter;
    public static Activity context;
    ArrayList<String> basicFields;
    String admin="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle getData=getIntent().getExtras();
        if(getData !=null)
        {
            String off=getData.getString("Official2");
            admin=off;
         }
        basicFields= new ArrayList<>();
        context=this;
        setContentView(R.layout.activity_official2);
        gridView=(GridView) findViewById(R.id.gridy);
        if(admin.equals("Employer Details")) {
            basicFields.add("Add New Employer");
            basicFields.add("Update Details");
            basicFields.add("Delete any Employer");
            basicFields.add("Exit");
        }
        else if(admin.equals("Song Details")) {
            basicFields.add("Add New Song");
            basicFields.add("Update Song's Details");
            basicFields.add("Delete Any Category");
            basicFields.add("Delete Any Album");
            basicFields.add("Delete Any Song");
            basicFields.add("Exit");
        }
        else if(admin.equals("Item Details")) {
            basicFields.add("Add New Item");
            basicFields.add("Update Item's Details");
            basicFields.add("Delete Any Item");
            basicFields.add("Exit");
        }
        else if(admin.equals("Pin-Code Details")) {
            basicFields.add("Add New Pin-Code");
            basicFields.add("Update Pin-Code's Details");
            basicFields.add("Delete Any Pin-Code");
            basicFields.add("Exit");
        }
        else if(admin.equals("Seller Details")) {
            basicFields.add("Delete Any Seller");
            basicFields.add("Transaction Details");
        }
        else if(admin.equals("Response Queries")) {
            basicFields.add("Employer");
            basicFields.add("Seller");
            basicFields.add("User");
            basicFields.add("Exit");
        }
        else if(admin.equals("Response Querie")) {
            basicFields.add("Seller");
            basicFields.add("User");
        }
        else if(admin.equals("Own Details")) {
            basicFields.add("View Own Detail");
            basicFields.add("Update Own's Details");
            }

        adapter=new FragmentGridAdapter(context,basicFields);
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
                Intent intent= new Intent(Official2.this, AboutUs.class);
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
                Intent inten= new Intent(Official2.this, LoginPage.class);
                startActivity(inten);
                break;
            case R.id.exit:
                exit(0);
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
