package com.example.nishant.anthologyofficialhub;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nishant.anthologyofficialhub.Interface.StatusUpdateVerify;

import static java.lang.System.exit;

public class UpdatePlacedOrderStatus extends AppCompatActivity implements StatusUpdateVerify{
    EditText editText1, editText2;
    Button button, button1;
    String s1,s2, s, s3;
    TextInputLayout textInputLayout, textInputLayout1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_placed_order_status);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Toast toast = new Toast(this.getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.custom_toast,null);
        final TextView textToast = (TextView) view.findViewById(R.id.textToast);
        toast.setGravity(Gravity.BOTTOM, 50, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);


        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView=(TextView) findViewById(R.id.textView);
        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputLayout1 = (TextInputLayout) findViewById(R.id.textInputLayout1);
        textInputLayout1.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = editText1.getText().toString();
                if (s1.isEmpty()) {
                    editText1.setError("Please enter Order-ID");
                } else {
                    phpjoin();
                }

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = editText2.getText().toString();
                s3 = textView.getText().toString();
                if (s2.isEmpty()) {
                    editText2.setError("Please enter the status");
                } else {
                    s=s3+"\n"+s2;
                    phpji();
                }

            }
        });
    }
    public void phpjoin() {
        String type = "StatusUpdateVerify";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1);
    }
    public void phpji() {
        String type = "StatusUpdate";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1, s);
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
                Intent intent= new Intent(UpdatePlacedOrderStatus.this, AboutUs.class);
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
                Intent inten= new Intent(UpdatePlacedOrderStatus.this, LoginPage.class);
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

    @Override
    public void sendveri(String msg) {

        if(msg==null) {
            editText1.setEnabled(true);
            textView.setVisibility(View.GONE);
            textInputLayout1.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
        }
        else if(msg.equals("Incorrect")) {
            editText1.setEnabled(true);
            textView.setVisibility(View.GONE);
            textInputLayout1.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
        }
        else{
            editText1.setEnabled(false);
            textView.setText(msg);
            textView.setVisibility(View.VISIBLE);
            textInputLayout1.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
        }
    }
}