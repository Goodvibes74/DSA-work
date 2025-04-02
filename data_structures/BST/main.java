package BST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new Binary Search Tree instance
        BSTree tree = new BSTree();
        boolean running = true;

        // Display the menu of available operations
        System.out.println("Binary Search Tree");
        System.out.println("Choose operation:\n insert <value>\n remove <value>\n search <value>\n display\n exit");

        // Use a Scanner to read user input
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.print("Enter command: ");
                String input = scanner.nextLine(); // Read the user's input
                String[] parts = input.split(" "); // Split the input into command and arguments
                String command = parts[0]; // Extract the command

                // Handle the command using a switch statement
                switch (command.toLowerCase()) {
                    case "insert" -> {
                        // Handle the "insert" command
                        if (parts.length > 1) {
                            try {
                                int value = Integer.parseInt(parts[1]); // Parse the value to insert
                                tree.insert(new Node(value)); // Insert the value into the tree
                                System.out.println("Inserted " + value);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid value. Please enter an integer.");
                            }
                        } else {
                            System.out.println("Usage: insert <value>");
                        }
                    }
                    case "remove" -> {
                        // Handle the "remove" command
                        if (parts.length > 1) {
                            try {
                                int value = Integer.parseInt(parts[1]); // Parse the value to remove
                                tree.remove(value); // Remove the value from the tree
                                System.out.println("Removed " + value);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid value. Please enter an integer.");
                            }
                        } else {
                            System.out.println("Usage: remove <value>");
                        }
                    }
                    case "search" -> {
                        // Handle the "search" command
                        if (parts.length > 1) {
                            try {
                                int value = Integer.parseInt(parts[1]); // Parse the value to search
                                boolean found = tree.search(value); // Search for the value in the tree
                                System.out.println("Search result for " + value + ": " + found);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid value. Please enter an integer.");
                            }
                        } else {
                            System.out.println("Usage: search <value>");
                        }
                    }
                    case "display" -> {
                        // Handle the "display" command
                        tree.display(); // Display the tree structure
                    }
                    case "exit" -> {
                        // Handle the "exit" command
                        running = false; // Exit the loop
                        System.out.println("Exiting...");
                    }
                    default -> {
                        // Handle unknown commands
                        System.out.println("Unknown command. Available commands: insert <value>, remove <value>, search <value>, display, exit");
                    }
                }
            }
        }
    }
}