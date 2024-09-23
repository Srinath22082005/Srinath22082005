import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String category;
    private String dueDate;
    private String priority;

    public Task(String title, String category, String dueDate, String priority) {
        this.title = title;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task [Title: " + title + ", Category: " + category + ", Due Date: " + dueDate + ", Priority: " + priority + "]";
    }
}

class todolist {
    private ArrayList<Task> tasks;

    public todolist() {
        tasks = new ArrayList<>();
    }

    // Add a task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    // Update a task by index
    public void updateTask(int index, Task task) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, task);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Delete a task by index
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // List all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("[" + i + "] " + tasks.get(i));
            }
        }
    }
}

public class todolistapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        todolist toDoList = new todolist();

        while (true) {
            System.out.println("\nTo-Do List Options:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter task due date (YYYY-MM-DD): ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter task priority (Low, Medium, High): ");
                    String priority = scanner.nextLine();

                    Task newTask = new Task(title, category, dueDate, priority);
                    toDoList.addTask(newTask);
                    break;

                case 2:
                    toDoList.listTasks();
                    System.out.print("Enter task index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter new task title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new task category: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Enter new task due date (YYYY-MM-DD): ");
                    String newDueDate = scanner.nextLine();
                    System.out.print("Enter new task priority (Low, Medium, High): ");
                    String newPriority = scanner.nextLine();

                    Task updatedTask = new Task(newTitle, newCategory, newDueDate, newPriority);
                    toDoList.updateTask(updateIndex, updatedTask);
                    break;

                case 3:
                    toDoList.listTasks();
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    toDoList.deleteTask(deleteIndex);
                    break;

                case 4:
                    toDoList.listTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
