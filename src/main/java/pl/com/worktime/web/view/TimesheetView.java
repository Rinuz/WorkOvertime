package pl.com.worktime.web.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

import static pl.com.worktime.web.view.TimesheetView.VIEW_URL;

/**
 * Radosław Kozdruń
 * 30.08.2017
 */
@UIScope
@SpringView(name = VIEW_URL)
public class TimesheetView extends VerticalLayout implements View {

    public static final String VIEW_URL = "timesheet";

    @PostConstruct
    void init() {
        addComponent(new Label("This is a view scoped view"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
