class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is logger1");
        logger2.log("This is logger2");

        if (logger1 == logger2) {
            System.out.println("Same instance");
        } else {
            System.out.println("Different instances");
        }
    }
}
