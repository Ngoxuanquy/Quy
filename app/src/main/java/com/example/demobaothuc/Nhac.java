package com.example.demobaothuc;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.demobaothuc.R;

import java.security.Security;

public class Nhac extends Service {
    MediaPlayer song;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        song = MediaPlayer.create(this , R.raw.a);
        song.start();
        Log.e("Nhạc Lên", "Đố Bạn NGủ ấy" );
        return START_NOT_STICKY;

    }


}
