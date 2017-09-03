package pl.com.worktime.web.view;

import com.vaadin.spring.annotation.UIScope;
import pl.com.worktime.web.presenter.Presenter;

@UIScope
public interface View<P extends Presenter> extends com.vaadin.navigator.View {

    void initLayout();

    void initProperties();
}
