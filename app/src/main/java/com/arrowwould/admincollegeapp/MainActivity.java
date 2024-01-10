package com.arrowwould.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.arrowwould.admincollegeapp.auth.LoginActivity;
import com.arrowwould.admincollegeapp.faculty.UpdateFaculty;
import com.arrowwould.admincollegeapp.notice.DeleteNoticeActivity;
import com.arrowwould.admincollegeapp.notice.UploadNotice;
import com.arrowwould.admincollegeapp.slider.SlideActivity;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView uploadNotice, addGalleryImage, addEbook, uplodSlide, faculty, deleteNotice, logOut;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String LOGIN_PREF = "login";
    private static final String IS_LOGIN = "isLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences(LOGIN_PREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString(IS_LOGIN, "false").equals("no")) {
            openLogin();
        }

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        uplodSlide = findViewById(R.id.uplodSlide);
        deleteNotice = findViewById(R.id.deleteNotice);
        logOut = findViewById(R.id.logOut);


        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        uplodSlide.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        logOut.setOnClickListener(this);
    }

    private void openLogin() {

        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        if (view.getId() == R.id.addNotice) {
            intent = new Intent(MainActivity.this, UploadNotice.class);
        } else if (view.getId() == R.id.addGalleryImage) {
            intent = new Intent(MainActivity.this, UploadImage.class);
        } else if (view.getId() == R.id.addEbook) {
            intent = new Intent(MainActivity.this, UploadPdfActivity.class);
        } else if (view.getId() == R.id.faculty) {
            intent = new Intent(MainActivity.this, UpdateFaculty.class);
        } else if (view.getId() == R.id.uplodSlide) {
            intent = new Intent(MainActivity.this, SlideActivity.class);
        } else if (view.getId() == R.id.deleteNotice) {
            intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
        } else if (view.getId() == R.id.logOut) {
            editor.putString("isLogin", "no");
            editor.commit();
            openLogin();
            intent = new Intent(MainActivity.this, LoginActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }


}

