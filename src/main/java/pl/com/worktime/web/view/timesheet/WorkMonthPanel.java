package pl.com.worktime.web.view.timesheet;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.com.worktime.application.dto.OvertimeDto;
import pl.com.worktime.application.dto.WorkdayDto;
import pl.com.worktime.application.dto.WorktimeDto;
import pl.com.worktime.web.model.TimesheetModel;
import pl.com.worktime.web.util.Styles;
import pl.com.worktime.web.view.timesheet.chart.ChartAxisX;
import pl.com.worktime.web.view.timesheet.chart.ChartAxisY;
import pl.com.worktime.web.view.timesheet.chart.ChartBarForOvertime;
import pl.com.worktime.web.view.timesheet.chart.ChartBarForWorktime;
import pl.com.worktime.web.view.timesheet.chart.util.ChartCoordinates;

import java.util.Optional;

import static pl.com.worktime.web.util.DateUtil.*;
import static pl.com.worktime.web.util.SizeUtil.setHeightAndMaxWidth;
import static pl.com.worktime.web.view.timesheet.chart.util.ChartCoordinatesFactory.*;

public class WorkMonthPanel extends VerticalLayout {

    public static final int HEIGHT = 800;
    public static final int CHART_COLUMNS = 25;

    private Label monthLabel;
    private GridLayout chartLayout;

    public WorkMonthPanel() {
        initLayout();
        initPropertes();
    }

    private void initLayout() {
        monthLabel = new Label();
        monthLabel.addStyleName(Styles.WORKMONTH_YEAR_MONTH_LABEL);
        chartLayout = new GridLayout();
        chartLayout.setColumns(CHART_COLUMNS);
        chartLayout.setSizeFull();

        addComponent(monthLabel);
        addComponent(chartLayout);
        setExpandRatio(chartLayout, 1f);
    }

    private void initPropertes() {
        setHeightAndMaxWidth(this, HEIGHT);
        addStyleName(Styles.WORKMONTH_PANEL);
    }

    public void loadChart(TimesheetModel model) {
        loadChartTitle(model);
        loadChartAxis(model);
        loadChartWorktimeBars(model);
        loadChartOvertimeBars(model);
    }

    private void loadChartTitle(TimesheetModel model) {
        String yearAndMonthText = getYearAndMonthName(model.getMonth());
        monthLabel.setValue(yearAndMonthText);
    }

    private void loadChartAxis(TimesheetModel model) {
        chartLayout.setRows(maxRowNumbers(model));

        //axis X (hours of day)
        iterateOverHoursOfTheDay(hourTime -> {
            if (hourTime.getHour() == 0) {
                return;
            }
            ChartAxisX hourLabel = new ChartAxisX(hourTime);
            ChartCoordinates coordinates = createAxisXCoordinates(hourTime, model);
            chartLayout.addComponent(hourLabel, coordinates.getStartColumn(), coordinates.getStartRow(), coordinates.getEndColumn(), coordinates.getEndRow());
        });

        //axis y (days of month)
        iterateOverDaysOfMonth(model.getMonth(), day -> {
            ChartAxisY dayLabel = new ChartAxisY(day);
            ChartCoordinates coordinates = createAxisYCoordinates(day);
            chartLayout.addComponent(dayLabel, coordinates.getStartColumn(), coordinates.getStartRow(), coordinates.getEndColumn(), coordinates.getEndRow());
        });
    }

    private void loadChartWorktimeBars(TimesheetModel model) {
        iterateOverDaysOfMonth(model.getMonth(), day -> {
            Optional<WorkdayDto> workdayOptional = model.getWorkday(day);
            if (workdayOptional.isPresent() && workdayOptional.get().hasWorktimes()) {
                for (WorktimeDto worktime : workdayOptional.get().getWorktimes()) {
                    ChartBarForWorktime bar = new ChartBarForWorktime(worktime);
                    ChartCoordinates coordinates = createBarCoordinates(worktime);
                    chartLayout.addComponent(bar, coordinates.getStartColumn(), coordinates.getStartRow(), coordinates.getEndColumn(), coordinates.getEndRow());
                }
            }
        });
    }

    private void loadChartOvertimeBars(TimesheetModel model) {
        iterateOverDaysOfMonth(model.getMonth(), day -> {
            Optional<WorkdayDto> workdayOptional = model.getWorkday(day);
            if (workdayOptional.isPresent() && workdayOptional.get().hasOvertimes()) {
                for (OvertimeDto overtime : workdayOptional.get().getOvertimes()) {
                    ChartBarForOvertime bar = new ChartBarForOvertime(overtime);
                    ChartCoordinates coordinates = createBarCoordinates(overtime);
                    chartLayout.addComponent(bar, coordinates.getStartColumn(), coordinates.getStartRow(), coordinates.getEndColumn(), coordinates.getEndRow());
                }
            }
        });
    }
}
