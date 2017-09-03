package pl.com.worktime.web.util.component;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.worktime.web.presenter.Presenter;
import pl.com.worktime.web.view.TimesheetView;
import pl.com.worktime.web.view.View;

import javax.annotation.PostConstruct;

public abstract class ViewHorizontal<P extends Presenter> extends HorizontalLayout implements View<P> {

    private static final Logger LOG = LoggerFactory.getLogger(TimesheetView.class);

    protected P presenter;

    public ViewHorizontal(P presenter) {
        this.presenter = presenter;
        this.presenter.setView(this);
    }

    @PostConstruct
    void initView() {
        initLayout();
        initProperties();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        presenter.onEnter();
    }
}
