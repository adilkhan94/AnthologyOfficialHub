package com.example.nishant.anthologyofficialhub;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
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

import com.example.nishant.anthologyofficialhub.Interface.UpdateVerify;

import org.json.JSONArray;
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

public class UpdateEmp extends AppCompatActivity implements UpdateVerify,View.OnClickListener{
    EditText editText1, editText2, editText3, editText4, editText5, editText7, editText8, editText9;
    Button button, button1;
    RadioGroup radioGroup;
    int nYear, mYear, nMonth, mMonth, nDay, m1, y1, d1, mDay, m, y, d;
    DatePickerDialog datePickerDialog, datePickerDialog1;
    Spinner spinner, spinner2, spinner1;
    ImageView imageView;
    LinearLayout linearLayout1, linearLayout2;
    String country, designs, states, passval, dateval, emailval, mobval, gender ="Male", s1, s2, s3, s4, s5, s7, s8, s9, s11, s12, s13, s14, sf, sm, sd, sy;
    CheckBox checkBox;
    RadioButton radioButton1, radioButton2;
    String URL_Register="http://192.168.75.1/empFetch.php";
    String result="";
    String data[];
    JSONArray jsonArray;
    ArrayAdapter<String> arrayAdapter;
    String state [], design[];

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
        String ems = editText1.getText().toString();
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
        setContentView(R.layout.activity_update_emp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        actionBar.setDisplayHomeAsUpEnabled(true);

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
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText5.setInputType(InputType.TYPE_NULL);
        linearLayout1 = (LinearLayout) findViewById(R.id.linear1);
        linearLayout2 = (LinearLayout) findViewById(R.id.linear2);
        linearLayout2.setVisibility(View.GONE);
        spinner=(Spinner) findViewById(R.id.spinner);
        spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner2=(Spinner) findViewById(R.id.spinner2);


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

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Resources res=getResources();
                        if(position==0)
                        {ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(UpdateEmp.this,R.array.indiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter);
                            country="India";
                            state= res.getStringArray(R.array.indiastate);
                        }
                        else if(position==1)
                        {ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(UpdateEmp.this,R.array.germanystate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter1);
                            country="Germany";
                            state= res.getStringArray(R.array.germanystate);
                        }
                        else if(position==2)
                        {ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(UpdateEmp.this,R.array.malaysiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter2);
                            country="Malaysia";
                            state= res.getStringArray(R.array.malaysiastate);
                        }
                        else if(position==3)
                        {ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(UpdateEmp.this,R.array.newzealandstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter3);
                            country="New Zealand";
                            state= res.getStringArray(R.array.newzealandstate);
                        }
                        else if(position==4)
                        {ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(UpdateEmp.this,R.array.unitedkingdomstate, R.layout.custom_layout);
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

        Resources res=getResources();
        design= res.getStringArray(R.array.designation_arrays);

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        designs=design[i];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = editText1.getText().toString();
                if (s1.isEmpty() && emailval == "correct") {
                    editText3.setError("Please enter your Email-ID");
                } else{  phpjoin();
                }
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

    public void phpjoin() {
        String type = "AESUpdateVerify";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1);

    }
    public void phpji() {
        String type = "AESUpdate";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s2, s3, s4, gender, s5, s7, s8, s9, country, states, designs, s1);

    }

    @Override
    public void sendda(String msg) {
        if(msg.equals("Correct")) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
            fetchdata();
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout1.setEnabled(false);
            editText1.setEnabled(false);
        }
        else if(msg.equals("Incorrect")) {
            linearLayout2.setVisibility(View.INVISIBLE);
            linearLayout1.setEnabled(true);
            editText1.setEnabled(true);
        }
        }

    @Override
    public void onClick(View view) {
        dobedit();
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
            String Post_Data = URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(s1,"Utf-8");
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
            AdministratorFetch administratorFetch = new AdministratorFetch();
            administratorFetch.setA_Fname(jsonObject.getString("A_Fname"));
            administratorFetch.setA_Lname(jsonObject.getString("A_Lname"));
            administratorFetch.setA_ContactNo(jsonObject.getString("A_ContactNo"));
            administratorFetch.setA_Gender(jsonObject.getString("A_Gender"));
            administratorFetch.setA_DOB(jsonObject.getString("A_DOB"));
            administratorFetch.setA_Address(jsonObject.getString("A_Address"));
            administratorFetch.setA_City(jsonObject.getString("A_City"));
            administratorFetch.setA_District(jsonObject.getString("A_District"));
            administratorFetch.setA_Country(jsonObject.getString("A_Country"));
            administratorFetch.setA_State(jsonObject.getString("A_State"));
            administratorFetch.setA_Designation(jsonObject.getString("A_Designation"));

            editText2.setText(administratorFetch.getA_Fname());
            editText3.setText(administratorFetch.getA_Lname());
            editText4.setText(administratorFetch.getA_ContactNo());
            editText5.setText(administratorFetch.getA_DOB());
            editText7.setText(administratorFetch.getA_Address());
            editText8.setText(administratorFetch.getA_City());
            editText9.setText(administratorFetch.getA_District());
            gender= administratorFetch.getA_Gender();
            country= administratorFetch.getA_Country();
            states= administratorFetch.getA_State();
            designs= administratorFetch.getA_Designation();
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
            ArrayAdapter adapter2 = (ArrayAdapter) spinner2.getAdapter();
            if (designs != null) {
                int spinnerPosition2 = adapter2.getPosition(designs);
                spinner2.setSelection(spinnerPosition2);
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
                Intent intent= new Intent(UpdateEmp.this, AboutUs.class);
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
                Intent inten= new Intent(UpdateEmp.this, LoginPage.class);
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
