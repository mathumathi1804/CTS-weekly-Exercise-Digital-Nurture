interface NotificationSender {
    void send();
}

class Emailsender implements NotificationSender {
    public void send() {
        System.out.println("Sending Email notification");
    }
}

abstract class NotifierDecorator implements NotificationSender {
    protected NotificationSender notifier;

    public NotifierDecorator(NotificationSender notifier) {
        this.notifier = notifier;
    }

    public void send() {
        notifier.send();
    }
}

class SMSmessageDecorator extends NotifierDecorator {
    public SMSmessageDecorator(NotificationSender notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("sending SMS notification");
    }
}

class SlackmessageDecorator extends NotifierDecorator {
    public SlackmessageDecorator(NotificationSender notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("sending Slack notification");
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationSender basicNotifier = new Emailsender();

        NotificationSender emailAndSMS = new SMSmessageDecorator(basicNotifier);

        NotificationSender allNotifications = new SlackmessageDecorator(emailAndSMS);

        allNotifications.send();
    }
}
