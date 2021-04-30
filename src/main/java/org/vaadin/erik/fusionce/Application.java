package org.vaadin.erik.fusionce;

import java.util.Random;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@Theme(value = "fusion-ce-demo")
@PWA(name = "TypeScript and Collaboration - Fused", shortName = "T&C - F", offlineResources = {"images/logo.png"})
public class Application extends SpringBootServletInitializer implements AppShellConfigurator, VaadinServiceInitListener {

    public static final String USER_ATTRIBUTE = "user";

    private static final Random random = new Random();

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        // Epic login
        serviceInitEvent.getSource().addSessionInitListener(event -> {
            event.getSession().setAttribute(
                    USER_ATTRIBUTE, "User" + random.nextInt(10000));
        });
    }
}
