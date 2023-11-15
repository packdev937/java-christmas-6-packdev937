package christmas;

import christmas.config.ApplicationConfig;
import christmas.controller.EventController;

public class Application {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        EventController eventController = applicationConfig.eventController();
        eventController.run();
    }
}
