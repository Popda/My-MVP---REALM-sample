package popda.ns_testtask.ui.activity.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;
import popda.ns_testtask.R;
import popda.ns_testtask.core.model.NoteModel;
import popda.ns_testtask.ui.activity.base.BaseActivity;
import popda.ns_testtask.ui.activity.main.implementation.MainImplementation;
import popda.ns_testtask.ui.activity.main.presenter.MainPresenter;
import popda.ns_testtask.ui.activity.main.view.MainView;
import popda.ns_testtask.ui.adapter.MainRecyclerViewAdapter;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.list)
    protected RecyclerView list;
    @BindView(R.id.add_fab)
    protected FloatingActionButton addFab;

    private MainPresenter mainPresenter = new MainImplementation();

    @Override
    protected int getContentView() {
        return R.layout.main_activity_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        ButterKnife.bind(this);

        mainPresenter.attachView(this);

        list.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.getAllReminders();
    }

    @Override
    @OnClick(R.id.add_fab)
    public void openAddDialog() {
        mainPresenter.openAddDialog(addFab);
    }

    @Override
    public void showListData(RealmResults<NoteModel> models) {
        if (list.getAdapter() == null) {
            list.setAdapter(new MainRecyclerViewAdapter(models));
        }
    }

    @Override
    protected void onDestroy() {
        mainPresenter.deatachView();
        super.onDestroy();
    }
}
