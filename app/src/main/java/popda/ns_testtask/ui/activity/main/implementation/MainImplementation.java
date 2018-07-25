package popda.ns_testtask.ui.activity.main.implementation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import popda.ns_testtask.R;
import popda.ns_testtask.core.model.NoteModel;
import popda.ns_testtask.ui.activity.add_dialog.AddDialogActivity;
import popda.ns_testtask.ui.activity.base.implementation.BaseImplementation;
import popda.ns_testtask.ui.activity.main.presenter.MainPresenter;
import popda.ns_testtask.ui.activity.main.view.MainView;

public class MainImplementation extends BaseImplementation<MainView> implements MainPresenter {

    @Override
    public void openAddDialog(View sharedView) {
        Intent intent = new Intent(view.getContext(), AddDialogActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(((Activity) view.getContext()), sharedView, view.getContext().getString(R.string.add));
        view.getContext().startActivity(intent, options.toBundle());
    }

    @Override
    public void getAllReminders() {
        view.showListData(NoteModel.getAllNotes());
    }
}
