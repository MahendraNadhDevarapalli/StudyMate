package studymate;

import java.util.ArrayList;

public class TaskManager {
    // List to store all study tasks in memory
    private ArrayList<Task> tasks;
    
    // Automatically assigns a unique ID to each newly added task
    private int nextId;

    // Constructor 1: Starts fresh with an empty task list
    public TaskManager() {
        this.tasks = new ArrayList<Task>();
        this.nextId = 1;
    }

    // Constructor 2: Used when loading existing tasks from a file
    public TaskManager(ArrayList<Task> loadedTasks) {
        if (loadedTasks != null) {
            this.tasks = loadedTasks;
        } else {
            this.tasks = new ArrayList<Task>();
        }

        // Find the highest ID among loaded tasks so new IDs never clash
        int highestId = 0;
        for (Task task : this.tasks) {
            if (task.getId() > highestId) {
                highestId = task.getId();
            }
        }
        this.nextId = highestId + 1;
    }

    // Add a new task with auto-generated ID
    public void addTask(String name, String subject, String dueDate) {
        Task newTask = new Task(this.nextId, name, subject, dueDate, false);
        this.tasks.add(newTask);
        System.out.println("Task added successfully! (Assigned ID: " + this.nextId + ")");
        this.nextId++;
    }

    // Display all tasks
    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("--- All Tasks ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Helper method: search for a task by its unique ID
    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // Not found
    }

    // Mark a task as completed by ID
    public boolean markTaskCompleted(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.markCompleted();
            System.out.println("Task ID " + id + " marked as completed!");
            return true;
        } else {
            System.out.println("Error: Task with ID " + id + " not found.");
            return false;
        }
    }

    // Delete a task by ID
    public boolean deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task ID " + id + " deleted successfully!");
            return true;
        } else {
            System.out.println("Error: Task with ID " + id + " not found.");
            return false;
        }
    }

    // Show only tasks belonging to a specific subject
    public void filterBySubject(String subject) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to filter.");
            return;
        }

        boolean foundMatch = false;
        System.out.println("--- Tasks for Subject: " + subject + " ---");
        for (Task task : tasks) {
            // Case-insensitive comparison (e.g., 'math' matches 'Math')
            if (task.getSubject().equalsIgnoreCase(subject.trim())) {
                System.out.println(task);
                foundMatch = true;
            }
        }

        if (!foundMatch) {
            System.out.println("No tasks found for subject: " + subject);
        }
    }

    // Show statistics: total, completed, pending, and completion percentage
    public void showStatistics() {
        int total = tasks.size();

        // Safely handle an empty list to avoid division by zero (0 / 0)
        if (total == 0) {
            System.out.println("--- Task Statistics ---");
            System.out.println("Total tasks: 0");
            System.out.println("Completed tasks: 0");
            System.out.println("Pending tasks: 0");
            System.out.println("Completion rate: 0.0%");
            return;
        }

        int completed = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completed++;
            }
        }

        int pending = total - completed;
        double percentage = ((double) completed / total) * 100.0;

        System.out.println("--- Task Statistics ---");
        System.out.println("Total tasks: " + total);
        System.out.println("Completed tasks: " + completed);
        System.out.println("Pending tasks: " + pending);
        System.out.printf("Completion rate: %.1f%%\n", percentage);
    }

    // Returns the task list (useful for saving tasks to file)
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
