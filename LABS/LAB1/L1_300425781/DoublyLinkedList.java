package LABS.LAB1.L1_300425781;

/** 
 * Builds a singly linked list of size 5 and prints it to the console.
 * 
 * @author Jochen Lang
 */

class DoublyLinkedList {
	DNode head;
	DNode tail;
	DNode curr;

    DoublyLinkedList( int size ) {
		if ( size <= 0 ) {
			head = null;
		}

		else {
			// start with list of size 1
			head = new DNode("0", null, null);
			curr = head;
			tail = head;

			// add linked elements
			for ( int i = 1; i < size; ++i ) {
				DNode node = new DNode( Integer.toString(i), null, null);
				
				// link to tail
				tail.setNext(node);
				node.setPrev(tail);
				tail = node;

				// link to head
				head.setPrev(tail);
				tail.setNext(head);
				curr = node;
			}
		}
    }
    
    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
		/* Print the list */
		if (head == null)
			System.out.println("List is empty!");
		
		else {
			DNode curr = head; // point to the first DNode
			System.out.print((String)curr.getElement() + " ");
			curr = curr.getNext();

			while (curr != head ) {
				System.out.print((String)curr.getElement() + " ");	
				curr = curr.getNext(); // move to the next
			}

			System.out.println();	
		}
    }

    public void deleteFirst() {
		if ( head != null ) {
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
		}
    }

    public void deleteLast() {
		if (tail == head) {
			head = tail = null;
		} else if (tail != null) {
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
		}
	}

    // create and display a linked list
    public static void main(String [] args){
		/* Create the list */
		DoublyLinkedList list = new DoublyLinkedList( 5 );
		/* Print the list */
		list.print();
		/* delete first and print */
		list.deleteFirst();
		list.print();
		/* delete last and print 5 times */
		for ( int i=0; i< 5; ++i ) {
			list.deleteLast();
			list.print();
		}
    }
}
