package com.example.demobaothuc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class Text extends BroadcastReceiver {
    MediaPlayer song;
    @Override
    public void onReceive(Context context, Intent intent) {
    Log.e("Báo Thức ", "Dậy làm nào");

    Intent intent1 = new Intent(context , Nhac.class);
    context.startService(intent1);

    }
}
