package mobile.s.todogoals.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

import mobile.s.todogoals.services.TodayToDoReceiver;

public class AlarmUtil {

    private AlarmManager manager;
    private Context context;

    public AlarmUtil(Context context) {
        this.context = context;
        manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    public void setEarningAlarm(int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, value);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, getRecieverPendingIntent());
    }

    private PendingIntent getRecieverPendingIntent() {
        Intent intent = new Intent(context, TodayToDoReceiver.class);
        return PendingIntent.getBroadcast(context, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT);

    }
}
