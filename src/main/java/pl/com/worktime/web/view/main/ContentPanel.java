package pl.com.worktime.web.view.main;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Radosław Kozdruń
 * 27.08.2017
 */
public class ContentPanel extends Panel {

    public ContentPanel() {
        setContent(new Label("treść"));
        setSizeFull();
        addStyleName("content-panel");
    }

    public void changeView(View view) {
        setContent((Component) view);
    }
}