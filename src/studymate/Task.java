package studymate;

public class Task {
    private int id;
    private String name;
    private String subject;
    private String dueDate;
    private boolean isCompleted;

    // Constructor to initialize all fields
    public Task(int id, String name, String subject, String dueDate, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as completed
    public void markCompleted() {
        this.isCompleted = true;
    }

    // Display the task details in a clear format
    @Override
    public String toString() {
        String status = isCompleted ? "Completed" : "Pending";
        return "[ID: " + id + "] " + name + " | Subject: " + subject + " | Due: " + dueDate + " | Status: " + status;
    }
}
