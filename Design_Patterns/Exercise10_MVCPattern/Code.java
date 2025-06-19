class Learner {
    private String name;
    private String studentid;
    private String grade;

    public Learner(String name, String studentid, String grade) {
        this.name = name;
        this.studentid = studentid;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
class LearnerView {
    public void showDetails(String name, String id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
    }
}
class LearnerController {
    private Learner learner;
    private LearnerView view;

    public LearnerController(Learner learner, LearnerView view) {
        this.learner = learner;
        this.view = view;
    }

    public void updateName(String name) {
        learner.setName(name);
    }

    public void updateGrade(String grade) {
        learner.setGrade(grade);
    }

    public void updateId(String id) {
        learner.setStudentid(id);
    }

    public void showLearner() {
        view.showDetails(learner.getName(), learner.getStudentid(), learner.getGrade());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("MVC Pattern Demo Student App");

        Learner student = new Learner("mathu", "22CSEA16", "A");
        LearnerView screen = new LearnerView();
        LearnerController controller = new LearnerController(student, screen);

        controller.showLearner();

        controller.updateName("mathumathi");
        controller.updateGrade("A+");

        System.out.println("\nAfter Update:");
        controller.showLearner(); 
    }
}
