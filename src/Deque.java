import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that
 * supports adding and removing items from either the front or the back of the data structure.
 * @param <T>
 */
public class Deque<T> implements Iterable<T>
{
    private int dequeSize;
    private Item<T> firstItem;
    private Item<T> lastItem;

    public Deque()                           // construct an empty deque
    {
        firstItem = null;
        lastItem = null;
        dequeSize = 0;
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
        Item<T> currentItem = new Item<>(item);
        if(firstItem != null)
        {
            currentItem.nextItem = firstItem;
            firstItem = currentItem;
        }
        else
        {
            firstItem = currentItem;
            lastItem = currentItem;
        }
        dequeSize++;
    }

    public void addLast(T item)           // add the item to the end
    {
        if(item == null) throw new java.lang.IllegalArgumentException();
        Item<T> currentItem = new Item<>(item);
        if(lastItem != null)
        {
            lastItem.nextItem = currentItem;
            lastItem = currentItem;
        }
        else
        {
            firstItem = currentItem;
            lastItem = currentItem;
        }
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

    private class DequeIterator implements Iterator<T>
    {
        public boolean hasNext()
        {
            return currentItem != lastItem;
        }
        public T next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            return currentItem;
        }
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public Iterator<T> iterator()         // return an iterator over items in order from front to end
    {

    }

    private static class Item<U>
    {
        private Item<U> nextItem = null;
        private U data;

        private Item(U data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args)   // unit testing (optional)
    {

    }
}
