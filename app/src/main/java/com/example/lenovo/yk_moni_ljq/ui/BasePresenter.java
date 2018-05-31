package com.example.lenovo.yk_moni_ljq.ui;


public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;

    @Override
    public void attchView(T view) {

        if (view!=null){

            this.mView=view;

        }
    }

    @Override
    public void detachView() {

        if (mView!=null){
            mView=null;

        }
    }
}
