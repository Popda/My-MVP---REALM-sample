package popda.ns_testtask.ui.activity.add_dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.OnClick;
import popda.ns_testtask.R;
import popda.ns_testtask.ui.activity.add_dialog.implementation.AddDialogActivityImplementation;
import popda.ns_testtask.ui.activity.add_dialog.presenter.AddDialogActivityPresenter;
import popda.ns_testtask.ui.activity.add_dialog.view.AddDialogActivityView;
import popda.ns_testtask.ui.activity.base.BaseActivity;

public class AddDialogActivity extends BaseActivity implements AddDialogActivityView {

    @BindView(R.id.note_edittext)
    protected AppCompatEditText noteEdittext;
    @BindView(R.id.date_view)
    protected AppCompatEditText dateView;
    @BindView(R.id.time_view)
    protected AppCompatEditText timeView;
    private WeakReference<AddDialogActivity> weakReference;

    private AddDialogActivityPresenter presenter = new AddDialogActivityImplementation();

    @Override
    protected int getContentView() {
        return R.layout.add_dialog_fragment_layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(true);
        presenter.attachView(this);
    }

    @Override
    @OnClick(R.id.add_button)
    public void saveData() {
        presenter.saveData();
        Toast toast = Toast.makeText(getApplicationContext(),
                "Completed", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public String getComment() {
        return noteEdittext.getText().toString();
    }

    @Override
    public void onDatePicked(String date) {
        dateView.setText(date);
    }

    @Override
    public void onTimePicked(String time) {
        timeView.setText(time);
    }

    @OnClick(R.id.date_view)
    public void onDateViewClicked() {
        presenter.pickDate();
    }

    @OnClick(R.id.time_view)
    public void onTimeViewClicked() {
        presenter.pickTime();
    }

    @Override
    public void onDestroy() {
        presenter.deatachView();
        super.onDestroy();
    }
}
