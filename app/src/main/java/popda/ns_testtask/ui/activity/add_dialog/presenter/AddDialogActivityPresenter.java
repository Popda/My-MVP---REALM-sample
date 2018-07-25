package popda.ns_testtask.ui.activity.add_dialog.presenter;

import popda.ns_testtask.ui.activity.add_dialog.view.AddDialogActivityView;
import popda.ns_testtask.ui.activity.base.presenter.BasePresenter;

public interface AddDialogActivityPresenter extends BasePresenter<AddDialogActivityView> {
    void saveData();
    void pickDate();
    void pickTime();
}
