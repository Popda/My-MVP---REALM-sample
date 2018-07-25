package popda.ns_testtask.ui.activity.main.presenter;

import android.view.View;

import popda.ns_testtask.ui.activity.base.presenter.BasePresenter;
import popda.ns_testtask.ui.activity.main.view.MainView;

public interface MainPresenter extends BasePresenter<MainView> {
    void openAddDialog(View view);
    void getAllReminders();
}
