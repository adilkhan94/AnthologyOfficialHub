package com.example.nishant.anthologyofficialhub;

import android.content.Intent;
import android.net.Uri;
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

import static java.lang.System.exit;

public class DeleteEmp extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;
    String emailval, s1, s2, s3;

    public void emailValid() {
        String ems = editText3.getText().toString();
        if (ems.isEmpty()) {
            editText3.setError(null);
        } else {
            int a = ems.length();
            if (a > 6) {
                String subs = ems.substring(a - 4, a);
                String sub = ems.substring(a - 6, a);
                String asubs = ems.substring(a - 5, a);
                String asub = ems.substring(a - 7, a);
                int lio = 0;
                lio = ems.indexOf('@');
                int li = 0;
                li = ems.lastIndexOf('@');
                if ((subs.equals(".com") || sub.equals(".co.in")) && lio == li && li>0) {
                    if (asubs.equals("@.com") || asub.equals("@.co.in")) {
                        emailval = "incorrect";
                        editText3.setError("Invalid Email ID");
                    }
                    else{
                        emailval = "correct";
                        editText3.setError(null);
                    }
                }else {
                    emailval = "incorrect";
                    editText3.setError("Invalid Email ID");
                }
            } else {
                emailval = "incorrect";
                editText3.setError("Incorrect Email ID");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_emp);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        actionBar.setDisplayHomeAsUpEnabled(true);


        final Toast toast = new Toast(getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.custom_toast, null);
        final TextView textToast = (TextView) view.findViewById(R.id.textToast);
        toast.setGravity(Gravity.BOTTOM, 50, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);

        button = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                emailValid();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = editText1.getText().toString();
                s2 = editText2.getText().toString();
                s3 = editText3.getText().toString();
                if (s1.isEmpty()) {
                    editText1.setError("Please enter your Name");
                } else if (s2.isEmpty()) {
                    editText2.setError("Please enter your Surname");
                } else if (s3.isEmpty() && emailval == "correct") {
                    editText3.setError("Please enter your Email-ID");
                }else{
                    phpjoin();
                }

            }
        });
    }
    public void phpjoin() {
        String type = "AESDelete";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1, s2, s3);
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
                Intent intent= new Intent(DeleteEmp.this, AboutUs.class);
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
                Intent inten= new Intent(DeleteEmp.this, LoginPage.class);
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
