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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class CheckSIDActivity extends AppCompatActivity {
    private EditText editTextSid;
    private Button buttonContinue;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_sid);
        editTextSid = findViewById(R.id.sid_check);
        buttonContinue = findViewById(R.id.continue_button);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSID();
            }
        });
    }

    private void checkSID() {
        final String sid = editTextSid.getText().toString().trim();
        if (TextUtils.isEmpty(sid)) {
            editTextSid.setError("Please Enter You Student ID");
            editTextSid.requestFocus();
            return;
        }

        class CheckSID extends AsyncTask<Void, Void, String> {

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler requestHandler = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();
                params.put("sid", sid);
                return requestHandler.sendPostRequest(URLs.URL_REGISTER, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //displaying the progress bar while user registers on the server
                progressBar = findViewById(R.id.progressBarCheck);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject object = new JSONObject(s);
                    if (!object.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), object
                                .getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject jsonObject = object.getJSONObject("student");
                        Modal modal = new Modal(
                                jsonObject.getString("sid")
                        );
                        finish();
                        Intent intent=new Intent(getApplicationContext(),RegisterPasswordActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
e.printStackTrace();
                }
            }
        }
        CheckSID checkSID=new CheckSID();
        checkSID.execute();
    }
}
