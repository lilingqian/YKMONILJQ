package com.example.lenovo.yk_moni_ljq.ui;

public interface BaseContract {

    interface  BasePresenter<T extends  BaseView>{
        void  attchView(T view);

        void  detachView();

    }

    interface  BaseView{

        void showLoading();

        void  dismissLoading();

    }
}
