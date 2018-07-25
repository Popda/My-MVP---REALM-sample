package popda.ns_testtask.core.model;

import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import popda.ns_testtask.core.job.NotificationJob;

public class NoteModel extends RealmObject implements RealmModel {

    private Long time;
    private String text;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @NonNull
    public static RealmResults<NoteModel> getAllNotes() {
        return Realm.getDefaultInstance().where(NoteModel.class).findAll();
    }

    public void save() {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.copyToRealm(NoteModel.this);
            }
        });

        NotificationJob.scheduleReminder(time, text);
    }
}
