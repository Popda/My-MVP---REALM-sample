package popda.ns_testtask.core.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;

public class JobCreator implements com.evernote.android.job.JobCreator {
    @Nullable
    @Override
    public Job create(@NonNull String tag) {
        switch (tag) {
            case NotificationJob.TAG:
                return new NotificationJob();
            default:
                return null;
        }
    }
}
