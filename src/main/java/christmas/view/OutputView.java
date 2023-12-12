package christmas.view;

import christmas.utils.messages.OutputMessage;

public class OutputView {

    public void displayEventStartMessage() {
        System.out.print(OutputMessage.EVENT_START_MESSAGE.getMessage());
    }

    public void displayEventAnnounceMessage(int month, int day) {
        System.out.print(OutputMessage.EVENT_ANNOUCEMENT_MESSAGE.format(month, day));
    }

}
