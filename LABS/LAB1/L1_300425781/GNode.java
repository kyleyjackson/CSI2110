// package LABS.LAB1.L1_300425781; //* dont forget to comment out! */

// Originally part of the net.datastructures package
/**
 * Node of a singly linked list, which stores references to its
 * element and to the next node in the list.
 * 
 * @author Natasha Gelfand
 * @author Roberto Tamassia
 * @author Michael Goodrich
 */
//begin#fragment Node
public class GNode<E> {
  // Instance variables:
  private E element;
  private GNode<E> next;
  
  public GNode(E element) { // updated the constructor for simplicity
    this.element = element;
    this.next = null;
  }

  // Accessor methods:
  public E getElement() {
    return element; 
  }
  public GNode<E> getNext() { 
    return next;
  }
  // Modifier methods:
  public void setElement(E newElem) { 
    element = newElem; 
  }
  public void setNext(GNode<E> newNext) {
    next = newNext; 
  }
}
//end#fragment Node
