import java.util.ArrayList;
import java.util.List;

interface PriceTracker {
    void register(PriceObserver observer);
    void unregister(PriceObserver observer);
    void notifyAllObservers();
}

class StockBoard implements PriceTracker {
    private List<PriceObserver> observerList = new ArrayList<>();
    private String company;
    private double currentRate;

    public StockBoard(String company, double currentRate) {
        this.company = company;
        this.currentRate = currentRate;
    }

    public void changeRate(double newRate) {
        System.out.println("New rate for " + company + ": ₹" + newRate);
        this.currentRate = newRate;
        notifyAllObservers();
    }

    public void register(PriceObserver observer) {
        observerList.add(observer);
    }

    public void unregister(PriceObserver observer) {
        observerList.remove(observer);
    }

    public void notifyAllObservers() {
        for (PriceObserver obs : observerList) {
            obs.alert(company, currentRate);
        }
    }
}

interface PriceObserver {
    void alert(String company, double price);
}

class MobileDisplay implements PriceObserver {
    public void alert(String company, double price) {
        System.out.println("MobileDisplay: " + company + " rate updated to ₹" + price);
    }
}

class WebDisplay implements PriceObserver {
    public void alert(String company, double price) {
        System.out.println("WebDisplay: " + company + " rate updated to ₹" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Stock Tracker - Observer Pattern");

        StockBoard stock = new StockBoard("CTS", 3200);

        PriceObserver mobile = new MobileDisplay();
        PriceObserver web = new WebDisplay();

        stock.register(mobile);
        stock.register(web);

        stock.changeRate(3250);
        stock.changeRate(3300);
    }
}
