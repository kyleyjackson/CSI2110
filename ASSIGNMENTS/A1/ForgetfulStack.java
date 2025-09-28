package ASSIGNMENTS.A1;

import java.util.EmptyStackException;
import java.util.ArrayList;

public class ForgetfulStack<E> {

    // nested node class
    private static class Node<E> {
        
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
    }

    // instance variables
    private Node<E> top;
    private Node<E> bottom;
    private int size;
    private ArrayList<Node<E>> aux; // reference ArrayList for any instance of ForgetfulStack<E>

    // constructor
    public ForgetfulStack() {
        top = null;
        bottom = null;
        size = 0;
    }

    // methods
    public void push(E element) {
        Node<E> newN = new Node<>(element);

        if (top == null) {
            top = bottom = newN;
        } else {
            newN.prev = top;
            top.next = newN;
            top = newN;
        }

        aux.add(aux.size() - 1, newN); // add at the back so stack is in order of descending store time

        size++;
    }

    public E pop() {
        if (top == null) { throw new EmptyStackException(); }

        E e = top.element;
        top = top.prev;
        
        if (top == null) { bottom = null; }
        else { top.next = null; }

        aux.remove(0); // always popping top (index 0)

        size--;
        
        return e;
    }

    public void forget(int k) {
        if (k < 1) { throw new IllegalArgumentException("Can't forget 0 or a negative amount of elements."); } // invalid argument

        if (k >= aux.size()) { // when kthe stack would be empty
            aux = new ArrayList<>();
            top = bottom = null;
            size = 0;
        }

        Node<E> nextToBot = aux.get(k + 1); // grab the soon-to-be second node from the bottom for pointer updates

        // pointer updates
        bottom = aux.get(k); 
        bottom.next = nextToBot;
        nextToBot.prev = bottom;

        // auxiliary list updates
        aux.set(k + 1, nextToBot);
        aux.set(k, bottom);
        aux.subList(k, aux.size());

        size = size - k;
    }

    public boolean isEmpty() { return (size == 0); }

    public E top() { return top.element; }

    public int size() { return size; }

    // NON ASSIGNMENT RELATED
    public String toString() {
        if (isEmpty()) { return "[]"; }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = top;

        while (current != null) {
            sb.append(current.element);

            if (current.next != null) { sb.append(", "); }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    // testing
    public static void main(String[] args) {
        ForgetfulStack<Integer> s = new ForgetfulStack<>();

        s.push(1); // [1]
        s.push(2); // [1, 2]
        s.push(3); // [1, 2, 3]
        s.push(4); // [1, 2, 3, 4]
        s.push(5); // [1, 2, 3, 4, 5]
        s.push(6); // [1, 2, 3, 4, 5, 6]

        s.pop(); // [1, 2, 3, 4, 5]

        s.forget(2); // [3, 4, 5]

        s.toString();
    }
}