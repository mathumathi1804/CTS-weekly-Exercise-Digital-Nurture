public class Main {

    static double forecast(double amount, double rate, int year) {
        if (year == 0) return amount;
        return forecast(amount * (1 + rate / 100), rate, year - 1);
    }

    public static void main(String[] args) {
        System.out.println("Finance Forecast - Mathumathi P");

        double amt = 10000;
        double r = 8;
        int y = 5;

        double finalAmt = forecast(amt, r, y);

        System.out.println("Start: ₹" + amt);
        System.out.println("Rate: " + r + "%");
        System.out.println("Years: " + y);
        System.out.println("Final: ₹" + String.format("%.2f", finalAmt));
    }
}
