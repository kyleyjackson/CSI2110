package P_ASSIGNMENTS.P1_300425781;

public class Node<E> {
    private E element;
    private Node<E> leader;
    private Node<E> next;
    private Integer clusterSize;
    
    Node(E element) {
        this.element = element;
        this.leader = this; 
        this.next = null;
        this.clusterSize = 1;
    }
}