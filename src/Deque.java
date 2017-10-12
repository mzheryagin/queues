

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that
 * supports adding and removing items from either the front or the back of the data structure.
 * @param <T>
 */
public class Deque<T> implements Iterable<T>
{
    private int dequeSize = 0;
    private T firstItem;
    private T lastItem;
    private T currentItem;

    public Deque()                           // construct an empty deque
    {

    }

    public boolean isEmpty()                 // is the deque empty?
    {
        return dequeSize == 0;
    }

    public int size()                        // return the number of items on the deque
    {
        return dequeSize;
    }

    public void addFirst(T item)          // add the item to the front
    {
        if(item == null) throw new java.lang.IllegalArgumentException();
        dequeSize++;
    }

    public void addLast(T item)           // add the item to the end
    {
        if(item == null) throw new java.lang.IllegalArgumentException();
        dequeSize++;
    }

    public T removeFirst()                // remove and return the item from the front
    {
        if(isEmpty()) throw new java.util.NoSuchElementException();
        dequeSize--;
    }

    public T removeLast()                 // remove and return the item from the end
    {
        if(isEmpty()) throw new java.util.NoSuchElementException();
        dequeSize--;
    }

    public Iterator<T> iterator()         // return an iterator over items in order from front to end
    {

    }

    public static void main(String[] args)   // unit testing (optional)
    {

    }
}
