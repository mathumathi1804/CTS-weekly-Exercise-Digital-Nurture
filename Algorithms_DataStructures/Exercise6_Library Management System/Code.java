import java.util.*;

class Book {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + " " + title;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Library Book List:");

        LinkedList<Book> books = new LinkedList<>();

        books.add(new Book(1, "Java Basics"));
        books.add(new Book(2, "Data Structures"));
        books.add(new Book(3, "Web Development"));
        books.add(new Book(4, "Algorithms"));

        System.out.println("All Books:");
        for (Book b : books) {
            System.out.println(b);
        }

        books.remove(2); 
        books.addFirst(new Book(0, "C Programming"));

        System.out.println("\nUpdated Book List:");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
