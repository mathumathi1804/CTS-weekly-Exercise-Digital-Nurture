import java.util.*;

class Item {
    int code;
    String name;
    int qty;
    double price;

    Item(int c, String n, int q, double p) {
        code = c;
        name = n;
        qty = q;
        price = p;
    }

    public String toString() {
        return code + " " + name + " " + qty + " ₹" + price;
    }
}

class Inventory {
    HashMap<Integer, Item> list = new HashMap<>();

    void add(Item i) {
        list.put(i.code, i);
        System.out.println("added " + i);
    }

    void update(int code, int q, double p) {
        if (list.containsKey(code)) {
            Item i = list.get(code);
            i.qty = q;
            i.price = p;
            System.out.println("updated " + i);
        } else {
            System.out.println("not found");
        }
    }

    void delete(int code) {
        if (list.containsKey(code)) {
            list.remove(code);
            System.out.println("deleted " + code);
        } else {
            System.out.println("not found");
        }
    }

    void show() {
        System.out.println("\nall items:");
        for (Item i : list.values()) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Inventory system by Mathumathi P");

        Inventory inv = new Inventory();

        Item i1 = new Item(1, "pen", 50, 10);
        Item i2 = new Item(2, "book", 20, 40);

        inv.add(i1);
        inv.add(i2);

        inv.update(1, 30, 8);
        inv.delete(3);
        inv.delete(2);

        inv.show();
    }
}
