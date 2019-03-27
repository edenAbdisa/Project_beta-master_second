package com.example.mx.monthlygrocerycalculator;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
public class Main2Activity extends AppCompatActivity {
    private EditText onionKiloEditText;     private EditText potatoKiloEditText;   private EditText tomatoKiloEditText;   private EditText bananaKiloEditText;
    private EditText orangeKiloEditText;    private EditText papayaKiloEditText;   private EditText bodysoapKiloEditText; private EditText tissuepaperKiloEditText;
    private EditText clothsoapKiloEditText; private EditText electricKiloEditText; private EditText internetKiloEditText; private EditText waterKiloEditText;
    private EditText onionPriceEditText;    private EditText potatoPriceEditText;  private EditText tomatoPriceEditText;  private EditText bananaPriceEditText;
    private EditText orangePriceEditText;   private EditText papayaPriceEditText;  private EditText bodysoapPriceEditText;private EditText tissuepaperPriceEditText;
    private EditText clothsoapPriceEditText;private EditText electricPriceEditText;private EditText internetPriceEditText;private EditText waterPriceEditText;
    private EditText oliveKiloEditText;     private EditText butterKiloEditText;   private EditText cookingOilKiloEditText;private EditText olivePriceEditText;
    private EditText butterPriceEditText;   private EditText cookingOilPriceEditText;
    Button sumButton;
    double sum=0;                          boolean bool=false;
    LinearLayout lin;                       ImageView imageViewaddutility;         ImageView imageView;                   EditText newpriceedittext;
    ImageView imageViewaddfruit;            ImageView imageViewadddetrigent;       ImageView imageViewaddvegitable;       EditText onionpricetext;
    ImageView imageViewaddoil;              EditText newtextview;                  EditText newkiloedittext;              EditText onionkilotext;
    LinearLayout newlinearlayout;           LinearLayout onionlinearlayout;        TextView oniontext;
    ArrayList<String> kilo_integer;         ArrayList<String> price_integer;       ArrayList<Integer> id_generator;       ImageView saveimage;
    ArrayList<String> textview_text;        boolean result_created=false;          LinearLayout sumLayout,vegetableLayout,insideutility;
    TextView sumView,resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        id_generator=new ArrayList<>();
        sumButton=findViewById(R.id.sum_button);
        sumButton.setOnClickListener(new calculateclass());
        onionlinearlayout = findViewById(R.id.onion_linearlayout);
        onionkilotext = findViewById(R.id.onion_kilo_edittext);
        onionpricetext = findViewById(R.id.onion_price_edittext);
        oniontext = findViewById(R.id.onion_textview);
        imageViewaddvegitable = findViewById(R.id.imageViewvegitable2);
        imageViewaddfruit = findViewById(R.id.imageViewfruit2);
        imageViewadddetrigent = findViewById(R.id.imageViewdetrigent2);
        imageViewaddutility = findViewById(R.id.imageViewutility2);
        imageViewaddoil = findViewById(R.id.imageViewoil2);
        imageViewaddvegitable.setOnClickListener(new  additems ());
        imageViewaddfruit.setOnClickListener(new  additems ());
        imageViewadddetrigent.setOnClickListener(new  additems ());
        imageViewaddutility.setOnClickListener(new  additems ());
        imageViewaddoil.setOnClickListener(new  additems ());
        saveimage = findViewById(R.id.save);
        saveimage.setOnClickListener(new setsaveonclick());
        insideutility=findViewById(R.id.result_linearlayout);
        sumLayout=new LinearLayout(this);
        sumView=new TextView(this);
    }
    private class setsaveonclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            calculate(v);}    }
    public void writes(String st){
        String s=st;
        try {
            FileOutputStream out = openFileOutput("asbeza.txt", MODE_PRIVATE);
            out.write(s.getBytes());
            out.close();
            Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();        }
        catch(Exception e){
            Toast.makeText(this,"couldnt save file",Toast.LENGTH_SHORT).show();}
    }
    public StringBuffer read(){
        try {
            FileInputStream in = openFileInput("asbeza.txt");
            InputStreamReader instr=new InputStreamReader(in);
            BufferedReader br=new BufferedReader(instr);
            StringBuffer strbuff=new StringBuffer();
            String lines;
            while((lines=br.readLine())!=null){
                strbuff.append(lines+"\n");
            }
            return(strbuff);
        }catch(Exception e){}
        return new StringBuffer();
    }
    private class additems implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            additem(v);}
    }
    public void additem(View v){
        LinearLayout l=(LinearLayout)v.getParent().getParent();
        int i=l.getId();
        lin = findViewById(i);
        newlinearlayout=new LinearLayout(this);
        newtextview=new EditText(this);
        newkiloedittext=new EditText(this);
        newpriceedittext=new EditText(this);

        newlinearlayout.setOrientation(0);
        newlinearlayout.setMinimumWidth(onionlinearlayout.getWidth());
        newlinearlayout.setMinimumHeight(onionlinearlayout.getHeight());

        newtextview.setHint("Enter the name");
        newtextview.setInputType(InputType.TYPE_CLASS_TEXT);
        newtextview.setHeight(oniontext.getHeight());
        newtextview.setWidth(oniontext.getWidth());
        newtextview.setId(newtextview.hashCode());
        var_generator(newtextview.getId());

        newkiloedittext.setInputType(onionkilotext.getInputType());
        newkiloedittext.setWidth(onionkilotext.getWidth());
        newkiloedittext.setHeight(onionkilotext.getHeight());
        newkiloedittext.setId(newkiloedittext.hashCode());
        var_generator(newkiloedittext.getId());

        newpriceedittext.setInputType(onionpricetext.getInputType());
        newpriceedittext.setWidth(onionpricetext.getWidth());
        newpriceedittext.setHeight(onionpricetext.getHeight());
        newpriceedittext.setId(newpriceedittext.hashCode());
        var_generator(newpriceedittext.getId());

        newlinearlayout.addView(newtextview);
        newlinearlayout.addView(newkiloedittext);
        newlinearlayout.addView( newpriceedittext);
        lin.addView( newlinearlayout);
        bool=true;
    }
    public void var_generator(int v){
        id_generator.add(v);
    }
    private class calculateclass implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            calculate(v); }
    }
    public void pushkilo(String str,String doub){
        kilo_integer.add( doub);
    }
    public void pushprice(String str,String d){
        price_integer.add( d);
    }
    public void pushtextview(String t){
        textview_text.add(t);
    }
    public void calculate(View v) {
        TextView onionTextView=findViewById(R.id.onion_textview);         TextView potatoTextView=findViewById(R.id.potato_textview);        TextView tomatoTextView=findViewById(R.id.tomato_textview);        TextView bananaTextView=findViewById(R.id.banana_textview);
        TextView orangeTextView=findViewById(R.id.orange_textview);       TextView papayaTextView=findViewById(R.id.papaya_textview);        TextView bodysoapTextView=findViewById(R.id.bodysoap_textview);    TextView tissuepaperTextView=findViewById(R.id.tissuepaper_textview);
        TextView clothsoapTextView=findViewById(R.id.clothsoap_textview); TextView electricTextView=findViewById(R.id.electric_textview);    TextView internetTextView=findViewById(R.id.internet_textview);    TextView waterTextView=findViewById(R.id.water_textview);
        TextView oliveTextView=findViewById(R.id.olive_textview); TextView butterTextView=findViewById(R.id.butter_textview);    TextView cookingOilTextView=findViewById(R.id.cookingoil_textview);

        kilo_integer=new ArrayList<>();           textview_text=new ArrayList<>();             price_integer=new ArrayList<>();
        String onionKilo="";    String potatoKilo="";     String tomatoKilo="";      String bananaKilo="";    String orangeKilo="";
        String bodysoapKilo=""; String tissuepaperKilo="";String clothsoapKilo="";   String electricKilo="";  String internetKilo="";
        String oliveKilo="";  String butterKilo="";        String cookingOilKilo="";
        String waterKilo="";    String onionPrice="";     String potatoPrice="";     String tomatoPrice="";   String bananaPrice="";
        String papayaPrice="";  String bodysoapPrice="";  String tissuepaperPrice="";String clothsoapPrice="";String electricPrice="";
        String internetPrice="";String waterPrice="";     String papayaKilo="";      String orangePrice="";
        String olivePrice="";     String butterPrice="";     String cookingOilPrice="";

        sum=0;
        pushtextview(onionTextView.getText().toString());pushtextview(potatoTextView.getText().toString());
        pushtextview(tomatoTextView.getText().toString());pushtextview(bananaTextView.getText().toString());
        pushtextview(orangeTextView.getText().toString());pushtextview(papayaTextView.getText().toString());
        pushtextview(bodysoapTextView.getText().toString());pushtextview(tissuepaperTextView.getText().toString());
        pushtextview(clothsoapTextView.getText().toString()); pushtextview(oliveTextView.getText().toString());
        pushtextview(butterTextView.getText().toString());pushtextview(cookingOilTextView.getText().toString());
        pushtextview(waterTextView.getText().toString());pushtextview(electricTextView.getText().toString());
        pushtextview(internetTextView.getText().toString());
        onionKiloEditText = findViewById(R.id.onion_kilo_edittext);
        onionKilo = onionKiloEditText.getText().toString();
        pushkilo(onionKiloEditText.toString(),onionKilo);
        potatoKiloEditText = findViewById(R.id.potato_kilo_edittext);
        potatoKilo = potatoKiloEditText.getText().toString();
        pushkilo(potatoKiloEditText.toString(),potatoKilo);
        tomatoKiloEditText = findViewById(R.id.tomato_kilo_edittext);
        tomatoKilo = tomatoKiloEditText.getText().toString();
        pushkilo(tomatoKiloEditText.toString(),tomatoKilo);
        bananaKiloEditText = findViewById(R.id.banana_kilo_edittext);
        bananaKilo = bananaKiloEditText.getText().toString();
        pushkilo(bananaKiloEditText.toString(),bananaKilo);
        orangeKiloEditText = findViewById(R.id.orange_kilo_edittext);
        orangeKilo = orangeKiloEditText.getText().toString();
        pushkilo(orangeKiloEditText.toString(),orangeKilo);
        papayaKiloEditText = findViewById(R.id.papaya_kilo_edittext);
        papayaKilo = papayaKiloEditText.getText().toString();
        pushkilo(papayaKiloEditText.toString(),papayaKilo);
        bodysoapKiloEditText = findViewById(R.id.bodysoap_kilo_edittext);
        bodysoapKilo = bodysoapKiloEditText.getText().toString();
        pushkilo(bodysoapKiloEditText.toString(),bodysoapKilo);
        tissuepaperKiloEditText = findViewById(R.id.tissuepaper_kilo_edittext);
        tissuepaperKilo = tissuepaperKiloEditText.getText().toString();
        pushkilo(tissuepaperKiloEditText.toString(),tissuepaperKilo);
        clothsoapKiloEditText = findViewById(R.id.clothsoap_kilo_edittext);
        clothsoapKilo = clothsoapKiloEditText.getText().toString();
        pushkilo(clothsoapKiloEditText.toString(),clothsoapKilo);
        oliveKiloEditText = findViewById(R.id.olive_kilo_edittext);
        oliveKilo = oliveKiloEditText.getText().toString();
        pushkilo(oliveKiloEditText.toString(),oliveKilo);
        butterKiloEditText = findViewById(R.id.butter_kilo_edittext);
        butterKilo =butterKiloEditText.getText().toString();
        pushkilo(butterKiloEditText.toString(),butterKilo);
        cookingOilKiloEditText = findViewById(R.id.cookingoil_kilo_edittext);
        cookingOilKilo = cookingOilKiloEditText.getText().toString();
        pushkilo(cookingOilKiloEditText.toString(),cookingOilKilo);
        waterKiloEditText = findViewById(R.id.water_kilo_edittext);
        waterKilo = waterKiloEditText.getText().toString();
        pushkilo(waterKiloEditText.toString(),waterKilo);
        electricKiloEditText = findViewById(R.id.electric_kilo_edittext);
        electricKilo = electricKiloEditText.getText().toString();
        pushkilo(electricKiloEditText.toString(),electricKilo);
        internetKiloEditText = findViewById(R.id.internet_kilo_edittext);
        internetKilo = internetKiloEditText.getText().toString();
        pushkilo(internetKiloEditText.toString(),internetKilo);
        onionPriceEditText = findViewById(R.id.onion_price_edittext);
        onionPrice = onionPriceEditText.getText().toString();
        pushprice(onionPriceEditText.toString(),onionPrice);
        potatoPriceEditText = findViewById(R.id.potato_price_edittext);
        potatoPrice = potatoPriceEditText.getText().toString();
        pushprice(potatoPriceEditText.toString(),potatoPrice);
        tomatoPriceEditText = findViewById(R.id.tomato_price_edittext);
        tomatoPrice = tomatoPriceEditText.getText().toString();
        pushprice(tomatoPriceEditText.toString(),tomatoPrice);
        bananaPriceEditText = findViewById(R.id.banana_price_edittext);
        bananaPrice = bananaPriceEditText.getText().toString();
        pushprice(bananaPriceEditText.toString(),bananaPrice);
        orangePriceEditText = findViewById(R.id.orange_price_edittext);
        orangePrice = orangePriceEditText.getText().toString();
        pushprice(orangePriceEditText.toString(),orangePrice);
        papayaPriceEditText = findViewById(R.id.papaya_price_edittext);
        papayaPrice = papayaPriceEditText.getText().toString();
        pushprice(papayaPriceEditText.toString(),papayaPrice);
        bodysoapPriceEditText = findViewById(R.id.bodysoap_price_edittext);
        bodysoapPrice = bodysoapPriceEditText.getText().toString();
        pushprice(bodysoapPriceEditText.toString(),bodysoapPrice);
        tissuepaperPriceEditText = findViewById(R.id.tissuepaper_price_edittext);
        tissuepaperPrice = tissuepaperPriceEditText.getText().toString();
        pushprice(tissuepaperPriceEditText.toString(),tissuepaperPrice);
        clothsoapPriceEditText = findViewById(R.id.clothsoap_price_edittext);
        clothsoapPrice = clothsoapPriceEditText.getText().toString();
        pushprice(clothsoapPriceEditText.toString(),clothsoapPrice);
        olivePriceEditText = findViewById(R.id.olive_price_edittext);
        olivePrice = olivePriceEditText.getText().toString();
        pushprice(olivePriceEditText.toString(),olivePrice);
        butterPriceEditText = findViewById(R.id.butter_price_edittext);
        butterPrice = butterPriceEditText.getText().toString();
        pushprice(butterPriceEditText.toString(),butterPrice);
        cookingOilPriceEditText = findViewById(R.id.cookingoil_price_edittext);
        cookingOilPrice = cookingOilPriceEditText.getText().toString();
        pushprice(cookingOilPriceEditText.toString(),cookingOilPrice);
        waterPriceEditText = findViewById(R.id.water_price_edittext);
        waterPrice = waterPriceEditText.getText().toString();
        pushprice(waterPriceEditText.toString(),waterPrice);
        electricPriceEditText = findViewById(R.id.electric_price_edittext);
        electricPrice = electricPriceEditText.getText().toString();
        pushprice(electricPriceEditText.toString(),electricPrice);
        internetPriceEditText = findViewById(R.id.internet_price_edittext);
        internetPrice = internetPriceEditText.getText().toString();
        pushprice(internetPriceEditText.toString(),internetPrice);
        if(bool){
           String l="",c="";
            int d;
            for (int i=0;i<id_generator.size();i++){
                d=id_generator.get(i);
                if(i%3==0){
                    pushtextview(((EditText)findViewById(d)).getText().toString());
                }
                else if (i%3==1){
                    l= ((EditText) findViewById(d)).getText().toString();
                    pushkilo(((EditText) findViewById(d)).toString(),l);
                }
                else if(i%3==2){
                    c=((EditText)findViewById(d)).getText().toString();
                    pushprice(((EditText)findViewById(d)).toString(),c);
                }
            }
        }
        double price_dou=0,kilo_dou=0,result;
        String save_string=read().toString();String s;
        if(v.getId()==saveimage.getId()){
            try{
                Calendar c = Calendar.getInstance();
                Date time=c.getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(c.getTime());
                save_string=save_string+"\n"+"The date when this calculation was saved is : "+formattedDate;}
            catch(Exception e){
                Toast.makeText(this,"Exception because you called write",Toast.LENGTH_SHORT).show();
            }
        }String  kilo_dou_st="", price_dou_st="";
        for (int n=0;n< kilo_integer.size();n++){
                kilo_dou_st=kilo_integer.get(n);
                price_dou_st=price_integer.get(n);
                if(String.valueOf(kilo_dou_st).equalsIgnoreCase("")||String.valueOf(price_dou_st).equalsIgnoreCase("")){
                    kilo_dou=0;
                    price_dou=0;
                }
                else if(!String.valueOf(kilo_dou_st).equalsIgnoreCase("") &&!String.valueOf(price_dou_st).equalsIgnoreCase("")){
                    try{
                    kilo_dou=Double.parseDouble(kilo_dou_st);
                    price_dou=Double.parseDouble(price_dou_st);}
                    catch(Exception e){
                        Toast.makeText(this,"Number format error",Toast.LENGTH_SHORT).show();}
                }
                s=textview_text.get(n);
                result=price_dou*kilo_dou;
                try{
                    save_string=save_string+"\n"+s+"\n"+"Price per Kilo:  "+String.valueOf(price_dou)+"\n"+"Kilo:  "+String.valueOf(kilo_dou)+"\n"+"Result:  "+String.valueOf(result)+"\n";
                }
                catch(Exception e){
                    Toast.makeText(this,"Exception because of error",Toast.LENGTH_SHORT).show();
                }
                sum+=result;
        }
        String st= String.valueOf( sum);
        if(v.getId()==sumButton.getId()){
            setresult(st);
            Toast.makeText(this,st,Toast.LENGTH_SHORT).show();
        }else{
            try{
                writes(save_string+"\n"+"The total sum is "+st);
                Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();}
            catch(Exception e){
                Toast.makeText(this,"Exception because you called write",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void setresult(String result){
        resultView=findViewById(R.id.result_textview);
        resultView.setText("The result is "+ result);
    }

}
