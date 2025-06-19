interface Paymentprocessor {
    void processpayment(double amount);
}

class PayPalGateway {
    public void makePayPalPayment(double amount) {
        System.out.println("paid ₹" + amount + " using PayPal.");
    }
}

class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("paid ₹" + amount + " using Stripe.");
    }
}

class PayPalAdapter implements Paymentprocessor {
    private PayPalGateway paypal;

    public PayPalAdapter() {
        paypal = new PayPalGateway();
    }

    public void processpayment(double amount) {
        paypal.makePayPalPayment(amount);
    }
}

class StripeAdapter implements Paymentprocessor {
    private StripeGateway stripe;

    public StripeAdapter() {
        stripe = new StripeGateway();
    }

    public void processpayment(double amount) {
        stripe.makeStripePayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Paymentprocessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processpayment(20000.0);

        Paymentprocessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processpayment(1000000.0);
        System.out.println("Adapter Pattern Demo by Mathumathi");
    }
}
