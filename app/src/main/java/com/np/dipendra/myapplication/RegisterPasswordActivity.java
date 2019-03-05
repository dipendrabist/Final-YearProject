package com.np.dipendra.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterPasswordActivity extends AppCompatActivity {
private ProgressBar progressBar;
private TextView textViewStudentName;
private  TextView textViewStudentFaculty;
private TextView textViewNotMe;
private EditText  editTextNewPassword;
private EditText  editTextConfirmPassword;
private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);


    }
}
