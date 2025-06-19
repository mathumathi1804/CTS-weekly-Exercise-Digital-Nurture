interface PaymentOption {
    void payAmount(double amount);
}

class CardPayment implements PaymentOption {
    public void payAmount(double amount) {
        System.out.println("Payment of ₹" + amount + " done via Card method.");
    }
}

class OnlineWallet implements PaymentOption {
    public void payAmount(double amount) {
        System.out.println("Payment of ₹" + amount + " done via Online Wallet.");
    }
}

class PaymentHandler {
    private PaymentOption option;

    public void chooseOption(PaymentOption option) {
        this.option = option;
    }

    public void startTransaction(double amount) {
        if (option != null) {
            option.payAmount(amount);
        } else {
            System.out.println("Please select a valid payment method.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Payment System:");

        PaymentHandler handler = new PaymentHandler();

        handler.chooseOption(new CardPayment());
        handler.startTransaction(1500);

        handler.chooseOption(new OnlineWallet());
        handler.startTransaction(2200);
    }
}
