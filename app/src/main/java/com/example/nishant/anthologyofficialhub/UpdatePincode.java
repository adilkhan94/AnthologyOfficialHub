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

import com.example.nishant.anthologyofficialhub.Interface.PinUpdateVerify;

import static java.lang.System.exit;

public class UpdatePincode extends AppCompatActivity implements PinUpdateVerify{
    EditText editText1, editText2;
    Button button, button1;
    String s1,s2, pinval;
    TextInputLayout textInputLayout, textInputLayout1;

    public void pinValid() {
        String cns = editText1.getText().toString();
        if (cns.isEmpty()) {
            editText1.setError(null);
        } else {
            int a = cns.length();
            if (a < 6) {
                pinval = "incorrect";
                editText1.setError("Incorrect Mobile Number");
            } else {
                pinval = "correct";
                editText1.setError(null);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pincode);

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
        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputLayout1 = (TextInputLayout) findViewById(R.id.textInputLayout1);
        textInputLayout1.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);

        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                pinValid();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = editText1.getText().toString();
                if (s1.isEmpty() && pinval == "correct") {
                    editText1.setError("Please enter Pincode");
                } else {
                    phpjoin();
                }

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = editText2.getText().toString();
                if (s2.isEmpty()) {
                    editText2.setError("Please enter the Delivery Charges");
                } else {
                    phpji();
                }

            }
        });

    }
    public void phpjoin() {
        String type = "PincodeUpdateVerify";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1);
    }
    public void phpji() {
        String type = "PincodeUpdate";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1, s2);
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
                Intent intent= new Intent(UpdatePincode.this, AboutUs.class);
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
                Intent inten= new Intent(UpdatePincode.this, LoginPage.class);
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
    public void sendverify(String msg) {

        if(msg ==null) {
            editText1.setEnabled(true);
            textInputLayout1.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
        }
        else if(msg.equals("Incorrect")) {
            editText1.setEnabled(true);
            textInputLayout1.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
        }
        else{
            editText1.setEnabled(false);
            editText2.setText(msg);
            textInputLayout1.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
        }
    }
}
