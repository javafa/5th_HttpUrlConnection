package com.kodonho.android.httpurlconnection;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    Button btnGet;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editUrl);
        btnGet = findViewById(R.id.btnGet);
        textView = findViewById(R.id.textView);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = editUrl.getText().toString();
                new AsyncTask<String, Void, String>(){
                    @Override
                    protected String doInBackground(String... strings) {
                        String url = strings[0];
                        return Remote.get(url);
                    }
                    @Override
                    protected void onPostExecute(String result) {
                        textView.setText(result);
                    }
                }.execute(url);
            }
        });
    }
}
