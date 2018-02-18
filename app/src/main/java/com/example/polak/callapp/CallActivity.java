package com.example.polak.callapp;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallActivity extends Activity {

    private Button mButtonCall;
    private EditText mEditTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        mButtonCall = findViewById(R.id.buttonCall);
        mEditTextNumber = findViewById(R.id.editTextNumber);

        mButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = mEditTextNumber.getText().toString();

                Intent intentCall = new Intent(Intent.ACTION_CALL);
                intentCall.setData(Uri.parse("tel:" + number));

                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    startActivity(intentCall);
                    return;
                }

            }
        });



    }
}
