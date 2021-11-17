package com.example.demobaothuc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;


import com.example.demobaothuc.R;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrangChu extends AppCompatActivity {

    ListView listApp;
    Button addApp;
    ArrayList<String> arrayList;
    EditText hoatdong, thoigian;
    Button xoa1, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        listApp = findViewById(R.id.listApp);
        addApp = findViewById(R.id.addApp);

        thoigian = findViewById(R.id.thoigian);
        next = findViewById(R.id.next);
        arrayList = new ArrayList<String>();
        HwAds.init(this);

        BannerView bannerView = findViewById(R.id.hw_banner_view);
        bannerView.setAdId("testw6vs28auh3");
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        AdParam adParam = new AdParam.Builder().build();
        bannerView.loadAd(adParam);


        ArrayAdapter adapter = new ArrayAdapter(TrangChu.this,
                android.R.layout.simple_expandable_list_item_1,
                arrayList
        );

        listApp.setAdapter(adapter);


        addApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thoiGian = thoigian.getText().toString();
                arrayList.add("Day " + thoiGian + "                                                -->");
                adapter.notifyDataSetChanged();
            }
        });

        listApp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Chuyen(view);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chuyen(view);
            }
        });

        thoigian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhapNgay();
            }
        });

    }

    DatePickerDialog ngay1;
    private void NhapNgay(){
        Calendar calendar = new GregorianCalendar();
        int ngay =  calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
         ngay1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i , i1 , i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                thoigian.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);



        ngay1.show();
    }

    void Chuyen(View view){
        Intent intent = new Intent(this , BaoThuc.class);
        Bundle bundle = new Bundle();

        intent.putExtras(bundle);
        startActivity(intent);
    }
}