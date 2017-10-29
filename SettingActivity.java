package com.example.live_pc.weathercondition.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.live_pc.weathercondition.R;

public class SettingActivity extends AppCompatActivity {
    Button btnelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Setting");
        //  actionBar.setCustomView(R.color.colorAccen);

        String[] mobileArray = new String[]{"Jaffna", "Kilinochchi", "Mannar", "Mullaitivu",
                "Vavuniya", "Puttalam", "Kurunegala", "Gampaha", "Colombo", "Kalutara", "Anuradhapura", "Polonnaruwa",
                "Matale", "Kandy", "Nuwara", "Kegalle", "Ratnapura", "Trincomalee", "Batticaloa", "Ampara",
                "Badulla", "Monaragala", "Hambantota", "Matara", "Galle"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, mobileArray);
        final AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.select);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.RED);

        btnelected = (Button) findViewById(R.id.btnselected);

        btnelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String City = actv.getText().toString().trim();
                ProgressDialog pDialog = ProgressDialog.show(SettingActivity.this, "", "Wait ...", true);
                new Thread(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SettingActivity.this, MainActivity.class);


                        //Pass the image title and url to DetailsActivity
                        intent.putExtra("City_Name", City);


                        //Start details activity
                        startActivity(intent);
//
                    }
                }).start();
                pDialog.dismiss();
            }
        });


    }
}
