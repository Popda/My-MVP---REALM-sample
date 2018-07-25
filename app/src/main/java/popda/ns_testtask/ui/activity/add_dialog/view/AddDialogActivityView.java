package popda.ns_testtask.ui.activity.add_dialog.view;

import popda.ns_testtask.ui.activity.base.view.BaseView;

public interface AddDialogActivityView extends BaseView {
    void saveData();
    String getComment();
    void onDatePicked(String date);
    void onTimePicked(String time);
}
