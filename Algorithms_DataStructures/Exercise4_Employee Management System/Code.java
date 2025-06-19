// Staff Record Manager - Created by Mathumathi P

class Staff {
    int id;
    String fullName;
    String role;
    double pay;

    Staff(int id, String name, String role, double pay) {
        this.id = id;
        this.fullName = name;
        this.role = role;
        this.pay = pay;
    }

    public String toString() {
        return id + " " + fullName + " " + role + " ₹" + pay;
    }
}

public class Main {
    static Staff[] staffList = new Staff[10];
    static int total = 0;

    static void add(Staff s) {
        if (total < staffList.length) {
            staffList[total++] = s;
            System.out.println("Added: " + s);
        } else {
            System.out.println("List is full. Can't add more.");
        }
    }

    static void showAll() {
        System.out.println("\nAll Staff Records:");
        for (int i = 0; i < total; i++) {
            System.out.println(staffList[i]);
        }
    }

    static void find(int id) {
        boolean found = false;
        for (int i = 0; i < total; i++) {
            if (staffList[i].id == id) {
                System.out.println("Found: " + staffList[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ID " + id + " not in records.");
        }
    }

    static void remove(int id) {
        int i;
        for (i = 0; i < total; i++) {
            if (staffList[i].id == id) {
                break;
            }
        }
        if (i == total) {
            System.out.println("ID " + id + " not found.");
            return;
        }
        for (int j = i; j < total - 1; j++) {
            staffList[j] = staffList[j + 1];
        }
        staffList[--total] = null;
        System.out.println("Removed staff with ID: " + id);
    }

    public static void main(String[] args) {
        System.out.println("Staff Management");

        add(new Staff(11, "Mathu", "Team Lead", 60000));
        add(new Staff(12, "Deepa", "QA", 40000));
        add(new Staff(13, "mathi", "Support", 35000));

        showAll();

        find(12);
        remove(12);

        showAll();
    }
}
