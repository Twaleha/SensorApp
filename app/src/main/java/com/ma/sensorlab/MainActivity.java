package com.ma.sensorlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager mgr;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgr= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        textView= (TextView) findViewById(R.id.textView);
        List<Sensor> sensorList=mgr.getSensorList(Sensor.TYPE_ALL);
        StringBuilder stringBuilder= new StringBuilder();
        for(Sensor s: sensorList){
            stringBuilder.append(s.getName()+ "\n");

        }
        textView.setVisibility(View.VISIBLE);
        textView.setText(stringBuilder);
    }

}