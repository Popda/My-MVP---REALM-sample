package popda.ns_testtask.ui.activity.base.presenter;

import popda.ns_testtask.ui.activity.base.view.BaseView;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void deatachView();
}
