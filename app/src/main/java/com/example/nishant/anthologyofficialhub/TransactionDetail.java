package com.example.nishant.anthologyofficialhub;

import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nishant.anthologyofficialhub.Interface.TranUpdateVerify;

import static java.lang.System.exit;

public class TransactionDetail extends AppCompatActivity implements TranUpdateVerify{
    EditText editText1, editText2;
    Button button, button1;
    String s1,s2, details="Will be Transacted after Product Delivery", detail[];
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
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
        spinner = (Spinner) findViewById(R.id.spinner1);

        spinner.setVisibility(View.GONE);
        editText2.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = editText1.getText().toString();
                if (s1.isEmpty()) {
                    editText1.setError("Please enter Order ID");
                } else {
                    phpjoin();
                }

            }
        });

        Resources res=getResources();
        detail= res.getStringArray(R.array.transaction_arrays);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                details=detail[i];
                Toast.makeText(TransactionDetail.this, ""+details, Toast.LENGTH_SHORT).show();
                if(details.equals("Transacted Successfully")){
                    editText2.setVisibility(View.VISIBLE);
                }
                else{
                    editText2.setVisibility(View.GONE);}
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = editText2.getText().toString();

                if(details.equals("Transacted Successfully")) {
                    if (s2.isEmpty()) {
                        editText2.setError("Please enter Transaction ID");
                    }
                }
                    phpji();

            }
        });
    }
    public void phpjoin() {
        String type = "TransactionUpdateVerify";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1);
    }
    public void phpji() {
        String type = "TransactionUpdate";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1, details, s2);
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
                Intent intent= new Intent(TransactionDetail.this, AboutUs.class);
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
                Intent inten= new Intent(TransactionDetail.this, LoginPage.class);
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
    public void sendvery(String msg) {

        if(msg ==null) {
            editText1.setEnabled(true);
            spinner.setVisibility(View.GONE);
            editText2.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
        }
        else if(msg.equals("Incorrect")) {
            editText1.setEnabled(true);
            spinner.setVisibility(View.GONE);
            editText2.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
        }
        else{
            editText1.setEnabled(false);
            ArrayAdapter adapter = (ArrayAdapter) spinner.getAdapter();
            if (msg != null) {
                int spinnerPosition = adapter.getPosition(msg);
                spinner.setSelection(spinnerPosition);
                if(spinnerPosition==4)
                {details=msg;
                    editText2.setVisibility(View.VISIBLE);
                }
                else{details=msg;
                    editText2.setVisibility(View.GONE);
                }
            }
            spinner.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
        }
    }
}
