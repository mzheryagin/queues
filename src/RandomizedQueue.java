import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen
 * uniformly at random from items in the data structure.
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
  private int capacity;
  private int itemsCount;
  private Item[] queue;

  /**
   * Construct an empty randomized queue
   */
  public RandomizedQueue() {
    capacity = 1;
    itemsCount = 0;
    queue = (Item[]) new Object[capacity];
  }

  private void increaseQueueSize() {
    capacity *= 2;
    Item[] newQueue = (Item[]) new Object[capacity];
    for (int i = 0; i < itemsCount; i++) {
      newQueue[i] = queue[i];
    }
    queue = newQueue;
  }

  private void decreaseQueueSize() {
    capacity /= 2;
    Item[] newQueue = (Item[]) new Object[capacity];
    for (int i = 0; i < itemsCount; i++) {
      newQueue[i] = queue[i];
    }
    queue = newQueue;
  }

  /**
   *  is the randomized queue empty?
   */
  public boolean isEmpty() {
    return itemsCount == 0;
  }

  /**
   * Return the number of items on the randomized queue
   */
  public int size() {
    return itemsCount;
  }

  /**
   * Add the item
   */
  public void enqueue(Item item) {
    if (item == null) {
      throw new java.lang.IllegalArgumentException();
    }
    if (itemsCount + 1 > capacity / 2) {
      increaseQueueSize();
    }
    queue[itemsCount] = item;
    itemsCount++;
  }

  /**
   * remove and return a random item
   */
  public Item dequeue() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    if (itemsCount - 1 < capacity * 0.25) {
      decreaseQueueSize();
    }
    int returnItemIndex = StdRandom.uniform(itemsCount);
    Item returnItem = queue[returnItemIndex];

    //replace deleted item with the last one and make it null
    queue[returnItemIndex] = queue[--itemsCount];
    queue[itemsCount] = null;
    return returnItem;
  }

  /**
   * return a random item (but do not remove it)
   */
  public Item sample() {
    if (itemsCount == 0) {
      throw new java.util.NoSuchElementException();
    }
    return queue[StdRandom.uniform(itemsCount)];
  }

  private class QueueIterator implements Iterator<Item> {
    private int currentIndex = 0;
    private int[] shuffledIndexes = new int[itemsCount];

    public QueueIterator() {
      for (int i = 0; i < itemsCount; i++) {
        shuffledIndexes[i] = i;
      }
      StdRandom.shuffle(shuffledIndexes);
    }

    public boolean hasNext() {
      return currentIndex < itemsCount;
    }

    public Item next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      return queue[shuffledIndexes[currentIndex++]];
    }

    public void remove() {
      throw new java.lang.UnsupportedOperationException();
    }
  }

  /**
   * return an independent iterator over items in random order
   */
  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  /**
   * unit testing (optional)
   */
  public static void main(String[] args) {
    /*int N = 10;
    RandomizedQueue<Integer> testQueue = new RandomizedQueue<>();
    for (int i = 0; i < N; i++) {
      testQueue.enqueue(StdRandom.uniform(1000));
    }
    for (Integer i : testQueue) {
      System.out.println(i);
    }
    System.out.println();
    for (Integer i : testQueue) {
      System.out.println(i);
    }
    System.out.println();*/

  }
}
