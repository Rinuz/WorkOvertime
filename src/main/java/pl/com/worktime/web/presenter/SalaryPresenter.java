package pl.com.worktime.web.presenter;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;
import pl.com.worktime.web.view.SalaryView;

@Scope("prototype")
@SpringComponent
public class SalaryPresenter extends Presenter<SalaryView> {

    @Override
    public void onEnter() {

    }
}

