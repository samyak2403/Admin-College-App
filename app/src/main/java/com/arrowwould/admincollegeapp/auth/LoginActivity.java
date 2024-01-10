package com.arrowwould.admincollegeapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.arrowwould.admincollegeapp.MainActivity;
import com.arrowwould.admincollegeapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private TextView tvShow;
    private RelativeLayout loginBtn;

    private String email, pass;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String LOGIN_PREF = "login";
    private static final String IS_LOGIN = "isLogin";
    private static final String EMAIL = "admin@gmail.com";

    private static final String PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = this.getSharedPreferences(LOGIN_PREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString(IS_LOGIN, "false").equals("yes")) {
            openDashboard();
        }

        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        tvShow = findViewById(R.id.txt_show);
        loginBtn = findViewById(R.id.login_button);

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private void togglePasswordVisibility() {
        if (userPassword.getInputType() == 144) {
            userPassword.setInputType(129);
            tvShow.setText("Hide");
        } else {
            userPassword.setInputType(144);
            tvShow.setText("Show");
        }
        userPassword.setSelection(userPassword.getText().length());
    }

    private void validateData() {
        email = userEmail.getText().toString().trim();
        pass = userPassword.getText().toString().trim();

        if (email.isEmpty()) {
            userEmail.setError("Required");
            userEmail.requestFocus();
        } else if (pass.isEmpty()) {
            userPassword.setError("Required");
            userPassword.requestFocus();
        } else if (email.equals(EMAIL) && pass.equals(PASSWORD)) {
            editor.putString(IS_LOGIN, "yes");
            editor.apply();
            openDashboard();
        } else {
            Toast.makeText(this, "Please check email and password again!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDashboard() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
