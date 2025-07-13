import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {
    static class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Enqueue operation
        public void enqueue(int data) {
            stack1.push(data);
        }

        // Dequeue operation
        public int dequeue() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1;
                }
                // Move all elements from stack1 to stack2
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        // Display elements of the queue
        public void display() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            Stack<Integer> temp = new Stack<>();

            // Print stack2 elements (they are in correct queue order)
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }

            // Print stack1 elements in order (reverse of their order in stack1)
            for (int i = 0; i < stack1.size(); i++) {
                temp.push(stack1.get(i));
            }

            while (!temp.isEmpty()) {
                System.out.print(temp.pop() + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        while (true) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Choose operation: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = scanner.nextInt();
                    queue.enqueue(val);
                    break;
                case 2:
                    int removed = queue.dequeue();
                    if (removed != -1) {
                        System.out.println("Dequeued: " + removed);
                    }
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
