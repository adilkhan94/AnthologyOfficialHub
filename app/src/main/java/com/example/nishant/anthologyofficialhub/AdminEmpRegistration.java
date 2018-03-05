package com.example.nishant.anthologyofficialhub;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Base64;
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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.exit;

public class AdminEmpRegistration extends AppCompatActivity implements View.OnClickListener{

    EditText editText1, editText2, editText3, editText4, editText5, editText10, editText7, editText8, editText9, editText11, editText12, editText13, editText14;
    Button button, button1;
    byte byteArrayVar[];
    Bitmap photo, bitmap;
    String ConvertImage;
    RadioGroup radioGroup;
    int nYear, mYear, nMonth, mMonth, nDay, m1, y1, d1, mDay, m, y, d;
    DatePickerDialog datePickerDialog, datePickerDialog1;
    Spinner spinner, spinner2, spinner1;
    ImageView imageView;
    String country, designs, states, passval, dateval, emailval, mobval, gender ="Male", s1, s2, s3, s4, s5, s7, s8, s9, s11, s12, s13, s14, sf, sm, sd, sy;
    CheckBox checkBox;
    String state [], design[];
    static final int REQUEST_IMAGE_CAPTURE = 1;

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
        setContentView(R.layout.activity_admin_emp_registration);

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
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);
        editText5.setInputType(InputType.TYPE_NULL);
        editText11.setInputType(InputType.TYPE_NULL);
        editText10.setInputType(InputType.TYPE_NULL);
        editText12.setInputType(InputType.TYPE_NULL);
        spinner=(Spinner) findViewById(R.id.spinner);
        spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner2=(Spinner) findViewById(R.id.spinner2);
        imageView=(ImageView) findViewById(R.id.imageview);


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
        editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                emailValid();
            }
        });


        editText11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setVisibility(View.VISIBLE);
                spinner.performClick();
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.indiastate, R.layout.custom_layout);
                spinner1.setAdapter(adapter);
                spinner1.setVisibility(View.VISIBLE);
                country="India";
                editText11.setText("India");
                Resources res=getResources();
                state= res.getStringArray(R.array.indiastate);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Resources res=getResources();
                        if(position==0)
                        {ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.indiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter);
                            spinner1.setVisibility(View.VISIBLE);
                            country="India";
                            editText11.setText("India");
                            state= res.getStringArray(R.array.indiastate);
                        }
                        else if(position==1)
                        {ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.germanystate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter1);


                            //spinner1.setBackground(R.drawable.customtoast);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("Germany");
                            country="Germany";
                            state= res.getStringArray(R.array.germanystate);
                        }
                        else if(position==2)
                        {ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.malaysiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter2);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("Malaysia");
                            country="Malaysia";
                            state= res.getStringArray(R.array.malaysiastate);
                        }
                        else if(position==3)
                        {ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.newzealandstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter3);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("New Zealand");
                            country="New Zealand";
                            state= res.getStringArray(R.array.newzealandstate);
                        }
                        else if(position==4)
                        {ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.unitedkingdomstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter4);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("United Kingdom");
                            country="United Kingdom";
                            state= res.getStringArray(R.array.unitedkingdomstate);
                        }
                        else{
                            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(AdminEmpRegistration.this,R.array.indiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter);
                            spinner1.setVisibility(View.VISIBLE);
                            country="India";
                            state= res.getStringArray(R.array.indiastate);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editText12.setText(state[i]);
                states=state[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Resources res=getResources();
        design= res.getStringArray(R.array.designation_arrays);

        editText10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                designs="Administrator";
                spinner2.setVisibility(View.VISIBLE);
                spinner2.performClick();
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        editText10.setText(design[i]);
                        designs=design[i];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(AdminEmpRegistration.this.getPackageManager())!=null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
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

        editText13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (s13.length() < 8 && s13.length() > 13) {
                    passval="incorrect";
                    editText13.setError("Please enter correct Password of length 8-13");
                }
                else
                    passval="correct";
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = editText1.getText().toString();
                s2 = editText2.getText().toString();
                s3 = editText3.getText().toString();
                s4 = editText4.getText().toString();
                s5 = editText5.getText().toString();
                s7 = editText7.getText().toString();
                s8 = editText8.getText().toString();
                s9 = editText9.getText().toString();
                s13 = editText13.getText().toString();
                s14 = editText14.getText().toString();


                if (s1.isEmpty()) {
                    editText1.setError("Please enter Name");
                } else if (s2.isEmpty()) {
                    editText2.setError("Please enter Surname");
                } else if (s3.isEmpty() && emailval == "correct") {
                    editText3.setError("Please enter your Email-ID");
                } else if (s4.isEmpty() && mobval == "correct") {
                    editText4.setError("Please enter Mobile Number");
                }  else if (s5.isEmpty()) {
                    editText5.setError("Please enter Date of Birth");
                }else if (s7.isEmpty()) {
                    editText7.setError("Please enter Address");
                } else if (s8.isEmpty()) {
                    editText8.setError("Please enter City");
                } else if (s9.isEmpty()) {
                    editText9.setError("Please enter District");
                } else if (country.equals("")) {
                    editText11.setError("Please select Country");
                }else if (states.equals("")) {
                    editText12.setError("Please select Country");
                }else if (designs.equals("")) {
                    editText10.setError("Please select a Designation");
                } else if (s13.isEmpty() && passval == "correct") {
                    editText13.setError("Please enter Password");
                } else if (s14.isEmpty()) {
                    editText14.setError("Please Confirm Password");
                } else {
                    if (checkBox.isChecked()) {
                        if (s13.equals(s14)) {
                            phpjoin();
                        }
                        else {editText14.setError("Distinct Password");}

                    }
                    else
                    {
                        textToast.setText("Please Accept all T&C");
                        toast.show();
                    }
                }
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            photo=Bitmap.createScaledBitmap(photo,400,400,false);
            imageView.setImageBitmap(photo);
            ByteArrayOutputStream byteArrayOutputStream;
            byteArrayOutputStream=new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byteArrayVar =byteArrayOutputStream.toByteArray();
            imageView.setVisibility(View.VISIBLE);
            bitmap= BitmapFactory.decodeByteArray(byteArrayVar,0,byteArrayVar.length);
            ConvertImage= Base64.encodeToString(byteArrayVar,Base64.DEFAULT);
        }
    }
    public void phpjoin() {
        String type = "AESRegister";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, s1, s2, s3, s4, gender, s5, s7, s8, s9, country, states, designs, s13, ConvertImage);
    }

    @Override
    public void onClick(View view) {
            dobedit();
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
                Intent intent= new Intent(AdminEmpRegistration.this, AboutUs.class);
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
                Intent inten= new Intent(AdminEmpRegistration.this, LoginPage.class);
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
