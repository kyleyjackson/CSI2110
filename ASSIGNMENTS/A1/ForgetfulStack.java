package ASSIGNMENTS.A1;

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

    // constructor
    public ForgetfulStack() {
        this.top = null;
        this.bottom = null;
    }
}