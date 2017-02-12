package com.praful.sksprojectmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.praful.sksprojectmanager.ProjectList.ProjectsActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputUserName, inputPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            inputUserName = (EditText)findViewById(R.id.inputUserName);
            inputPassword = (EditText)findViewById(R.id.inputPassword);
            btnLogin = (Button)findViewById(R.id.btnLogin);

           final String user = inputUserName.getText().toString();
           final String pass = inputPassword.getText().toString();

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                        Toast.makeText(LoginActivity.this, "No field can be empty", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ProjectsActivity.class);
                    startActivity(intent);
                }
            });
    }
}
