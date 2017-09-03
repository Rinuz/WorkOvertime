package pl.com.worktime.web.presenter;


import pl.com.worktime.web.view.View;

import java.io.Serializable;


public abstract class Presenter<T extends View> implements Serializable {

    private T view;

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public abstract void onEnter();
}
