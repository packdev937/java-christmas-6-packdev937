package christmas.config;

import christmas.controller.EventController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    public static AppConfig getInstance() {
        return new AppConfig();
    }

    public EventController eventController() {
        return new EventController(outputView(), inputView());
    }

//    public EventService service() {
//        return new EventService();
//    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
