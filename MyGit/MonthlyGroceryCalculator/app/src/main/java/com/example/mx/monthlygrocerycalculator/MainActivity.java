package com.example.mx.monthlygrocerycalculator;

import android.app.AlarmManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ImageView imageview;
    ImageView read_imageview;ImageView deleteimageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onclicklisten();
        Calendar c = Calendar.getInstance();
        Date time=c.getTime();
        Toast.makeText(this,"wanted to check",Toast.LENGTH_SHORT).show();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        if(formattedDate.contains("2018")){
           // notification();
        }
    }
    public void onclicklisten(){
        imageview = findViewById(R.id.edit_view);
        read_imageview = findViewById(R.id.read_view);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
            }
        });
        read_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read_file();
            }
        });

    }
    public void clicked(){
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void read_file(){
        Intent intent=new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public void notification() {
     /*   Intent intent=new Intent();
        PendingIntent pIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
        Notification noti=new Notification.Builder(MainActivity.this)
            .setTicker("TickerTitle")
            .setContentTitle("Content Title")
            .setContentText("Content Text I am eden")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .addAction(R.drawable.ic_launcher_background,"Action 1",pIntent)
            .addAction(R.drawable.ic_launcher_background,"Action 1",pIntent)
            .setContentIntent(pIntent).getNotification();
    noti.flags=Notification.FLAG_AUTO_CANCEL;
    NotificationManager no=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    no.notify(0,noti);*/
    }
}
