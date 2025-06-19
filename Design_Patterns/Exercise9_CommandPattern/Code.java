interface Task {
    void run();
}

class Light {
    public void switchOn() {
        System.out.println("Light is now ON.");
    }

    public void switchOff() {
        System.out.println("Light is now OFF.");
    }
}

class TurnOnLight implements Task {
    private Light light;

    public TurnOnLight(Light light) {
        this.light = light;
    }

    public void run() {
        light.switchOn();
    }
}

class TurnOffLight implements Task {
    private Light light;

    public TurnOffLight(Light light) {
        this.light = light;
    }

    public void run() {
        light.switchOff();
    }
}

class Controller {
    private Task command;

    public void setCommand(Task command) {
        this.command = command;
    }

    public void click() {
        if (command != null) {
            command.run();
        } else {
            System.out.println("No command assigned.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Home Automation and Command Pattern");

        Light livingRoomLight = new Light();

        Task turnOn = new TurnOnLight(livingRoomLight);
        Task turnOff = new TurnOffLight(livingRoomLight);

        Controller remote = new Controller();

        remote.setCommand(turnOn);
        remote.click();

        remote.setCommand(turnOff);
        remote.click();
    }
}
