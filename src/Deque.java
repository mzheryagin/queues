import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that
 * supports adding and removing items from either the front or the back of the data structure.
 * @param <T> some type
 */
public class Deque<T> implements Iterable<T> {
  private int dequeSize;
  private Item<T> firstItem;
  private Item<T> lastItem;


  public Deque() {                         // construct an empty deque
    firstItem = null;
    lastItem = null;
    dequeSize = 0;
  }

  public boolean isEmpty() {               // is the deque empty?
    return dequeSize == 0;
  }

  public int size() {                      // return the number of items on the deque
    return dequeSize;
  }

  public void addFirst(T item) {           // add the item to the front
    if (item == null) {
      throw new java.lang.IllegalArgumentException();
    }
    Item<T> currentItem = new Item<>(item);
    if (firstItem != null) {
      firstItem.previousItem = currentItem;
      currentItem.nextItem = firstItem;
      firstItem = currentItem;
    } else {
      firstItem = currentItem;
      lastItem = currentItem;
    }
    dequeSize++;
  }

  public void addLast(T item) {           // add the item to the end
    if (item == null) {
      throw new java.lang.IllegalArgumentException();
    }
    Item<T> currentItem = new Item<>(item);
    if (lastItem != null) {
      lastItem.nextItem = currentItem;
      currentItem.previousItem = lastItem;
      lastItem = currentItem;
    } else {
      firstItem = currentItem;
      lastItem = currentItem;
    }
    dequeSize++;
  }


  public T removeFirst() {               // remove and return the item from the front
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    Item<T> oldFirstItem = firstItem;
    if (size() == 1) {
      firstItem = null;
      lastItem = null;
    } else {
      firstItem = firstItem.nextItem;
      firstItem.previousItem = null;
      oldFirstItem.nextItem = null;
    }
    dequeSize--;
    return oldFirstItem.data;
  }

  public T removeLast() {                // remove and return the item from the end
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    Item<T> oldLastItem = lastItem;
    if (size() == 1) {
      firstItem = null;
      lastItem = null;
    } else {
      lastItem = lastItem.previousItem;
      lastItem.nextItem = null;
      oldLastItem.previousItem = null;
    }
    dequeSize--;
    return oldLastItem.data;
  }

  private class DequeIterator implements Iterator<T> {
    private Item<T> currentIterItem = firstItem;

    public boolean hasNext() {
      return currentIterItem != lastItem;
    }

    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item<T> oldCurrentItem = currentIterItem;
      currentIterItem = currentIterItem.nextItem;
      return oldCurrentItem.data;
    }

    public void remove() {
      throw new java.lang.UnsupportedOperationException();
    }
  }

  public Iterator<T> iterator() {        // return an iterator over items in order from front to end
    return new DequeIterator();
  }

  private static class Item<U> {
    private Item<U> nextItem = null;
    private Item<U> previousItem = null;
    private U data;

    private Item(U data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {   // unit testing (optional)
    Deque<Integer> intDeq = new Deque<>();
    for (int i = 1; i <= 10 ; i++) {
      if (i % 2 == 0) {
        intDeq.addFirst(i);
      } else {
        intDeq.addLast(i);
      }
    }

    for (Integer a:intDeq) {
      System.out.println("a = " + a);
    }
    System.out.println("count = " + intDeq.size());

    Iterator<Integer> iter = intDeq.iterator();
    System.out.println("Using iterator");
    while (iter.hasNext()) {
      System.out.println("a = " + iter.next());
    }

    for (int i = 0; i < 5; i++) {
      System.out.println("Element " + intDeq.removeFirst() + " was removed");
    }
    System.out.println("count = " + intDeq.size());
    for (int i = 0; i < 5; i++) {
      System.out.println("Element " + intDeq.removeLast() + " was removed");
    }
    System.out.printf("count = " + intDeq.size());
  }
}
