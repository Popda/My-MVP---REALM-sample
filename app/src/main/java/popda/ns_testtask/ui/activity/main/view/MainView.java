package popda.ns_testtask.ui.activity.main.view;

import io.realm.RealmResults;
import popda.ns_testtask.core.model.NoteModel;
import popda.ns_testtask.ui.activity.base.view.BaseView;

public interface MainView extends BaseView {
    void openAddDialog();
    void showListData(RealmResults<NoteModel> models);
}
