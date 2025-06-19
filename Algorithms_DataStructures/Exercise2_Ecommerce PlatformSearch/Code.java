import java.util.*;

class product {
    int id;
    String productname;

    product(int id, String productname) {
        this.id = id;
        this.productname = productname;
    }

    public String toString() {
        return id + " " + productname;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("product search");

        Scanner sc = new Scanner(System.in);
        ArrayList<product> list = new ArrayList<>();

        list.add(new product(201, "laptop"));
        list.add(new product(202, "phone"));
        list.add(new product(203, "tablet"));
        list.add(new product(204, "charger"));

        System.out.print("Enter product name: ");
        String input = sc.nextLine();

        boolean found = false;

        for (product Prod: list) {
            if (Prod.productname.equalsIgnoreCase(input)) {
                System.out.println("Found: " + Prod);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
}
