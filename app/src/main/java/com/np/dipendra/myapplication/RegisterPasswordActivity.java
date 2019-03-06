package com.np.dipendra.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class RegisterPasswordActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView textViewStudentName;
    private TextView textViewStudentFaculty;
    private TextView textViewNotMe;
    private EditText editTextNewPassword;
    private EditText editTextEmailAddress;
    private Button buttonRegister;
    private TextView textViewSid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);
        textViewStudentName = findViewById(R.id.student_name);
        textViewStudentFaculty = findViewById(R.id.student_program);
        textViewNotMe = findViewById(R.id.not_me);
        editTextNewPassword = findViewById(R.id.register_password);
        editTextEmailAddress = findViewById(R.id.email_address);
        buttonRegister = findViewById(R.id.confirm_button);

        textViewSid = findViewById(R.id.sid_reg);
        String sid = getIntent().getStringExtra("sid");
        textViewSid.setText(sid);
        String sname = getIntent().getStringExtra("sname");
        textViewStudentName.setText(sname);

        String sfaculty = getIntent().getStringExtra("sfaculty");
        textViewStudentFaculty.setText(sfaculty);


        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });
        textViewNotMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(RegisterPasswordActivity.this, CheckSIDActivity.class));
            }
        });

    }

    private void performRegistration() {
        final String emailAddress = editTextEmailAddress.getText().toString().trim();
        final String password = editTextNewPassword.getText().toString().trim();
        final String sid = textViewSid.getText().toString();
        if (TextUtils.isEmpty(emailAddress)) {
            editTextEmailAddress.setError("Required");
            editTextEmailAddress.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            editTextNewPassword.setError("Required");
            editTextNewPassword.requestFocus();
            return;
        }
        class RegisterUser extends AsyncTask<Void, Void, String> {

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler requestHandler = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();

                params.put("sid", sid);
                params.put("semail", emailAddress);
                params.put("spassword", password);

                return requestHandler.sendPostRequest(URLs.URL_REGISTER, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = findViewById(R.id.progressBar2);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject();
                    if (!jsonObject.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), jsonObject
                                .getString("message"), Toast.LENGTH_SHORT).show();
                        JSONObject object = jsonObject.getJSONObject("user");
                        Modal modal = new Modal(
                                object.getString("sid"),
                                object.getString("semail")
                        );

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        RegisterUser ru = new RegisterUser();
        ru.execute();
    }
}
