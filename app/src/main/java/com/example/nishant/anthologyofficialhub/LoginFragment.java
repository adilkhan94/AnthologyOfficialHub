package com.example.nishant.anthologyofficialhub;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.IdRes;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LoginFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText11, editText12, editText13, editText14;
    Button button;
    TextView textView;
    RadioGroup radioGroup;
    int nYear, mYear, nMonth, mMonth, nDay, m1, y1, d1, mDay, m, y, d;
    DatePickerDialog datePickerDialog, datePickerDialog1;
    Spinner spinner, spinner1;
    ImageView imageView;
    String neshu = " ", country, states, passval, dateval, emailval, mobval, gender ="Male", s1, s2, s3, s4, s5, s6, s7, s8, s9, s11, s12, s13, s14, sf, sm, sd, sy;
    CheckBox checkBox;
    String state [];

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    public void dobedit() {
        java.util.Calendar c1 = java.util.Calendar.getInstance();
        nYear = c1.get(java.util.Calendar.YEAR);
        nMonth = c1.get(java.util.Calendar.MONTH);
        nDay = c1.get(java.util.Calendar.DAY_OF_MONTH);
        datePickerDialog1 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        final Toast toast = new Toast(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.custom_toast,null);
        final TextView textToast = (TextView) view.findViewById(R.id.textToast);
        toast.setGravity(Gravity.BOTTOM, 50, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);

        button = (Button) v.findViewById(R.id.button1);
        radioGroup = (RadioGroup) v.findViewById(R.id.radiog1);
        textView = (TextView) v.findViewById(R.id.TandC);
        checkBox = (CheckBox) v.findViewById(R.id.checkbox);
        editText1 = (EditText) v.findViewById(R.id.editText1);
        editText2 = (EditText) v.findViewById(R.id.editText2);
        editText3 = (EditText) v.findViewById(R.id.editText3);
        editText4 = (EditText) v.findViewById(R.id.editText4);
        editText5 = (EditText) v.findViewById(R.id.editText5);
        editText6 = (EditText) v.findViewById(R.id.editText6);
        editText7 = (EditText) v.findViewById(R.id.editText7);
        editText8 = (EditText) v.findViewById(R.id.editText8);
        editText9 = (EditText) v.findViewById(R.id.editText9);
        editText11 = (EditText) v.findViewById(R.id.editText11);
        editText12 = (EditText) v.findViewById(R.id.editText12);
        editText13 = (EditText) v.findViewById(R.id.editText13);
        editText14 = (EditText) v.findViewById(R.id.editText14);
        editText5.setInputType(InputType.TYPE_NULL);
        editText11.setInputType(InputType.TYPE_NULL);
        editText12.setInputType(InputType.TYPE_NULL);
        spinner=(Spinner) v.findViewById(R.id.spinner);
        spinner1=(Spinner) v.findViewById(R.id.spinner1);


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
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity(),R.array.indiastate, R.layout.custom_layout);
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
                        {ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity(),R.array.indiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter);
                            spinner1.setVisibility(View.VISIBLE);
                            country="India";
                            editText11.setText("India");
                            state= res.getStringArray(R.array.indiastate);
                        }
                        else if(position==1)
                        {ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getActivity(),R.array.germanystate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter1);


                            //spinner1.setBackground(R.drawable.customtoast);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("Germany");
                            country="Germany";
                            state= res.getStringArray(R.array.germanystate);
                        }
                        else if(position==2)
                        {ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(getActivity(),R.array.malaysiastate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter2);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("Malaysia");
                            country="Malaysia";
                            state= res.getStringArray(R.array.malaysiastate);
                        }
                        else if(position==3)
                        {ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(getActivity(),R.array.newzealandstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter3);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("New Zealand");
                            country="New Zealand";
                            state= res.getStringArray(R.array.newzealandstate);
                        }
                        else if(position==4)
                        {ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(getActivity(),R.array.unitedkingdomstate, R.layout.custom_layout);
                            spinner1.setAdapter(adapter4);
                            spinner1.setVisibility(View.VISIBLE);
                            editText11.setText("United Kingdom");
                            country="United Kingdom";
                            state= res.getStringArray(R.array.unitedkingdomstate);
                        }
                        else{
                            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity(),R.array.indiastate, R.layout.custom_layout);
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

                Toast.makeText(getActivity(), ""+country, Toast.LENGTH_SHORT).show();
                s1 = editText1.getText().toString();
                s2 = editText2.getText().toString();
                s3 = editText3.getText().toString();
                s4 = editText4.getText().toString();
                s5 = editText5.getText().toString();
                s6 = editText6.getText().toString();
                s7 = editText7.getText().toString();
                s8 = editText8.getText().toString();
                s9 = editText9.getText().toString();
                s13 = editText13.getText().toString();
                s14 = editText14.getText().toString();


                if (s1.isEmpty()) {
                    editText1.setError("Please enter your Name");
                } else if (s2.isEmpty()) {
                    editText2.setError("Please enter your Surname");
                } else if (s3.isEmpty() && emailval == "correct") {
                    editText3.setError("Please enter your Email-ID");
                } else if (s4.isEmpty() && mobval == "correct") {
                    editText4.setError("Please enter your Mobile Number");
                } else if (s5.isEmpty()) {
                    editText5.setError("Please enter your Date of Birth");
                }else if (s6.isEmpty()) {
                    editText6.setError("Please enter your Company Name");
                } else if (s7.isEmpty()) {
                    editText7.setError("Please enter your Address");
                } else if (s8.isEmpty()) {
                editText8.setError("Please enter your City");
            } else if (s9.isEmpty()) {
                    editText9.setError("Please enter your District");
                } else if (country.equals("")) {
                    editText11.setError("Please select your Country");
                }else if (states.equals("")) {
                    editText12.setError("Please select your Country");
                } else if (s13.isEmpty() && passval == "correct") {
                    editText13.setError("Please enter your Password");
                } else if (s14.isEmpty()) {
                    editText14.setError("Please Confirm your Password");
                } else {
                    if (checkBox.isChecked()) {
                        Toast.makeText(getActivity(), "1"+country+"2"+states+"3"+country, Toast.LENGTH_SHORT).show();
                         if (s13.equals(s14)) {
                             Toast.makeText(getActivity(), "kkkkkkk", Toast.LENGTH_SHORT).show();
                             neshu = "nishant";
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

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(getActivity(), TandC.class);
                getActivity().startActivity(in1);

            }
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       if (neshu != "nishant"){
           Intent in=new Intent(getActivity(), LoginPage.class);
           getActivity().startActivity(in);
           getActivity().finish();
    }}

    public void phpjoin() {
        String type = "SellerRegister";
        Bgwork bgwork = new Bgwork(getActivity());
        bgwork.execute(type, s1, s2, s3, s4, gender, s5, s6, s7, s8, s9, country, states, s13);
       }


    @Override
    public void onClick(View view) {
        dobedit();
    }
}
