package pl.com.worktime.web.view.timesheet.chart.util;

public class ChartCoordinates {

    private int startColumn;
    private int endColumn;
    private int startRow;
    private int endRow;

    public ChartCoordinates(int startColumn, int startRow, int endColumn, int endRow) {
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.endColumn = endColumn;
        this.endRow = endRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    @Override
    public String toString() {
        return "[" +
                "startColumn=" + startColumn +
                ", endColumn=" + endColumn +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ']';
    }
}