package pl.com.worktime.web.presenter;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;
import pl.com.worktime.application.WorkdayService;
import pl.com.worktime.web.model.TimesheetModel;
import pl.com.worktime.web.view.TimesheetView;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;

@Scope("prototype")
@SpringComponent
public class TimesheetPresenter extends Presenter<TimesheetView> {

    @Inject
    private WorkdayService workdayService;

    private TimesheetModel model;

    @Override
    public void onEnter() {
        model = new TimesheetModel();
        model.setMonth(LocalDate.now());
        model.setWorkdays(workdayService.getWorkdays(LocalDate.now()));

        getView().loadWorkMonthChart(model);
        getView().loadWorkMonthSummery(model);
    }
}
