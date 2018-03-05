package com.example.nishant.anthologyofficialhub;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import static java.lang.System.exit;

public class ViewSeller extends AppCompatActivity {
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    String URL_Register="http://192.168.75.1/sellerFetch.php";
    String result, mainems, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_seller);

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

        radioGroup = (RadioGroup) findViewById(R.id.radiog1);
        radioButton1 = (RadioButton) findViewById(R.id.male);
        radioButton2 = (RadioButton) findViewById(R.id.Female);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText1.setInputType(InputType.TYPE_NULL);
        editText2.setInputType(InputType.TYPE_NULL);
        editText3.setInputType(InputType.TYPE_NULL);
        editText4.setInputType(InputType.TYPE_NULL);
        editText5.setInputType(InputType.TYPE_NULL);
        editText6.setInputType(InputType.TYPE_NULL);
        editText7.setInputType(InputType.TYPE_NULL);
        editText8.setInputType(InputType.TYPE_NULL);
        editText9.setInputType(InputType.TYPE_NULL);
        editText10.setInputType(InputType.TYPE_NULL);
        editText11.setInputType(InputType.TYPE_NULL);

        editText1.setText(mainems);
        fetchdata();

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
            editText10.setText(sellerFetch.getA_Country());
            editText11.setText(sellerFetch.getA_State());
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
                Intent intent= new Intent(ViewSeller.this, AboutUs.class);
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
                Intent inten= new Intent(ViewSeller.this, LoginPage.class);
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
