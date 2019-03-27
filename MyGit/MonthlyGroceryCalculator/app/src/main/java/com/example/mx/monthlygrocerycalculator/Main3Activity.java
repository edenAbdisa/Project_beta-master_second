package com.example.mx.monthlygrocerycalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
public class Main3Activity extends AppCompatActivity {
    TextView ed;
    ScrollView scroll;
    EditText ed_text;TextView ed_text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed = findViewById(R.id.fileview);
        scroll=findViewById(R.id.scroll_fileview);
        read();
    }
    public String read() {
        String st="";
        try {
            FileInputStream in = openFileInput("asbeza.txt");
            InputStreamReader instr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(instr);
            StringBuffer strbuff = new StringBuffer();
            String lines;
            while ((lines = br.readLine()) != null) {
                ed.append(lines + "\n");
                st=st+ "\n"+lines;
            }
            return st;
        } catch (Exception e) {
            Toast.makeText(this, "oops error", Toast.LENGTH_SHORT).show();
        }
        return "Error in read line";
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.read_file, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_delete:
                delete();
                return true;
            case R.id.search_action:
                edit();
                return true;
            case R.id.save_action:
                save();
                return true;
        }
        return true;
    }
    public void delete() {
        TextView file_tx=findViewById(R.id.fileview);
        String s="";
        try {
            FileOutputStream out = openFileOutput("asbeza.txt", MODE_PRIVATE);
            out.write(s.getBytes());
            out.close();
            file_tx.setText("");
            Toast.makeText(this,"deleted",Toast.LENGTH_SHORT).show();        }
        catch(Exception e){
            Toast.makeText(this,"couldnt save file",Toast.LENGTH_SHORT).show();
        }
    }

public void edit(){
       ed_text=new EditText(this);
       ed_text.setTextSize( ed.getTextSize());
       ed.setText("");
       scroll.removeAllViews();
       ed_text.setText(read());
       scroll.addView(ed_text);
}
public void save(){
    try{
    writes(ed_text.getText().toString());
    ed_text_view=new TextView(this);
    ed_text_view.setTextSize(ed.getTextSize());
    ed_text.setText("");
    scroll.removeAllViews();
    ed_text_view.setText(read());
    scroll.addView(ed_text_view);}
    catch(Exception ec){
        Toast.makeText(this,"Nothing new to save ,please edit before saving file.",Toast.LENGTH_SHORT).show();
    }
}
public void writes(String st){
        String s=st;
        try {
            FileOutputStream out = openFileOutput("asbeza.txt", MODE_PRIVATE);
            out.write(s.getBytes());
            out.close();
            Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();        }
        catch(Exception e){
            Toast.makeText(this,"couldnt save file",Toast.LENGTH_SHORT).show();}
    }
}