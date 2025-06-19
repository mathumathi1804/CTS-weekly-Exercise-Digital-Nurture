class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return taskId + " - " + taskName + " [" + status + "]";
    }
}

class TaskList {
    Task head;

    void addTask(Task t) {
        if (head == null) {
            head = t;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = t;
        }
        System.out.println("Added: " + t);
    }

    void showTasks() {
        System.out.println("\nAll Tasks:");
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    void searchTask(int id) {
        Task temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Found: " + temp);
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Task ID " + id + " not found.");
        }
    }

    void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            System.out.println("Deleted: " + head);
            head = head.next;
            return;
        }

        Task prev = head;
        Task curr = head.next;

        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println("Deleted: " + curr);
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task ID " + id + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Task Management");

        TaskList tasks = new TaskList();

        tasks.addTask(new Task(1, "Design", "Pending"));
        tasks.addTask(new Task(2, "Build ", "In Progress"));
        tasks.addTask(new Task(3, "Testing", "Pending"));

        tasks.showTasks();

        tasks.searchTask(2);
        tasks.deleteTask(2);

        tasks.showTasks();
    }
}
