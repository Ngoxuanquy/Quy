package com.example.demobaothuc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.demobaothuc.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaoThuc extends AppCompatActivity {



    ListView list;
    int vitri;
    TextView day;
    Button sua, thu2 , thu3 ,thu4 ,thu5 ,thu6 , thu7 ,thu8 ,add , xoa ,button;
    ArrayList<String> listBaoThuc;
    EditText addtext,timeText;
    ArrayAdapter adapter;
    EditText textTime;
        String a;
        String b;
        AlarmManager alarmManager;
        PendingIntent pendingIntent;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_thuc);
            button = findViewById(R.id.button);
        thu2 = findViewById(R.id.thu2);
        thu3 = findViewById(R.id.thu3);
        thu4 = findViewById(R.id.thu4);
        thu5 = findViewById(R.id.thu5);
        thu6 = findViewById(R.id.thu6);
        thu7 = findViewById(R.id.thu7);
        thu8 = findViewById(R.id.thu8);
        day = findViewById(R.id.day);
        list = findViewById(R.id.list);
        add = findViewById(R.id.add);
        sua = findViewById(R.id.sua);
        addtext = findViewById(R.id.addText);
        timeText = findViewById(R.id.timeText);
        xoa = findViewById(R.id.xoa);
        textTime = findViewById(R.id.timeText);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(BaoThuc.this , Text.class);
        listBaoThuc = new ArrayList<String>();
//        listBaoThuc.add("7:00 Uống nước ");
//        listBaoThuc.add("12:00 Ngủ Trưa ");
//        listBaoThuc.add("18:00 Tập Thể Dục ");


//    thu2.setBackgroundColor(Color.BLACK);

        adapter = new ArrayAdapter(BaoThuc.this,
                android.R.layout.simple_expandable_list_item_1,
                listBaoThuc);


        list.setAdapter(adapter);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String time = timeText.getText().toString();

                        timeText.setText(listBaoThuc.get(i));
                        addtext.setText(listBaoThuc.get(i));

                    }
                });
            }
        });



        add.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                sukien();
                return false;
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i +1 ;
                return false;
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa();
                adapter.notifyDataSetChanged();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = timeText.getText().toString();
                String add = addtext.getText().toString();


                pendingIntent =PendingIntent.getBroadcast(BaoThuc.this , 0 , intent, PendingIntent.FLAG_IMMUTABLE);

                alarmManager.set(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , pendingIntent );

                 if(b != null && add != null){
                    listBaoThuc.add(b + " " + add);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(BaoThuc.this , "Đã thêm thành công" , Toast.LENGTH_SHORT).show();
                }
                 else if(b == null || add == null){

                         Toast.makeText(BaoThuc.this, "Bạn Nhập Lai Thoiwf Gian", Toast.LENGTH_SHORT).show();

                     }
            }
        });

        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Time();
            }
        });

        timeText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                sukien();
                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer song = MediaPlayer.create(BaoThuc.this, R.raw.a);
                for (int i = 1; i < 10; i++) {

                    song.start();

                }
            }

        });

    }
        private void Time(){
             calendar = new GregorianCalendar();
            int gio = calendar.get(Calendar.HOUR_OF_DAY);
            int phut = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    calendar.set(0,0,0 , i,i1);
                    timeText.setText(simpleDateFormat.format(calendar.getTime()));

                }
            },gio , phut, true);
            timePickerDialog.show();
            a = gio+":"+ phut;
            Toast.makeText(BaoThuc.this , a , Toast.LENGTH_SHORT).show();
        }
            private  void baothuc(){
                if(b == a){
                    Toast.makeText(BaoThuc.this , "den gio" , Toast.LENGTH_SHORT).show();
                }


            }
        private void sukien(){
            Calendar calendar = new GregorianCalendar();
            int gio = calendar.get(Calendar.HOUR_OF_DAY);
            int phut = calendar.get(Calendar.MINUTE);
            String time = timeText.getText().toString();
            if(time.equals(gio +":" + phut)){
                Toast.makeText(BaoThuc.this , "den gio" , Toast.LENGTH_SHORT).show();
            }

        }



    private void XacNhanXoa(){
        AlertDialog.Builder aler = new AlertDialog.Builder(this);
        aler.setTitle("Thông Báo");
        aler.setMessage("Bạn Có Chắc Chắn Xóa ");
        aler.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listBaoThuc.remove(vitri );
                adapter.notifyDataSetChanged();
                Toast.makeText(BaoThuc.this , "bạn đã xóa thành công" , Toast.LENGTH_SHORT).show();
            }
        });
        aler.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        aler.show();
    }

}