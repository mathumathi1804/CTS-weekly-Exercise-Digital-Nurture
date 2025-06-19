import java.util.*;

class Order {
    int id;
    String name;

    Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Customer Order Sorting by Mathumathi");

        Order[] list = new Order[4];

        list[0] = new Order(104, "mathu");
        list[1] = new Order(102, "karthi");
        list[2] = new Order(105, "yalini");
        list[3] = new Order(101, "Divya");

        Arrays.sort(list, new Comparator<Order>() {
            public int compare(Order a, Order b) {
                return a.id - b.id;
            }
        });

        System.out.println("Sorted Orders:");
        for (Order o : list) {
            System.out.println(o);
        }
    }
}
