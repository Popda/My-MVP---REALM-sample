package popda.ns_testtask;

import android.app.Application;

import com.evernote.android.job.JobManager;

import net.danlew.android.joda.JodaTimeAndroid;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import popda.ns_testtask.core.job.JobCreator;

public class TaskApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("test.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        JobManager.create(this).addJobCreator(new JobCreator());

        JodaTimeAndroid.init(this);
    }
}
