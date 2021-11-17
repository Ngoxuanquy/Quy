package com.example.demobaothuc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.demobaothuc.R;

public class TrangCon extends AppCompatActivity {

    Switch tat;
    ImageButton caidat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_con);

        tat = findViewById(R.id.tat);
        caidat = findViewById(R.id.caidat);

       tat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               boolean check = ((Switch) view).isChecked();
               if(check){
                   Toast.makeText(TrangCon.this , " Tiếng" ,Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(TrangCon.this , " Tiếng" ,Toast.LENGTH_SHORT).show();

               }

           }
       });

    }



}