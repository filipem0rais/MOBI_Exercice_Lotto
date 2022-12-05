package com.example.exercice_lotto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btnPlay;
    public Button btnCall;

    public EditText number1;
    public EditText number2;
    public EditText number3;
    public EditText number4;

    public CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnCall = (Button) findViewById(R.id.btnCall);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        number3 = (EditText) findViewById(R.id.number3);
        number4 = (EditText) findViewById(R.id.number4);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        btnCall.setOnClickListener(this::Call);
        btnPlay.setOnClickListener(this::Play);
    }

    private void Play(View view) {
        if (checkBox.isChecked()){
            String url = "http://www.gemsoft.ch/test/checkNumbers.php?nombre1="+number1.getText().toString()+"&nombre2="+number2.getText().toString()+"&nombre3="+number3.getText().toString()+"&nombre4="+number4.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            this.startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Veuillez accepter les conditions",Toast.LENGTH_SHORT).show();
        }

    }

    private void Call(View view) {
        if (checkBox.isChecked()){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0800800800"));
            this.startActivity(intentCall);
        } else {
            Toast.makeText(getApplicationContext(),"Veuillez accepter les conditions",Toast.LENGTH_SHORT).show();
        }


    }
}