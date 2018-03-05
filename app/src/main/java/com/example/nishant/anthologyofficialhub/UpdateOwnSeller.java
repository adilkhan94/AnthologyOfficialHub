package com.example.nishant.anthologyofficialhub;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.StrictMode;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.exit;

public class UpdateOwnSeller extends AppCompatActivity implements View.OnClickListener{
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;
    Button button, button1;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    int nYear, mYear, nMonth, mMonth, nDay, m1, y1, d1, mDay, m, y, d;
    DatePickerDialog datePickerDialog, datePickerDialog1;
    Spinner spinner, spinner1;
    ImageView imageView;
    String country, states, passval, dateval, mainems, ems, emailval, mobval, gender ="Male", s1, s2, s3, s4, s6, s5, s7, s8, s9, s11, s12, s13, s14, sf, sm, sd, sy;
    CheckBox checkBox;
    String URL_Register="http://192.168.75.1/sellerFetch.php";
    String state [],result;

    public void dobedit() {
        java.util.Calendar c1 = java.util.Calendar.getInstance();
        nYear = c1.get(java.util.Calendar.YEAR);
        nMonth = c1.get(java.util.Calendar.MONTH);
        nDay = c1.get(java.util.Calendar.DAY_OF_MONTH);
        datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int j, int j1, int j2)

            {
                y1 = j;
                m1 = j1 + 1;                  //Birthday Date
                d1 = j2;
                editText5.setText(j2 + "/" + (j1 + 1) + "/" + j);
                if (y1 > y) {
                    dateval = "incorrect";
                    editText5.setError("Invalid Date-of-Birth");
                } else if (y == y1 && m1 > m) {
                    dateval = "incorrect";
                    editText5.setError("Invalid Date-of-Birth");
                } else if (y == y1 && m1 == m && d1 > d) {
                    dateval = "incorrect";
                    editText5.setError("Invalid Date-of-Birth");
                } else {
                    dateval = "correct";
                    editText5.setError(null);
                }
            }



        }, nYear, nMonth, nDay);
        datePickerDialog1.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog1.show();
    }
    public void mobVaid() {
        String cns = editText4.getText().toString();
        if (cns.isEmpty()) {
            editText4.setError(null);
        } else {
            int a = cns.length();
            if (a < 10) {
                mobval = "incorrect";
                editText4.setError("Incorrect Mobile Number");
            } else {
                mobval = "correct";
                editText4.setError(null);
            }
        }
    }

    public void emailValid() {
        ems = editText3.getText().toString();
        if (ems.isEmpty()) {
            editText1.setError(null);
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
                        editText1.setError("Invalid Email ID");
                    }
                    else{
                        emailval = "correct";
                        editText1.setError(null);
                    }
                }else {
                    emailval = "incorrect";
                    editText1.setError("Invalid Email ID");
                }
            } else {
                emailval = "incorrect";
                editText1.setError("Incorrect Email ID");
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_own_seller);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        actionBar.setDisplayHomeAsUpEnabled(true);

        mainems=SharedPrefManager.getInstance(this).getUserEmail();

        final Toast toast = new Toast(this.getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.custom_toast,null);
        final TextView textToast = (TextView) view.findViewById(R.id.textToast);
        toast.setGravity(Gravity.BOTTOM, 50, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);

        button = (Button) findViewById(R.id.button1);
        button1 = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.radiog1);
        radioButton1 = (RadioButton) findViewById(R.id.male);
        radioButton2 = (RadioButton) findViewById(R.id.Female);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText5.setInputType(InputType.TYPE_NULL);
        spinner=(Spinner) findViewById(R.id.spinner);
        spinner1=(Spinner) findViewById(R.id.spinner1);


        editText1.setText(mainems);
        editText1.setEnabled(false);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        fetchdata();


        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);
        Date today = new Date();
        sf = dateFormatter.format(today);
        // edittext.setText(""+sf);
        sd=sf.substring(0,2);
        sm=sf.substring(3,5);
        sy=sf.substring(6);
        d=Integer.parseInt(sd);
        m=Integer.parseInt(sm);
        y=Integer.parseInt(sy);

        editText5.setOnClickListener(this);

        editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mobVaid();
            }
        });
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                emailValid();
            }
        });
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(UpdateOwnSeller.this,R.array.indiastate, R.layout.custom_layout);
                spinner1.setAdapter(adapter);
                country="India";
                Resources res=getResources();
                state= res.getStringArray(R.array.indiastate);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Resources res=getResources();
                        if(position==0)
                        {ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(UpdateOwnSeller.this,R.array.indiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter);
                            country="India";
                            state= res.getStringArray(R.array.indiastate);
                        }
                        else if(position==1)
                        {ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(UpdateOwnSeller.this,R.array.germanystate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter1);
                            country="Germany";
                            state= res.getStringArray(R.array.germanystate);
                        }
                        else if(position==2)
                        {ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(UpdateOwnSeller.this,R.array.malaysiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter2);
                            country="Malaysia";
                            state= res.getStringArray(R.array.malaysiastate);
                        }
                        else if(position==3)
                        {ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(UpdateOwnSeller.this,R.array.newzealandstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter3);
                            country="New Zealand";
                            state= res.getStringArray(R.array.newzealandstate);
                        }
                        else if(position==4)
                        {ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(UpdateOwnSeller.this,R.array.unitedkingdomstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter4);
                            country="United Kingdom";
                            state= res.getStringArray(R.array.unitedkingdomstate);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                states=state[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int selectedID = radioGroup.getCheckedRadioButtonId();
                if (selectedID == R.id.male) {
                    gender = "Male";
                } else if (selectedID == R.id.Female) {
                    gender = "Female";
                } else {
                    gender = "Male";
                }

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = editText2.getText().toString();
                s3 = editText3.getText().toString();
                s4 = editText4.getText().toString();
                s5 = editText5.getText().toString();
                s6 = editText6.getText().toString();
                s7 = editText7.getText().toString();
                s8 = editText8.getText().toString();
                s9 = editText9.getText().toString();

                if (s2.isEmpty()) {
                    editText2.setError("Please enter First Name");
                } else if (s3.isEmpty()) {
                    editText3.setError("Please enter Surname");
                } else if (s4.isEmpty() && mobval == "correct") {
                    editText4.setError("Please enter Mobile Number");
                } else if (s5.isEmpty()) {
                    editText5.setError("Please enter Date of Birth");
                } else if (s6.isEmpty()) {
                    editText6.setError("Please enter Company Name");
                } else if (s7.isEmpty()) {
                    editText7.setError("Please enter Address");
                } else if (s8.isEmpty()) {
                    editText8.setError("Please enter City");
                } else if (s9.isEmpty()) {
                    editText9.setError("Please enter District");
                }
                else {
                    phpji();}
            }
        });

    }

    public void phpji() {
        String type = "OwnSUpdate";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s2, s3, s4, gender, s5, s6, s7, s8, s9, country, states, s1);

    }

    public void fetchdata()
    {
        URL url= null;
        try {
            url = new URL(URL_Register);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String Post_Data = URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(mainems,"Utf-8");
            bufferedWriter.write(Post_Data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            StringBuilder stringBuilder=new StringBuilder();
            String line="";
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            inputStream.close();
            result=stringBuilder.toString();

            bufferedReader.close();
            httpURLConnection.disconnect();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject=null;

        try {
            jsonObject=new JSONObject(result);
            SellerFetch sellerFetch = new SellerFetch();
            sellerFetch.setA_Fname(jsonObject.getString("A_Fname"));
            sellerFetch.setA_Lname(jsonObject.getString("A_Lname"));
            sellerFetch.setA_ContactNo(jsonObject.getString("A_ContactNo"));
            sellerFetch.setA_Gender(jsonObject.getString("A_Gender"));
            sellerFetch.setA_DOB(jsonObject.getString("A_DOB"));
            sellerFetch.setA_CompanyName(jsonObject.getString("A_CompanyName"));
            sellerFetch.setA_Address(jsonObject.getString("A_Address"));
            sellerFetch.setA_City(jsonObject.getString("A_City"));
            sellerFetch.setA_District(jsonObject.getString("A_District"));
            sellerFetch.setA_Country(jsonObject.getString("A_Country"));
            sellerFetch.setA_State(jsonObject.getString("A_State"));

            editText2.setText(sellerFetch.getA_Fname());
            editText3.setText(sellerFetch.getA_Lname());
            editText4.setText(sellerFetch.getA_ContactNo());
            editText5.setText(sellerFetch.getA_DOB());
            editText6.setText(sellerFetch.getA_CompanyName());
            editText7.setText(sellerFetch.getA_Address());
            editText8.setText(sellerFetch.getA_City());
            editText9.setText(sellerFetch.getA_District());
            gender= sellerFetch.getA_Gender();
            country= sellerFetch.getA_Country();
            states= sellerFetch.getA_State();
            ArrayAdapter adapter = (ArrayAdapter) spinner.getAdapter();
            if (country != null) {
                int spinnerPosition = adapter.getPosition(country);
                spinner.setSelection(spinnerPosition);
            }
            ArrayAdapter adapter1 = (ArrayAdapter) spinner1.getAdapter();
            if (states != null) {
                int spinnerPosition1 = adapter1.getPosition(states);
                spinner1.setSelection(spinnerPosition1);
            }
            if(gender.equals("Male")){
                radioButton1.setChecked(true);
            }
            else{
                radioButton2.setChecked(true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
                Intent intent= new Intent(UpdateOwnSeller.this, AboutUs.class);
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
                Intent inten= new Intent(UpdateOwnSeller.this, LoginPage.class);
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
    public void onClick(View view) {
        dobedit();
    }
}