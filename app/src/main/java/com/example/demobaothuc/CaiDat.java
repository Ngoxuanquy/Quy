package com.example.demobaothuc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.demobaothuc.R;

public class CaiDat extends AppCompatActivity {

    Switch toi;
    ConstraintLayout manhinh;
    TextView setting , dark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat);

        toi = findViewById(R.id.toi);
        manhinh = findViewById(R.id.manhinh);
        setting = findViewById(R.id.setting);
        dark = findViewById(R.id.dark);


        toi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = ((Switch) view).isChecked();
                if(check){
                    manhinh.setBackgroundColor(Color.BLACK);
                    setting.setTextColor(Color.WHITE);
                    dark.setTextColor(Color.WHITE);
                }
                else {
                    manhinh.setBackgroundColor(Color.WHITE);
                    setting.setTextColor(Color.BLACK);
                    dark.setTextColor(Color.BLACK);
                }
            }
        });

    }
}