import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * It takes an integer k as a command-line argument; reads in a sequence of strings
 * from standard input using StdIn.readString(); and prints exactly k of them, uniformly at random.
 * Print each item from the sequence at most once.
 */
public class Permutation {
  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);

    RandomizedQueue<String> queue = new RandomizedQueue<>();
    while (!StdIn.isEmpty()) {
      queue.enqueue(StdIn.readString());
    }

    for (int i = 0; i < k ; i++) {
      StdOut.println(queue.dequeue());
    }
  }
}
