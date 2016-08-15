package com.wen.rfsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

    }

    public void click_add(View v)
    {
         EditText nameed = (EditText) findViewById(R.id.nameEDText);
         EditText adultEDText = (EditText) findViewById(R.id.adultEDText);
         EditText childEDText = (EditText) findViewById(R.id.childEDText);
         EditText tel = (EditText) findViewById(R.id.telEDText);
         EditText PS = (EditText) findViewById(R.id.PSEDText);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dt = null;
        try {
            dt = sdf.parse("2016/08/22 12:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("ERR","日期轉換錯誤~");
        }

        SFsysDAO dao = new SFsysDAOImp(add.this);
        customer a=new customer(1,   //性別
                                0,   //黑名單
                                "",  //黑名單理由
                                0,   //VIP
                                nameed.getText().toString(), //姓名
                                dt,   //生日
                                "",   //地址
                                tel.getText().toString(),//電話
                                PS.getText().toString()   //備註
        );
        Log.d("customer",a.toString());
        long cusid=dao.cusadd(a);
        Log.d("cusid", String.valueOf(cusid));


        reserve b = new reserve(
                                cusid,  //顧客編號
                                parseInt( adultEDText.getText().toString()),     //幾大
                                parseInt( childEDText.getText().toString()),//幾小  parseInt( childEDText.getText().toString()) ,
                                false,// 已離開
                                false,// 已進入
                                dt, //訂位時間
                                PS.getText().toString(), //備註
                                "LO"  //訂位輸入人員
        );

        Log.d("reserve",b.toString());
        long resid =dao.resadd(b);
        Log.d("resid", String.valueOf(resid));

    }

    public String getDateTime(){
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = new Date();
        String strDate = sdFormat.format(date);
        //System.out.println(strDate);
        return strDate;
    }


}

