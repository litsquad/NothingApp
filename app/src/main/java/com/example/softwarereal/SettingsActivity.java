package com.example.softwarereal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    SwitchCompat NFCSwitch, BTSwitch, LoginSwitch, USBSwitch, DTSwitch, WCSwitch, ShakeSwitch;
    boolean stateNFCSwitch, stateBTSwitch, stateLoginSwitch, stateUSBSwitch, stateDTSwitch, stateWCSwitch, stateShakeSwitch;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        preferences = getSharedPreferences("PREFS", 0);
        stateNFCSwitch = preferences.getBoolean("NFCSwitch", false);
        stateBTSwitch = preferences.getBoolean("BTSwitch", false);
        stateLoginSwitch = preferences.getBoolean("LoginSwitch", false);
        stateUSBSwitch = preferences.getBoolean("USBSwitch", false);
        stateDTSwitch = preferences.getBoolean("DTSwitch", false);
        stateWCSwitch = preferences.getBoolean("WCSwitch", false);
        stateShakeSwitch = preferences.getBoolean("ShakeSwitch", false);

        NFCSwitch = (SwitchCompat) findViewById(R.id.NFCSwitch);
        BTSwitch = (SwitchCompat) findViewById(R.id.BTSwitch);
        LoginSwitch = (SwitchCompat) findViewById(R.id.LoginSwitch);
        USBSwitch = (SwitchCompat) findViewById(R.id.USBSwitch);
        DTSwitch = (SwitchCompat) findViewById(R.id.DTSwitch);
        WCSwitch = (SwitchCompat) findViewById(R.id.WCSwitch);
        ShakeSwitch = (SwitchCompat) findViewById(R.id.ShakeSwitch);

        NFCSwitch.setChecked(stateNFCSwitch);
        BTSwitch.setChecked(stateBTSwitch);
        LoginSwitch.setChecked(stateLoginSwitch);
        USBSwitch.setChecked(stateUSBSwitch);
        DTSwitch.setChecked(stateDTSwitch);
        WCSwitch.setChecked(stateWCSwitch);
        ShakeSwitch.setChecked(stateShakeSwitch);

        NFCSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateNFCSwitch = !stateNFCSwitch;
                NFCSwitch.setChecked(stateNFCSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("NFCSwitch", stateNFCSwitch);
                editor.apply();
/*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("NFCSwitch", stateNFCSwitch);
                startActivity(intent); */
            }
        });

        BTSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateBTSwitch = !stateBTSwitch;
                BTSwitch.setChecked(stateBTSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("BTSwitch", stateBTSwitch);
                editor.apply();
/*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("BTSwitch", stateBTSwitch);
                startActivity(intent);*/
            }
        });

        LoginSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateLoginSwitch = !stateLoginSwitch;
                LoginSwitch.setChecked(stateLoginSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("LoginSwitch", stateLoginSwitch);
                editor.apply();
/*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("BTSwitch", stateBTSwitch);
                startActivity(intent);*/
            }
        });

        USBSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateUSBSwitch = !stateUSBSwitch;
                USBSwitch.setChecked(stateUSBSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("USBSwitch", stateUSBSwitch);
                editor.apply();
/*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("USBSwitch", stateUSBSwitch);
                startActivity(intent);*/
            }
        });

        DTSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateDTSwitch = !stateDTSwitch;
                DTSwitch.setChecked(stateDTSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("DTSwitch", stateDTSwitch);
                editor.apply();
/*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("DTSwitch", stateDTSwitch);
                startActivity(intent); */
            }
        });

        WCSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateWCSwitch = !stateWCSwitch;
                WCSwitch.setChecked(stateWCSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("WCSwitch", stateWCSwitch);
                editor.apply();
/*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("WCSwitch", stateWCSwitch);
                startActivity(intent);*/
            }
        });

        ShakeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateShakeSwitch = !stateShakeSwitch;
                ShakeSwitch.setChecked(stateShakeSwitch);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("ShakeSwitch", stateShakeSwitch);
                editor.apply();

                /*
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("ShakeSwitch", stateShakeSwitch);
                startActivity(intent); */
            }
        });
    }
}