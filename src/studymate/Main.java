package studymate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n===== StudyMate =====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Filter by Subject");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();

                    manager.addTask(name, subject, dueDate);
                    break;

                case 2:
                    manager.viewAllTasks();
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.markTaskCompleted(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.deleteTask(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid task ID.");
                    }
                    break;

                case 5:
                    System.out.print("Enter subject: ");
                    String filterSubject = scanner.nextLine();
                    manager.filterBySubject(filterSubject);
                    break;

                case 6:
                    manager.showStatistics();
                    break;

                case 7:
                    System.out.println("Thank you for using StudyMate!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Choose 1-7.");
            }
        }
    }
}