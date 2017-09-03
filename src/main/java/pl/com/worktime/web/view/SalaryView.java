package pl.com.worktime.web.view;

import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.worktime.web.presenter.SalaryPresenter;
import pl.com.worktime.web.util.Styles;
import pl.com.worktime.web.util.component.ViewHorizontal;

@SpringView(name = SalaryView.VIEW_URL)
public class SalaryView extends ViewHorizontal<SalaryPresenter> {

    public static final String VIEW_URL = "salary";

    @Autowired
    public SalaryView(SalaryPresenter presenter) {
        super(presenter);
    }

    @Override
    public void initLayout() {
    }

    @Override
    public void initProperties() {
        setSizeFull();
        setMargin(true);
        setSpacing(true);
        addStyleName(Styles.VIEW_PANEL);
    }
}
