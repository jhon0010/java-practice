package practice.collections.list.vectors;

import java.util.Stack;

/**
 * Stack class is a legacy class that extends the Vector class and is used to implement a stack data structure.
 * A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle, meaning that the most
 * recently added element is the first one to be removed. The Stack class provides operations for adding elements to
 * the top of the stack (push) and removing elements from the top of the stack (pop).
 *
 * Extends Vector
 * Push and Pop
 * Empty Stack: If you try to pop an element from an empty stack, it will throw an EmptyStackException.
 */
public class StackExample {
    public static void main(String[] args) {
        // Creating a stack of strings
        Stack<String> stack = new Stack<>();

        try {
            // Popping an element from an empty stack throws an EmptyStackException
            stack.pop();
        } catch (Exception e) {
            System.out.println("EmptyStackException: " + e.getMessage());
        }

        // Pushing elements onto the stack
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // Peeking at the top element
        String topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // Popping elements from the stack
        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty: " + isEmpty);
    }
}
