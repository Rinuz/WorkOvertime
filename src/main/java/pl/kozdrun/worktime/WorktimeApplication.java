package pl.kozdrun.worktime;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class WorktimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorktimeApplication.class, args);
    }

    @Service
    public static class MyService {
        public String sayHi() {
            return "Hello Spring Initializr!";
        }

    }

    @Theme("valo")
    @SpringUI(path = "")
    public static class VaadinUI extends UI {

        @Autowired
        MyService myService;

        @Override
        protected void init(VaadinRequest request) {
            setContent(new Label(myService.sayHi()));
        }
    }
}
