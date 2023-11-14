package christmas;

import christmas.controller.EventController;
import christmas.service.EventFacadeService;

public class Application {

    public static void main(String[] args) {
        EventController eventController = new EventController(new EventFacadeService());
        eventController.run();
    }
}
