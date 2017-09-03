package pl.com.worktime.web.view.timesheet;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.com.worktime.application.dto.WorkdayDto;
import pl.com.worktime.web.model.TimesheetModel;
import pl.com.worktime.web.util.Styles;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.com.worktime.web.util.DateUtil.getYearAndMonthName;
import static pl.com.worktime.web.util.SizeUtil.setHeightAndMaxWidth;

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
        monthLabel.setValue(getYearAndMonthName(model.getMonth()));

        chartLayout.setRows(model.getMonthDays() + 2);

        for (int i = 0; i < model.getMonthDays(); i++) {
            LocalDate day = model.getMonth().plusDays(i);
            WorkdayDto workday = model.getWorkday(day);
            addChartRow(day, workday);
        }
        addChartFootter(model.getMonthTime());
    }

    private void addChartRow(LocalDate day, WorkdayDto workday) {
        ChartDayLabel dayLabel = new ChartDayLabel(day);
        chartLayout.addComponent(dayLabel, 0, day.getDayOfMonth() - 1);

    }

    private void addChartFootter(LocalDateTime dayTime) {
        for (int i = 0; i < 24; i++) {
            ChartHourLabel hourLabel = new ChartHourLabel(dayTime.plusHours(i+1));
            chartLayout.addComponent(hourLabel, i + 1, chartLayout.getRows() - 2, i + 1, chartLayout.getRows() - 2);
        }
    }
}
