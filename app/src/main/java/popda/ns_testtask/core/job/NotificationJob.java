package popda.ns_testtask.core.job;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;

import java.util.Calendar;

import popda.ns_testtask.core.model.NoteModel;
import popda.ns_testtask.core.notification.NotificationManager;

public class NotificationJob extends Job {

    public static final String TAG = "NOTIFICATION_JOB";
    private static final String TIME = "time";
    private static final String TEXT = "text";

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(params.getExtras().getLong(TIME, 0));

        Object a = params.getExtras().get(TEXT);
        String text = a.toString();


        PowerManager.WakeLock wakeLock = null;

        PowerManager powerManager = (PowerManager) getContext().getSystemService(Context.POWER_SERVICE);

        if (powerManager != null) {
            wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK
                    | PowerManager.ACQUIRE_CAUSES_WAKEUP
                    | PowerManager.ON_AFTER_RELEASE, TAG);
        }

        if (wakeLock != null)
            wakeLock.acquire(500);

        NotificationManager.showRemindNotification(getContext(), time, text);

        if (wakeLock != null)
            wakeLock.release();

        return Result.SUCCESS;
    }

    public static void scheduleReminder(Long timestamp, String text) {
        PersistableBundleCompat extras = new PersistableBundleCompat();
        extras.putLong(TIME, timestamp);
        extras.putString(TEXT, text);

        new JobRequest.Builder(TAG)
                .setExact(timestamp - System.currentTimeMillis())
                .setExtras(extras)
                .setUpdateCurrent(false)
                .build()
                .schedule();
    }
}
