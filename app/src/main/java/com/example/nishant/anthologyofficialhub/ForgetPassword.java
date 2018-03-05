package com.example.nishant.anthologyofficialhub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ForgetPassword extends Fragment {

    public ForgetPassword() {
        // Required empty public constructor
    }
    EditText editText1, editText2, editText3;
    Button button1, button2;
    String s1, neshu = " ", check, message, pass, passval, cpass, id;
    LinearLayout linearLayout1, linearLayout2;

   public static ForgetPassword newInstance(String param1, String param2) {
        ForgetPassword fragment = new ForgetPassword();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public  void displayReceiveData(String msg)
    {
        if (msg !=null)
        {check=msg;}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_forget_password, container, false);
        savedInstanceState=new Bundle();
        id =getArguments().getString("EmailID");
        phpji();
        final Toast toast = new Toast(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.custom_toast,null);
        final TextView textToast = (TextView) view.findViewById(R.id.textToast);
        toast.setGravity(Gravity.BOTTOM, 50, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);

        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);
        editText1 = (EditText) v.findViewById(R.id.editText1);
        editText2 = (EditText) v.findViewById(R.id.editText2);
        editText3 = (EditText) v.findViewById(R.id.editText3);
        linearLayout1 = (LinearLayout) v.findViewById(R.id.linear1);
        linearLayout2 = (LinearLayout) v.findViewById(R.id.linear2);
        linearLayout2.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = editText1.getText().toString();
                if (s1.isEmpty()) {
                    editText1.setError("Please enter your OTP");
                }
                else if (s1.length()<5) {
                    editText1.setError("Please enter correct OTP");
                }
                else if(check.equals(s1))
                {linearLayout2.setVisibility(View.VISIBLE);
                    editText1.setEnabled(false);
                    linearLayout1.setEnabled(false);
                }

            }
        });

        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (pass.length() < 8 && pass.length() > 13) {
                    passval="incorrect";
                    editText2.setError("Please enter correct Password of length 8-13");
                }
                else
                    passval="correct";
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = editText2.getText().toString();
                cpass = editText3.getText().toString();

                if (pass.isEmpty() && passval == "correct") {
                    editText2.setError("Please enter your Password");
                }
                else if (cpass.isEmpty()) {
                    editText3.setError("Please confirm your Password");
                }

                else
                {
                    if (pass.equals(cpass)) {
                        phpjoin();
                        neshu = "nishant";
                    } else {
                        editText3.setError("Distinct Password");
                    }
                }

            }
        });
        return v;
    }

    public synchronized void phpji()
    {
        Bgwork bgwork = new Bgwork(getActivity());
        String type = "ForgetMail";
        bgwork.execute(type, id);
    }
    public synchronized void phpjoin()
    {
        Bgwork bgwork = new Bgwork(getActivity());
        String type = "SForget";
        bgwork.execute(type, id, pass);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(neshu != "nishant")
        {
            Intent in = new Intent(getActivity(), LoginPage.class);
            getActivity().startActivity(in);
            getActivity().finish();
        }
    }

}
