package ASSIGNMENTS.A1;

import java.util.EmptyStackException;
import java.util.ArrayList;

public class ForgetfulStack<E> {

    // nested node class
    private class Node<E> {
        
        // instance variables
        E element;
        Node<E> next;
        Node<E> prev;

        // node constructor
        public Node(E data) {
            this.next = null;
            this.prev = null;
            this.element = data;
        }

        // helper
        public E getElement() { return element; }
    }

    // instance variables
    private Node<E> top;
    private Node<E> bottom;
    private int size;

    // constructor
    public ForgetfulStack() {
        top = null;
        bottom = null;
        size = 0;
    }

    // methods
    public void push(E element) {
        Node<E> newN = new Node<>(element); // node to be added

        if (top == null) {
            top = bottom = newN;
        } else { // pointer assignments
            newN.prev = top;
            top.next = newN;
            top = newN;
        }


        size++;
    }

    public E pop() {
        if (top == null) { throw new EmptyStackException(); }

        E e = top.element; // to be returned
        top = top.prev; // pointer assignment
        
        if (top == null) { bottom = null; }
        else { top.next = null; }

        size--;
        
        return e;
    }

    public void forget(int k) {
        if (k < 1) { throw new IllegalArgumentException("Can't forget 0 or a negative amount of elements."); } // invalid argument

        if (k >= size()) { // empty the stack
            top = bottom = null;
            size = 0;
        } else {
            for (int i = 0; i < k; i++) { // constant for all stack sizes per k-value 
                bottom = bottom.next;
                bottom.prev = null;
            }

            size = size - k;
        }
    }

    public boolean isEmpty() { return (size == 0); }

    public E top() { 
        if (top == null) { throw new EmptyStackException(); }
        return top.getElement(); 
    }

    public int size() { return size; }

    // NON ASSIGNMENT RELATED
    public String toString() {
        if (size() == 0) { return "Stack (Top -> Bottom): []"; }

        Node<E> current = top;
        String str = "Stack (Top -> Bottom): [";

        for (int i = 0; i < size() - 1; i++) {
            str = str + current.getElement() + ", ";
            current = current.prev;
        }

        str = str + current.getElement() + "]";
        return str;
    }

    // testing
    public static void main(String[] args) {
        ForgetfulStack<Integer> s = new ForgetfulStack<>();

        s.push(1); 
        s.push(2); 
        s.push(3); 
        s.push(4); 
        s.push(5); 
        s.push(6); 
        
        System.out.println(s.toString()); // [6, 5, 4, 3, 2, 1]
        System.out.println("Top element: " + s.top()); // 6
        System.out.println("Size: " + s.size()); // 6
        System.out.println("Stack is empty: " + s.isEmpty()); // false
        System.out.println();

        s.pop(); 

        System.out.println(s.toString()); // [5, 4, 3, 2, 1]
        System.out.println("Top element: " + s.top()); // 5
        System.out.println("Size: " + s.size()); // 5
        System.out.println("Stack is empty: " + s.isEmpty()); // false
        System.out.println();

        s.forget(2); 

        System.out.println(s.toString()); // [5, 4, 3]
        System.out.println("Top element: " + s.top()); // 5
        System.out.println("Size: " + s.size()); // 3
        System.out.println("Stack is empty: " + s.isEmpty()); // false
        System.out.println();

        s.forget(99); 

        System.out.println(s.toString()); // []
        System.out.println("Size: " + s.size()); // 0
        System.out.println("Stack is empty: " + s.isEmpty()); // false
        System.out.println("Top element: " + s.top()); // should throw EmptyStackException
    }
}