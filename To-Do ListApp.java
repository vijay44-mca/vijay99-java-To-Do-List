import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    static class Task {
        String description;
        boolean isCompleted;

        Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[✓] " : "[ ] ") + description;
        }
    }

    static ArrayList<Task> tasks = new ArrayList<>();

    public static void addTask(String taskDescription) {
        tasks.add(new Task(taskDescription));
        System.out.println("Task added successfully!");
    }

    public static void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    public static void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isCompleted = true;
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- TO-DO LIST MENU ---");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    addTask(desc);
                    break;
                case 2:
                    displayTasks();
                    System.out.print("Enter task number to delete: ");
                    int delIndex = scanner.nextInt();
                    deleteTask(delIndex);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    displayTasks();
                    System.out.print("Enter task number to mark as complete: ");
                    int compIndex = scanner.nextInt();
                    markTaskAsComplete(compIndex);
                    break;
                case 5:
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
