package com.example.nishant.anthologyofficialhub;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.nishant.anthologyofficialhub.Interface.Connection;
import com.example.nishant.anthologyofficialhub.Interface.EmpDesignationFetch;
import com.example.nishant.anthologyofficialhub.Interface.PinUpdateVerify;
import com.example.nishant.anthologyofficialhub.Interface.StatusUpdateVerify;
import com.example.nishant.anthologyofficialhub.Interface.TranUpdateVerify;
import com.example.nishant.anthologyofficialhub.Interface.TranView;
import com.example.nishant.anthologyofficialhub.Interface.UpdateVerify;
import com.example.nishant.anthologyofficialhub.Interface.forget;
import com.example.nishant.anthologyofficialhub.Interface.mailfg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Nishant on 2/14/2018.
 */

public class Bgwork extends AsyncTask<String , Void, String> {

    String result="";
    String ty, s1, s2, Designation, res, ConvertImage;
    forget dd;
    mailfg dfg;
    TranView tv;
    TranUpdateVerify tuv;
    StatusUpdateVerify suv;
    PinUpdateVerify puv;
    byte b[];
    String s="info";
    Bitmap bitmap;
    Bitmap bmp;
    EmpDesignationFetch emfet;
    Connection cn;
    UpdateVerify duv;
    Context context;
    AlertDialog alertDialog;
Bgwork(Context c){ context=c;}
    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        ty=type;
        String Root_URL="http://192.168.1.3/";
        if(type.equals("Connection"))
        {
            String URL_Register=Root_URL+"ConnectionCheck.php";
            try {
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("SellerRegister"))
        {
            String URL_Register=Root_URL+"SRegister.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String EmailID = params[3];
                String ContactNo = params[4];
                String Gender = params[5];
                String DOB = params[6];
                String CompanyN = params[7];
                String Address = params[8];
                String City = params[9];
                String District = params[10];
                String Country = params[11];
                String State = params[12];
                String Pass = params[13];
                s1=EmailID;
                s2=Pass;

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8") +
                        "&" + URLEncoder.encode("A_ContactNo","Utf-8") + "=" + URLEncoder.encode(ContactNo,"Utf-8") +
                        "&" + URLEncoder.encode("A_Gender","Utf-8") + "=" + URLEncoder.encode(Gender,"Utf-8") +
                        "&" + URLEncoder.encode("A_DOB","Utf-8") + "=" + URLEncoder.encode(DOB,"Utf-8") +
                        "&" + URLEncoder.encode("A_CompanyName","Utf-8") + "=" + URLEncoder.encode(CompanyN,"Utf-8") +
                        "&" + URLEncoder.encode("A_Address","Utf-8") + "=" + URLEncoder.encode(Address,"Utf-8") +
                        "&" + URLEncoder.encode("A_City","Utf-8") + "=" + URLEncoder.encode(City,"Utf-8") +
                        "&" + URLEncoder.encode("A_District","Utf-8") + "=" + URLEncoder.encode(District,"Utf-8") +
                        "&" + URLEncoder.encode("A_Country","Utf-8") + "=" + URLEncoder.encode(Country,"Utf-8") +
                        "&" + URLEncoder.encode("A_State","Utf-8") + "=" + URLEncoder.encode(State,"Utf-8") +
                        "&" + URLEncoder.encode("A_Password","Utf-8") + "=" + URLEncoder.encode(Pass,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("SellerLogin")) {
            try {
                String URL_Register = Root_URL + "SLogin.php";
                String EmailID = params[1];
                String Pass = params[2];
                URL url = new URL(URL_Register);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_EmailID", "Utf-8") + "=" + URLEncoder.encode(EmailID, "Utf-8") +
                        "&" + URLEncoder.encode("A_Password", "Utf-8") + "=" + URLEncoder.encode(Pass, "Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("ForgetMail"))
        {
            try {
                String URL_Register=Root_URL+"ForgetRandom.php";
                String EmailID = params[1];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("U_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("EmpDesignationFetch"))
        {
            try {
                String URL_Register=Root_URL+"EmpDesignationFetch.php";
                String EmailID = params[1];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("SForget"))
        {
            try {
                String URL_Register=Root_URL+"SCorrectAfterForget.php";
                String EmailID = params[1];
                String Pass = params[2];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8") +
                        "&" + URLEncoder.encode("A_Password","Utf-8") + "=" + URLEncoder.encode(Pass,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("AESRegister"))
        {
            String URL_Register=Root_URL+"AESRegister.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String EmailID = params[3];
                String ContactNo = params[4];
                String Gender = params[5];
                String DOB = params[6];
                String Address = params[7];
                String City = params[8];
                String District = params[9];
                String Country = params[10];
                String State = params[11];
                String Designation = params[12];
                String Pass = params[13];
                String Photo=params[14];
                s1=EmailID;
                s2=Pass;
                Log.d("NJ",s);
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8") +
                        "&" + URLEncoder.encode("A_ContactNo","Utf-8") + "=" + URLEncoder.encode(ContactNo,"Utf-8") +
                        "&" + URLEncoder.encode("A_Gender","Utf-8") + "=" + URLEncoder.encode(Gender,"Utf-8") +
                        "&" + URLEncoder.encode("A_DOB","Utf-8") + "=" + URLEncoder.encode(DOB,"Utf-8") +
                        "&" + URLEncoder.encode("A_Address","Utf-8") + "=" + URLEncoder.encode(Address,"Utf-8") +
                        "&" + URLEncoder.encode("A_City","Utf-8") + "=" + URLEncoder.encode(City,"Utf-8") +
                        "&" + URLEncoder.encode("A_District","Utf-8") + "=" + URLEncoder.encode(District,"Utf-8") +
                        "&" + URLEncoder.encode("A_Country","Utf-8") + "=" + URLEncoder.encode(Country,"Utf-8") +
                        "&" + URLEncoder.encode("A_State","Utf-8") + "=" + URLEncoder.encode(State,"Utf-8") +
                        "&" + URLEncoder.encode("A_Designation","Utf-8") + "=" + URLEncoder.encode(Designation,"Utf-8") +
                        "&" + URLEncoder.encode("A_Password","Utf-8") + "=" + URLEncoder.encode(Pass,"Utf-8") +
                        "&" + URLEncoder.encode("A_Image","Utf-8") + "=" + URLEncoder.encode(Photo,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("AESUpdateVerify"))
        {
            String URL_Register=Root_URL+"AESUpdateVerify.php";
            try {
                String EmailID = params[1];
                s1=EmailID;

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("AESUpdate"))
        {
            String URL_Register=Root_URL+"AESUpdate.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String ContactNo = params[3];
                String Gender = params[4];
                String DOB = params[5];
                String Address = params[6];
                String City = params[7];
                String District = params[8];
                String Country = params[9];
                String State = params[10];
                String Designation = params[11];
                String EmailID = params[12];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_ContactNo","Utf-8") + "=" + URLEncoder.encode(ContactNo,"Utf-8") +
                        "&" + URLEncoder.encode("A_Gender","Utf-8") + "=" + URLEncoder.encode(Gender,"Utf-8") +
                        "&" + URLEncoder.encode("A_DOB","Utf-8") + "=" + URLEncoder.encode(DOB,"Utf-8") +
                        "&" + URLEncoder.encode("A_Address","Utf-8") + "=" + URLEncoder.encode(Address,"Utf-8") +
                        "&" + URLEncoder.encode("A_City","Utf-8") + "=" + URLEncoder.encode(City,"Utf-8") +
                        "&" + URLEncoder.encode("A_District","Utf-8") + "=" + URLEncoder.encode(District,"Utf-8") +
                        "&" + URLEncoder.encode("A_Country","Utf-8") + "=" + URLEncoder.encode(Country,"Utf-8") +
                        "&" + URLEncoder.encode("A_State","Utf-8") + "=" + URLEncoder.encode(State,"Utf-8") +
                        "&" + URLEncoder.encode("A_Designation","Utf-8") + "=" + URLEncoder.encode(Designation,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("AESDelete"))
        {
            String URL_Register=Root_URL+"AESDelete.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String EmailID = params[3];
                s1=EmailID;

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("PincodeInsert"))
        {
            String URL_Register=Root_URL+"PincodeInsert.php";
            try {
                String Pincode = params[1];
                String Delcharges = params[2];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("UP_Pincode","Utf-8") + "=" + URLEncoder.encode(Pincode,"Utf-8") +
                        "&" + URLEncoder.encode("UP_DeliveryCharges","Utf-8") + "=" + URLEncoder.encode(Delcharges,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("PincodeUpdateVerify"))
        {
            String URL_Register=Root_URL+"PincodeUpdateVerify.php";
            try {
                String Pincode = params[1];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("UP_Pincode","Utf-8") + "=" + URLEncoder.encode(Pincode,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("PincodeUpdate"))
        {
            String URL_Register=Root_URL+"PincodeUpdate.php";
            try {
                String Pincode = params[1];
                String Delcharges = params[2];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("UP_Pincode","Utf-8") + "=" + URLEncoder.encode(Pincode,"Utf-8") +
                        "&" + URLEncoder.encode("UP_DeliveryCharges","Utf-8") + "=" + URLEncoder.encode(Delcharges,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("PincodeDelete"))
        {
            String URL_Register=Root_URL+"PincodeDelete.php";
            try {
                String Pincode = params[1];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("UP_Pincode","Utf-8") + "=" + URLEncoder.encode(Pincode,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("UserDelete"))
        {
            String URL_Register=Root_URL+"UserDelete.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String EmailID = params[3];
                s1=EmailID;

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("SellerDelete"))
        {
            String URL_Register=Root_URL+"SellerDelete.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String EmailID = params[3];
                s1=EmailID;

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("OwnSUpdate"))
        {
            String URL_Register=Root_URL+"OwnSUpdate.php";
            try {
                String FName = params[1];
                String LName = params[2];
                String ContactNo = params[3];
                String Gender = params[4];
                String DOB = params[5];
                String Company = params[6];
                String Address = params[7];
                String City = params[8];
                String District = params[9];
                String Country = params[10];
                String State = params[11];
                String EmailID = params[12];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("A_FName","Utf-8") + "=" + URLEncoder.encode(FName,"Utf-8") +
                        "&" + URLEncoder.encode("A_LName","Utf-8") + "=" + URLEncoder.encode(LName,"Utf-8") +
                        "&" + URLEncoder.encode("A_ContactNo","Utf-8") + "=" + URLEncoder.encode(ContactNo,"Utf-8") +
                        "&" + URLEncoder.encode("A_Gender","Utf-8") + "=" + URLEncoder.encode(Gender,"Utf-8") +
                        "&" + URLEncoder.encode("A_DOB","Utf-8") + "=" + URLEncoder.encode(DOB,"Utf-8") +
                        "&" + URLEncoder.encode("A_CompanyName","Utf-8") + "=" + URLEncoder.encode(Company,"Utf-8") +
                        "&" + URLEncoder.encode("A_Address","Utf-8") + "=" + URLEncoder.encode(Address,"Utf-8") +
                        "&" + URLEncoder.encode("A_City","Utf-8") + "=" + URLEncoder.encode(City,"Utf-8") +
                        "&" + URLEncoder.encode("A_District","Utf-8") + "=" + URLEncoder.encode(District,"Utf-8") +
                        "&" + URLEncoder.encode("A_Country","Utf-8") + "=" + URLEncoder.encode(Country,"Utf-8") +
                        "&" + URLEncoder.encode("A_State","Utf-8") + "=" + URLEncoder.encode(State,"Utf-8") +
                        "&" + URLEncoder.encode("A_EmailID","Utf-8") + "=" + URLEncoder.encode(EmailID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("StatusUpdateVerify"))
        {
            String URL_Register=Root_URL+"PlacedOrderStatusUpdateVerify.php";
            try {
                String OrderID = params[1];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("OPST_OrderID","Utf-8") + "=" + URLEncoder.encode(OrderID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("StatusUpdate"))
        {
            String URL_Register=Root_URL+"PlacedOrderStatusUpdate.php";
            try {
                String OrderID = params[1];
                String Status = params[2];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("OPST_OrderID","Utf-8") + "=" + URLEncoder.encode(OrderID,"Utf-8") +
                        "&" + URLEncoder.encode("ST_Status","Utf-8") + "=" + URLEncoder.encode(Status,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(type.equals("TransactionUpdateVerify"))
        {
            String URL_Register=Root_URL+"TransactionUpdateVerify.php";
            try {
                String OrderID = params[1];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("OPT_OrderID","Utf-8") + "=" + URLEncoder.encode(OrderID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("TransactionUpdate"))
        {
            String URL_Register=Root_URL+"TransactionUpdate.php";
            try {
                String OrderID = params[1];
                String Condition = params[2];
                String TransactionID = params[3];
                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("OPT_OrderID","Utf-8") + "=" + URLEncoder.encode(OrderID,"Utf-8") +
                        "&" + URLEncoder.encode("T_Condition","Utf-8") + "=" + URLEncoder.encode(Condition,"Utf-8") +
                        "&" + URLEncoder.encode("T_TransactionID","Utf-8") + "=" + URLEncoder.encode(TransactionID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(type.equals("TransactionView"))
        {
            String URL_Register=Root_URL+"TransactionView.php";
            try {
                String OrderID = params[1];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("OPT_OrderID","Utf-8") + "=" + URLEncoder.encode(OrderID,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("SongCategoryDelete"))
        {
            String URL_Register=Root_URL+"SongCategoryDelete.php";
            try {
                String AL_Type = params[1];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("AL_Type","Utf-8") + "=" + URLEncoder.encode(AL_Type,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("SongAlbumDelete"))
        {
            String URL_Register=Root_URL+"SongAlbumDelete.php";
            try {
                String P_Name = params[1];
                String AL_Type = params[2];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("P_Name","Utf-8") + "=" + URLEncoder.encode(P_Name,"Utf-8") +
                        "&" + URLEncoder.encode("AL_Type","Utf-8") + "=" + URLEncoder.encode(AL_Type,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("SongDelete"))
        {
            String URL_Register=Root_URL+"SongDelete.php";
            try {
                String P_Name = params[1];
                String AL_Type = params[2];
                String S_Name = params[3];

                URL url=new URL(URL_Register);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Post_Data = URLEncoder.encode("S_Name","Utf-8") + "=" + URLEncoder.encode(S_Name,"Utf-8") +
                        "&" + URLEncoder.encode("AL_Type","Utf-8") + "=" + URLEncoder.encode(AL_Type,"Utf-8") +
                        "&" + URLEncoder.encode("P_Name","Utf-8") + "=" + URLEncoder.encode(P_Name,"Utf-8");
                bufferedWriter.write(Post_Data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Alert!!!");
    }

    @Override
    protected void onPostExecute(final String result) {
        alertDialog.setMessage(result);
        if(ty.equals("Connection"))
        {
            if (result.equals("There is some problem. So, Connection Lost")) {
                res = result;
                cn=(Connection)context;
                cn.send(res);
            }
        }
        else if(ty.equals("SellerRegister"))
        {
            alertDialog.setButton(Dialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(result.equals("You are already Registered"))
                    {
                        Intent k1 = new Intent(context,LoginPage.class);
                        context.startActivity(k1);
                        ((LoginPage)context).finish();
                    }

                    else
                    {
                        Bundle getdata=new Bundle();
                        getdata.putString("EmailID",s1);
                        getdata.putString("Password",s2);

                        Intent k = new Intent(context,LoginPage.class);
                        k.putExtras(getdata);
                        context.startActivity(k);
                        ((LoginPage)context).finish();
                    }
                }
            });
            alertDialog.show();
        }
        else if(ty.equals("SellerLogin"))
        {
            if (result.equals("Incorrect Password")) {
                res = result;
                dd=(forget)context;
                dd.senddata(res);
            }
            else if (result.equals("Login with correct credentials") || result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();
            }
            else
            {
                res = "NJ";
                dd=(forget)context;
                dd.senddata(res);
                Bundle getdat=new Bundle();
                Designation=result;
                getdat.putString("Designation",Designation);
                Intent l = new Intent(context, Official.class);
                l.putExtras(getdat);
                context.startActivity(l);
                ((LoginPage)context).finish();
            }
        }
        else if(ty.equals("ForgetMail"))
        {
            res=result;
            dfg=(mailfg)context;
            dfg.senddat(res);
        }
        else if(ty.equals("EmpDesignationFetch"))
        {
            res=result;
            emfet=(EmpDesignationFetch)context;
            emfet.sendfet(res);
        }
        else if(ty.equals("SForget"))
        {
            if (result.equals("Password Changed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent l = new Intent(context, LoginPage.class);
                        context.startActivity(l);
                        ((LoginPage)context).finish();
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid E-mail ID")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent l = new Intent(context, LoginPage.class);
                        context.startActivity(l);
                        ((LoginPage)context).finish();
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("AESRegister"))
        {
            alertDialog.setButton(Dialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(result.equals("You are already Registered"))
                    {
                        ((AdminEmpRegistration)context).finish();
                    }

                    else if(result.equals("Registered Successfully"))
                    {

                    }
                    else{
                        ((AdminEmpRegistration)context).finish();
                    }
                }
            });
            alertDialog.show();
        }
        else if(ty.equals("AESUpdateVerify"))
        {
            if (result.equals("Correct")) {
                res = result;
                duv=(UpdateVerify)context;
                duv.sendda(res);
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        duv = (UpdateVerify) context;
                        duv.sendda(res);
                    }
                });
            }
            else if (result.equals("Invalid E-mail ID")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        duv=(UpdateVerify)context;
                        duv.sendda(res);
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("AESUpdate"))
        {
            if (result.equals("Updated Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdateEmp)context).finish();
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdateEmp)context).finish();
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("AESDelete"))
        {
            if (result.equals("Removed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid E-mail ID")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("PincodeInsert"))
        {
            alertDialog.setButton(Dialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(result.equals("Already Inserted"))
                    {
                        ((AddPincode)context).finish();
                    }

                    else if(result.equals("Inserted Successfully"))
                    {

                    }
                    else{
                        ((AddPincode)context).finish();
                    }
                }
            });
            alertDialog.show();
        }
        else if(ty.equals("PincodeUpdateVerify"))
        {
            if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                 alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        puv=(PinUpdateVerify)context;
                        puv.sendverify(res);
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Invalid Pin-code")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        puv=(PinUpdateVerify)context;
                        puv.sendverify(res);
                    }
                });
                alertDialog.show();
            }
            else{
                res = result;
                puv=(PinUpdateVerify)context;
                puv.sendverify(res);
            }
        }
        else if(ty.equals("PincodeUpdate"))
        {
            if (result.equals("Updated Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdatePincode)context).finish();
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdatePincode)context).finish();
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("SongCategoryDelete"))
        {
            if (result.equals("Removed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid Category")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
        }
        else if(ty.equals("SongAlbumDelete"))
        {
            if (result.equals("Removed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid Album")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
        }
        else if(ty.equals("SongDelete"))
        {
            if (result.equals("Removed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid Song Name")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
        }
        else if(ty.equals("UserDelete"))
        {
            if (result.equals("Removed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid E-mail ID")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("SellerDelete"))
        {
            if (result.equals("Removed Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Invalid E-mail ID")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("OwnSUpdate"))
        {
            if (result.equals("Updated Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdateOwnSeller)context).finish();
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdateOwnSeller)context).finish();
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("StatusUpdateVerify"))
        {
            if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        puv=(PinUpdateVerify)context;
                        puv.sendverify(res);
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Invalid Order-ID")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        puv=(PinUpdateVerify)context;
                        puv.sendverify(res);
                    }
                });
                alertDialog.show();
            }
            else{
                res = result;
                suv=(StatusUpdateVerify)context;
                suv.sendveri(res);
            }
        }
        else if(ty.equals("StatusUpdate"))
        {
            if (result.equals("Updated Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdatePlacedOrderStatus)context).finish();
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((UpdatePlacedOrderStatus)context).finish();
                    }
                });

                alertDialog.show();
            }
        }



        else if(ty.equals("TransactionUpdateVerify"))
        {
            if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        tuv=(TranUpdateVerify)context;
                        tuv.sendvery(res);
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Invalid Pin-code")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        tuv=(TranUpdateVerify)context;
                        tuv.sendvery(res);
                    }
                });
                alertDialog.show();
            }
            else{
                res = result;
                tuv=(TranUpdateVerify)context;
                tuv.sendvery(res);
            }
        }
        else if(ty.equals("TransactionUpdate"))
        {
            if (result.equals("Updated Successfully")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((TransactionDetail)context).finish();
                    }
                });

                alertDialog.show();
            }
            else if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((TransactionDetail)context).finish();
                    }
                });

                alertDialog.show();
            }
        }
        else if(ty.equals("TransactionView"))
        {
            if (result.equals("Server Problem. Please Re-Register after some time or mail your query to joshinishant103@gmail.com")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        tv=(TranView)context;
                        tv.sendview(res);
                    }
                });
                alertDialog.show();
            }
            else if (result.equals("Invalid Pin-code")) {
                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        res = "Incorrect";
                        tv=(TranView)context;
                        tv.sendview(res);
                    }
                });
                alertDialog.show();
            }
            else{
                res = result;
                tv=(TranView)context;
                tv.sendview(res);
            }
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    public void che(){

        Intent l1 = new Intent("NJ" );
        l1.putExtra("result", res);
        context.sendBroadcast(l1);
    }

}
