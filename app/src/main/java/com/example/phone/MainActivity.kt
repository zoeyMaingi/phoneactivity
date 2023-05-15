package com.example.phone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest;
import android.app.Activity
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.app.ActivityCompat

public  class MainActivity extends AppCompatActivity {
    EditText edtPhoneCall;
    String telNo;
    @Override
    protected Void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        edtPhoneCall = findViewById(R.id.editTextPnNum);
    }
    private Void requestPermissionToCall(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }

    public Void callNumber(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        telNo = edtPhoneCall.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Enter number to call",Toast.LENGTH_SHORT).show();
            requestPermissionToCall();
        }
        else {
            if (telNo.trim().isEmpty())
                Toast.makeText(this, "Enter number to call",Toast.LENGTH_SHORT.show());
            requestPermissionToCall();

        }
        else {
            if (telNo.trim().isEmpty())
                Toast.makeText(this, "Enter number to call",Toast.LENGTH_SHORT.show());
        else {
            intent.setData(Uri.parse("tel:"+telNo));
                starActivity(intent);
            }
    }
    }
}
