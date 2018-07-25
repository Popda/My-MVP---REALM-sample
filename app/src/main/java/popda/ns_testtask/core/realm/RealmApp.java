package popda.ns_testtask.core.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("realm-note.db")
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
