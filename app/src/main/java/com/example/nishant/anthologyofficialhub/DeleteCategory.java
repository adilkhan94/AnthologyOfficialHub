package com.example.nishant.anthologyofficialhub;

import android.content.Intent;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.StrictMode;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.ArrayList;

import static java.lang.System.exit;

public class DeleteCategory extends AppCompatActivity {
    Button button;
    String s1, category, result="";
    EditText editText1;
    Spinner spinner1;
    String URL_Register="http://192.168.75.1/categoryFetch.php";
    ArrayAdapter<CategoryFetch> arrayAdapter;
    ArrayList<String> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_category);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbargradient));
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Toast toast = new Toast(this.getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.custom_toast, null);
        final TextView textToast = (TextView) view.findViewById(R.id.textToast);
        toast.setGravity(Gravity.BOTTOM, 50, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);


        button = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        editText1.setInputType(InputType.TYPE_NULL);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        URL url = null;
        try {
            url = new URL(URL_Register);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStream.close();
            result = stringBuilder.toString();

            bufferedReader.close();
            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try {
            temp = new ArrayList<String>();
            jsonObject = new JSONObject(result);
            Toast.makeText(this, "kk", Toast.LENGTH_SHORT).show();
            JSONArray jsonArray = jsonObject.getJSONArray("res");
            Toast.makeText(this, "lllll", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "" + jsonArray, Toast.LENGTH_SHORT).show();
            for (int i = 0; i < jsonArray.length(); i++)
            {
                Toast.makeText(this, "" + jsonArray.length(), Toast.LENGTH_SHORT).show();
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                String stk=jsonObject1.getString("AL_Type");

                ArrayList<CategoryFetch> list=new ArrayList<CategoryFetch>();


                CategoryFetch c=new CategoryFetch(jsonObject1.getString("AL_Type"));
                list.add(c);
                //list.add(stk);
                category =stk;
                arrayAdapter = new ArrayAdapter<CategoryFetch>(this, android.R.layout.simple_spinner_item, list);

                spinner1.setAdapter(arrayAdapter);


               // Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner1.setVisibility(View.VISIBLE);
                spinner1.performClick();
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        //  category = temp[i];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (category == null) {
                    editText1.setError("Please Choose a Category");
                } else {
                    phpjoin();
                }

            }
        });
    }

    public void phpjoin() {
        String type = "SongCategoryDelete";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, category);
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
                Intent intent= new Intent(DeleteCategory.this, AboutUs.class);
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
                Intent inten= new Intent(DeleteCategory.this, LoginPage.class);
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
