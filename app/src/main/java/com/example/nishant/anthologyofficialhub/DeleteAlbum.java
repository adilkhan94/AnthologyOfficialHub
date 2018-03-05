package com.example.nishant.anthologyofficialhub;

import android.content.Intent;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.System.exit;

public class DeleteAlbum extends AppCompatActivity {
    Button button;
    String s1, category, album, result="", result1="";
    EditText editText1, editText2;
    Spinner spinner1, spinner2;
    String URL_Register1="http://192.168.75.1/albumFetch.php";
    String URL_Register="http://192.168.75.1/categoryFetch.php";
    ArrayAdapter<String> arrayAdapter, arrayAdapter1;
    ArrayList<String> temp, temp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_album);


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
        editText2 = (EditText) findViewById(R.id.editText2);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        editText1.setInputType(InputType.TYPE_NULL);
        editText2.setInputType(InputType.TYPE_NULL);


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
            JSONArray jsonArray = jsonObject.getJSONArray("AP_Type");
            Toast.makeText(this, "lllll", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "" + jsonArray, Toast.LENGTH_SHORT).show();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                JSONArray jsonArray1 = jsonObject1.getJSONArray("AP_Type");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    temp.add(jsonArray1.getString(j));
                }
                arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temp);
                spinner1.setAdapter(arrayAdapter);
                category = jsonArray1.getString(0);
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }








        try {
            url = new URL(URL_Register1);
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
            result1 = stringBuilder.toString();

            bufferedReader.close();
            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObjecta = null;
        try {
            temp1 = new ArrayList<String>();
            jsonObjecta = new JSONObject(result1);
            Toast.makeText(this, "kk", Toast.LENGTH_SHORT).show();
            JSONArray jsonArraya = jsonObjecta.getJSONArray("P_Name");
            Toast.makeText(this, "lllll", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "" + jsonArraya, Toast.LENGTH_SHORT).show();
            for (int l = 0; l < jsonArraya.length(); l++) {
                JSONObject jsonObjecta1 = jsonArraya.getJSONObject(l);
                JSONArray jsonArraya1 = jsonObjecta1.getJSONArray("P_Name");
                for (int k = 0; k < jsonArraya1.length(); k++) {
                    temp1.add(jsonArraya1.getString(k));
                }
                arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temp);
                spinner2.setAdapter(arrayAdapter1);
                album = jsonArraya1.getString(0);
                Toast.makeText(this, "" + album, Toast.LENGTH_SHORT).show();
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


        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner2.setVisibility(View.VISIBLE);
                spinner2.performClick();
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        //  album = temp1[i];
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
                }else if (album == null) {
                    editText2.setError("Please Choose an Album");
                } else {
                    phpjoin();
                }

            }
        });
    }

    public void phpjoin() {
        String type = "SongAlbumDelete";
        Bgwork bgwork = new Bgwork(this);
        bgwork.execute(type, album, category);
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
                Intent intent= new Intent(DeleteAlbum.this, AboutUs.class);
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
                Intent inten= new Intent(DeleteAlbum.this, LoginPage.class);
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
