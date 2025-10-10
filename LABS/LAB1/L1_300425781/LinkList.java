// package LABS.LAB1.L1_300425781; //* dont forget to comment out! */

/** 
 * Builds a singly linked list of size 5 and prints it to the console.
 * 
 * @author Jochen Lang
 */

class LinkList<E> {
    GNode<E> head;

	LinkList() {
		head = null;
	}
    
    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
		GNode<E> curr = head;

		while (curr != null) {
			System.out.print((String)curr.getElement() + " ");	
			curr = curr.getNext(); // move to the next
		}

		System.out.println();	
    }

    public void deleteFirst() {
		if ( head != null ) {
			head = head.getNext();
		}
    }

    public void deleteLast() {
		if ( head == null ) {
			System.out.println("List is empty!");
			return;
		}

		GNode<E> prev = head;
		GNode<E> curr = prev.getNext(); 

		if ( curr == null ) { // only 1 node
			head = null;
			return;
		}

		while ( curr.getNext() != null ) { // more than 1 node
			prev = curr;
			curr = curr.getNext();
		}

		prev.setNext( null );
		return;
    }

	public void add(E element) {
		GNode<E> node1 = new GNode<>(element);

		if (head == null) { 
			head = node1; 
		} else {
			GNode<E> curr = head;

			while (curr.getNext() != null) {
				curr = curr.getNext();
			}

			curr.setNext(node1);
		}
	}

    // create and display a linked list
    public static void main(String [] args) {
		/* Create the list */
		LinkList<String> newList = new LinkList<>();
	
		newList.add("0");
		newList.add("1");
		newList.add("2");
		newList.add("3");
		newList.add("4");

		/* Print the list */
		newList.print();
		/* delete first and print */
		newList.deleteFirst();
		newList.print();
		/* delete last and print 5 times */
		for ( int i=0; i< 5; ++i ) {
			newList.deleteLast();
			newList.print();
		}
    }
}
