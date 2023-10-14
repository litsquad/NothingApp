package com.example.softwarereal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), PendingIntent.FLAG_IMMUTABLE);
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(intent.getAction())) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (tag != null) {
                // Use the tag to react to NFC
                Toast.makeText(getApplicationContext(), "NFC tag detected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        nfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try {
           Runtime.getRuntime().exec("su");
           //Runtime.getRuntime().exec("echo 2000 > /sys/devices/platform/soc/984000.i2c/i2c-0/0-0020/leds/aw210xx_led/all_white_leds_br");
           Toast.makeText(getApplicationContext(), "SU success", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(), "SU fail", Toast.LENGTH_LONG).show();
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        Button tosettingsbutton = (Button) findViewById(R.id.toSettingsButton);
        ImageButton logobutton = (ImageButton) findViewById(R.id.logobutton);
        ImageButton helpbutton = (ImageButton) findViewById(R.id.helpbutton);

        tosettingsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        logobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Logobutton works", Toast.LENGTH_LONG).show();
                alllightson();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                alllightsoff();
            }
        });

        helpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OnlineHelp.class);
                startActivity(intent);
            }
        });



        //initialisation of all the settings states, false as default
        boolean NFCSwitch, BTSwitch, LoginSwitch, USBSwitch, DTSwitch, WCSwitch, ShakeSwitch;

        NFCSwitch = false;
        BTSwitch = false;
        LoginSwitch = false;
        USBSwitch = false;
        DTSwitch = false;
        WCSwitch = false;
        ShakeSwitch = false;

        //gets the new value from the settings menu and updates the value
        NFCSwitch = getIntent().getBooleanExtra("NFCSwitch", false);
        BTSwitch = getIntent().getBooleanExtra("BTSwitch", false);
        LoginSwitch = getIntent().getBooleanExtra("LoginSwitch", false);
        USBSwitch = getIntent().getBooleanExtra("USBSwitch", false);
        DTSwitch = getIntent().getBooleanExtra("DTSwitch", false);
        WCSwitch = getIntent().getBooleanExtra("WCSwitch", false);
        ShakeSwitch = getIntent().getBooleanExtra("ShakeSwitch", false);

        /*
        //init. of NFC
        NfcAdapter nfcAdapter;
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        Tag myTag;


        final String TAG = "nfctest";
`

        if (myTag != null){
            Toast.makeText(getApplicationContext(), "NFC Tag Detected", Toast.LENGTH_LONG).show();
        }
        */







    }




    public void alllightson(){ //Function that turns on the glyph
/*
        try{ //this method goes via the shell
            //String[] cmd = {"/system/bin/sh", "-c", "echo 2000 > /sys/devices/platform/soc/984000.i2c/i2c-0/0-0020/leds/aw210xx_led/all_white_leds_br"};
            //Runtime.getRuntime().exec(cmd);
            //Runtime.getRuntime().exec("echo 2000 > /sys/devices/platform/soc/984000.i2c/i2c-0/0-0020/leds/aw210xx_led/all_white_leds_br");
           // ProcessBuilder processBuilder = new ProcessBuilder();
           // processBuilder.command("su", "echo 2000 > /sys/devices/platform/soc/984000.i2c/i2c-0/0-0020/leds/aw210xx_led/all_white_leds_br"); //try adding SU command first
           // processBuilder.start();
        }
        catch (IOException exception){
            exception.printStackTrace();
            Toast.makeText(getApplicationContext(), "processbuilder or runtime.getruntime failed", Toast.LENGTH_LONG).show();
        }*/

        try{
            FileWriter myWriter = new FileWriter("/sys/class/leds/aw210xx_led/all_white_leds_br");
            myWriter.write("2000");//new value goes here
            myWriter.close();
            Toast.makeText(getApplicationContext(), "Write successful", Toast.LENGTH_LONG).show(); //Creates notification that says write successful
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error occured when writing data", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        /*
        try{ //NB This is another method that goes via the shell
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os  = new DataOutputStream(p.getOutputStream());
            os.writeBytes("/sys/devices/platform/soc/984000.i2c/i2c-0/0-0020/leds/aw210xx_led/all_white_leds_br\n");
            os.writeBytes("exit\n");
            os.flush();
        }
        catch (Exception yep){
            yep.printStackTrace();
            System.out.print(yep);
            Toast.makeText(getApplicationContext(), "aaaaaaaa", Toast.LENGTH_LONG).show();
        }*/
    }

    public void alllightsoff(){ //turns all glyph off
        try{
            FileWriter myWriter = new FileWriter("/sys/devices/platform/soc/984000.i2c/i2c-0/0-0020/leds/aw210xx_led/all_white_leds_br");
            myWriter.write("0");//new value goes here
            myWriter.close();
            Toast.makeText(getApplicationContext(), "Write successful", Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error occured when writing data", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
