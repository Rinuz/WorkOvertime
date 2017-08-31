package pl.com.worktime.web.resource;

import com.vaadin.server.ThemeResource;

import java.io.File;
import java.net.URL;

/**
 * Radosław Kozdruń
 * 31.08.2017
 */
public class ResourceManager {

    //theme resources
    public static final String IMAGE_PATH = "img/";

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private static File getFile(String path) {
        URL url = classLoader.getResource(path);;
        return url == null ? null : new File(url.getPath());
    }

    public static ThemeResource getIcon(String icon) {
        StringBuffer sb = new StringBuffer();
        sb.append(IMAGE_PATH);
        sb.append(icon);
        sb.append(".png");

        return new ThemeResource(sb.toString());
    }
}
