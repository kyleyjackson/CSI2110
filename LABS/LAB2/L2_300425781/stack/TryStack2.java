public class TryStack2 {

  // Task: create tryStack2 which does the same as this class but uses a
  // LinkedStack instead of an ArrayStack

  protected LinkedStack<Integer> array;
  protected Stack<Integer> stack;

  /**
   * Default constructor.
   */
  public TryStack2() {
    setArray(50);
  }

  public TryStack2(int n) {
    setArray(n);
  }

  public TryStack2(int n, LinkedStack<Integer> stack) {
    setArray(n);
    this.stack = stack;
  }

  /**
   * Gets the array.
   * 
   * @return
   */
  public LinkedStack<Integer> getArray() {
    return this.array;
  }

  /**
   * Sets the array.
   * 
   * @param n
   */
  public void setArray(int n) {
    // creates an array with 50 indices
    this.array = new LinkedStack<>();

    // populates array from 0 to n-1 with i*2
    for (int i = 0; i < n; i++) {
      array.push(i * 2);
    }
  }

  /**
   * Gets the stack.
   * 
   * @return
   */
  public Stack<Integer> getStack() {
    return this.stack;
  }

  /**
   * Sets stack.
   * 
   * @param n
   */
  public void setStack(int n) {
    stack = new ArrayStack<>(n);
  }

  /**
   * Reverses the array using a stack.
   *
   * @return Integer[]
   */
  protected void reverseArray() {
    LinkedStack<Integer> new1 = new LinkedStack<>();
    int size1 = array.size();

    for (int i = 0; i < size1; i++) {
        new1.push(array.pop());
    }

    this.array = new1;
 }
  

  /**
   * Prints an array of any size.
   *
   * @param arr
   */
  protected void printArray() {
    System.out.println(array.toString());
  }

  protected void runSimulation() {
    printArray();
    reverseArray();
    printArray();
  }

  /**
   * Main driver method that will reverse an array.
   *
   * @param args
   */
  public static void main(String[] args) {

    int n = args.length > 0 ? Integer.valueOf(args[0]) : 50;

    TryStack2 tryStack = new TryStack2(n, new LinkedStack<>());
    tryStack.runSimulation();
  }
}
