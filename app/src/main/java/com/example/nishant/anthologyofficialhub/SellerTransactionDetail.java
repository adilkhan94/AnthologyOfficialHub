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

import com.example.nishant.anthologyofficialhub.Interface.TranView;

import static java.lang.System.exit;

public class SellerTransactionDetail extends AppCompatActivity implements TranView{
    EditText editText1;
    TextView textView;
    Button button;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_transaction_detail);
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
        editText1 = (EditText) findViewById(R.id.editText1);
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);

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

    }

    public void phpjoin() {
        String type = "TransactionView";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1);
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
                Intent intent= new Intent(SellerTransactionDetail.this, AboutUs.class);
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
                Intent inten= new Intent(SellerTransactionDetail.this, LoginPage.class);
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
    public void sendview(String msg) {

        if (msg == null) {
            editText1.setEnabled(true);
            textView.setVisibility(View.GONE);
        } else if (msg.equals("Incorrect")) {
            editText1.setEnabled(true);
            textView.setVisibility(View.GONE);
            } else {
            editText1.setEnabled(false);
            textView.setText(msg);
            textView.setVisibility(View.VISIBLE);
        }
    }
        }
