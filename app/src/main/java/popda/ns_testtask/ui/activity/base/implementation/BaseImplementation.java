package popda.ns_testtask.ui.activity.base.implementation;

import popda.ns_testtask.ui.activity.base.presenter.BasePresenter;
import popda.ns_testtask.ui.activity.base.view.BaseView;

public class BaseImplementation<V extends BaseView> implements BasePresenter<V> {
    protected V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void deatachView() { view = null; }
}
