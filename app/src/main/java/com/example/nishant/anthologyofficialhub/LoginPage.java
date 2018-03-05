package com.example.nishant.anthologyofficialhub;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nishant.anthologyofficialhub.Interface.Connection;
import com.example.nishant.anthologyofficialhub.Interface.forget;
import com.example.nishant.anthologyofficialhub.Interface.mailfg;


public class LoginPage extends AppCompatActivity implements forget,mailfg, Connection {
    String s, s1, Pass="", EmailID="", message, emailval;//this is used to check whether it is ouched on git or nor
    TextView textView, textView1, textView2, textView3;
    EditText editText, editText1;
    Button button;
    ImageView imageView;
    LinearLayout linearLayout;
    TextInputLayout textInputLayout, textInputLayout1;




    @Override
    protected void onResume() {
        super.onResume();
//        registerReceiver(broadcastReceiver, new IntentFilter("NJ"));

    }

    @Override
    protected void onPause() {
        super.onPause();
  //      unregisterReceiver(broadcastReceiver);
    }


    public void emailValid() {
        String ems = editText.getText().toString();
        if (ems.isEmpty()) {
            editText.setError(null);
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
                        editText.setError("Invalid Email ID");
                    }
                    else{
                        emailval = "correct";
                        editText.setError(null);
                    }
                }else {
                    emailval = "incorrect";
                    editText.setError("Invalid Email ID");
                }
            } else {
                emailval = "incorrect";
                editText.setError("Incorrect Email ID");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

     //   php();
        if(SharedPrefManager.getInstance(this).isLoggedIn())
        {
            finish();
            startActivity(new Intent(LoginPage.this, Official.class));
            return;
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));

        imageView=(ImageView)findViewById(R.id.image);
        textView=(TextView)findViewById(R.id.textView);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.forget);
        editText=(EditText) findViewById(R.id.editText);
        editText1=(EditText) findViewById(R.id.editText1);
        button=(Button) findViewById(R.id.button);
        textInputLayout1=(TextInputLayout)findViewById(R.id.textInputLayout);
        textInputLayout=(TextInputLayout)findViewById(R.id.textInputLayout1);

        Bundle getData=getIntent().getExtras();
        if(getData !=null)
        {
            String EmailID=getData.getString("EmailID");
            String Password=getData.getString("Password");
            editText.setText(EmailID);
            editText1.setText(Password);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=editText.getText().toString();
                s1=editText1.getText().toString();
                if(s.isEmpty())
                {
                    editText.setError("Please enter your Email-ID");
                }
                else if(s1.isEmpty())
                {
                    editText1.setError("Please enter your correct Password");
                }
                else
                {
                    phpjoin();
                }

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                textInputLayout1.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
                textInputLayout.setVisibility(View.INVISIBLE);
                editText1.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);

                // create a FragmentManager
                FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
                LoginFragment fragmentn=new LoginFragment();             //used to provide object name to replace or add
                fragmentTransaction.add(R.id.fragment, fragmentn,"tag");
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit(); // save the changes
                //   imageView.setVisibility(View.VISIBLE);
            }
        });


        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.INVISIBLE);
                textInputLayout1.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
                textInputLayout.setVisibility(View.INVISIBLE);
                editText1.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);
                // create a FragmentManager
                s = editText.getText().toString();
                if (s.isEmpty() && emailval == "correct") {
                    editText.setError("Please enter your Email-ID");
                }
                else {
                    Bundle bnj=new Bundle();
                    bnj.putString("EmailID",s);

                    FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
                    ForgetPassword fragmentn = new ForgetPassword();             //used to provide object name to replace or add
                    fragmentn.setArguments(bnj);

                    fragmentTransaction.add(R.id.fragment, fragmentn, "tag");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit(); // save the changes
                    //   imageView.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    public synchronized void phpjoin()
    {
        Bgwork bgwork = new Bgwork(this);
        String type = "SellerLogin";
        bgwork.execute(type, s, s1);
     //   bgwork.che();
    }
    @Override
    public void senddata(String msg)
    {
        if(msg.equals("Incorrect Password")) {
            AlertDialog alertDialog = new AlertDialog.Builder(LoginPage.this).create();
            alertDialog.setTitle("Alert!!!");
            alertDialog.setMessage("Incorrect Password");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    textView3.setVisibility(View.VISIBLE);
                }
            });
            alertDialog.show();
        }
        else if(msg.equals("NJ"))
        {
            textView3.setVisibility(View.GONE);
            SharedPrefManager.getInstance(this).userLogin(s,s1);

        }

    }

    @Override
    public void senddat(String msg) {

        FragmentManager fm= getFragmentManager();
        ForgetPassword forgetPassword=(ForgetPassword) fm.findFragmentByTag("tag");
        forgetPassword.displayReceiveData(msg);
    }

    public  void php()
    {
        Bgwork bgwork = new Bgwork(this);
        String type = "Connection";
        bgwork.execute(type);
    }

    @Override
    public void send(String msg) {
        if(msg.equals("There is some problem. So, Connection Lost")) {
            LoginPage.this.finish();
            startActivity(new Intent(LoginPage.this, OfflinePage.class));
        }
        else if(msg.equals("Connected Successfully"))
        {
            LoginPage.this.finish();
            startActivity(new Intent(LoginPage.this,LoginPage.class));
        }
        else if(msg.equals("JJ")) {
            LoginPage.this.finish();
            startActivity(new Intent(LoginPage.this, OfflinePage.class));
        }
    }
}
