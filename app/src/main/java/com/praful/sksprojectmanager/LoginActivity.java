package com.praful.sksprojectmanager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.praful.sksprojectmanager.ProjectList.ProjectsActivity;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    private EditText inputUserName, inputPassword;
    private Button btnLogin;
    Context context;
    public static final String TAG_username = "username";
    public static final String TAG_password = "password";
    public String msg;
    public int success;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        inputUserName = (EditText) findViewById(R.id.inputUserName);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = inputUserName.getText().toString();
                String password = inputPassword.getText().toString();
                if(username.equals("") || password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "No field should be empty!", Toast.LENGTH_SHORT).show();
                }
                trytologin(username,password);
              }
        });
    }
    public void trytologin( final String username,final String password){
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                final OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url("http://192.168.56.1/sksproject/login.php?username="+username+"&password="+password)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        Log.i(TAG_username, e.getMessage());

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        Log.i(TAG_username, response.body().string());
                        try {
                            JSONObject localJSONObject = new JSONObject(client.newCall(request).execute().body().string());
                            LoginActivity.this.success = localJSONObject.getInt("success");
                            LoginActivity.this.msg = localJSONObject.getString("msg");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });
                return null;

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                startin(success);
            }
        }.execute();
    }

    public void startin(int success){
       
        if (success==1) {

            Toast.makeText(LoginActivity.this,""+success, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), ProjectsActivity.class);
            startActivity(intent);
        }
        else if (success==0)
        {
            Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Connection Error", Toast.LENGTH_SHORT).show();
    }

}