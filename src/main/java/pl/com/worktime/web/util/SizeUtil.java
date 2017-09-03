package pl.com.worktime.web.util;

import com.vaadin.ui.AbstractComponent;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.server.Sizeable.Unit.PIXELS;

public class SizeUtil {

    public static void setHeightAndMaxWidth(AbstractComponent component, int height) {
        component.setWidth(100, PERCENTAGE);
        component.setHeight(height, PIXELS);
    }

    public static void setWidthAndMaxHeight(AbstractComponent component, int width) {
        component.setHeight(100, PERCENTAGE);
        component.setWidth(width, PIXELS);
    }
}
