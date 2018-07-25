package popda.ns_testtask.core.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.Calendar;
import java.util.Random;

import popda.ns_testtask.R;
import popda.ns_testtask.core.model.NoteModel;
import popda.ns_testtask.ui.activity.main.MainActivity;

public class NotificationManager {
    private static final String NOTIFICATION_CHANEL = "TEST_CHANEL_01";

    public static void showRemindNotification(Context context, Calendar dateTime, String noteText) {

        NotificationCompat.Builder builder;

        builder = new NotificationCompat.Builder(context, NOTIFICATION_CHANEL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setCategory(Notification.CATEGORY_ALARM);
            builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        }

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder.setPriority(Notification.PRIORITY_MAX);
        }

        builder.setAutoCancel(true);

        builder.setContentTitle("NS_TestTask");
        builder.setContentText(noteText);

        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent startIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(),
                contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(startIntent);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    NOTIFICATION_CHANEL,
                    context.getString(R.string.app_name),
                    android.app.NotificationManager.IMPORTANCE_HIGH);
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationManagerCompat.from(context)
                .notify(new Random().nextInt(), builder.build());

    }
}
