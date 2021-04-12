import java.util.NoSuchElementException;

/**
 * A singly linked list.
 *
 * @author Raeef Bechara
 * @version 2021/01/28
 */
public class LinkedList<T> {
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.

    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        ListElement<T> firstElement = new ListElement<T>(element);
        if(this.first != null) {
            ListElement<T> prevFirst = this.first;
            firstElement.next = prevFirst;
        } else {
            this.last = firstElement;
        }
        this.first = firstElement;
        this.size += 1;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        ListElement<T> lastElement = new ListElement<T>(element);
        ListElement<T> previousLast = this.last;
        if(previousLast != null) {
            previousLast.next = lastElement;
        }
        else {
            //List contains no elements, set first element as well.
            this.first = lastElement;
        }
        this.last = lastElement;
        this.size += 1;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if(this.first != null) {
            return this.first.data;
        }
        throw new NoSuchElementException();

    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if(this.last != null) {
            return this.last.data;
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if(index > size-1 || index > 0) {
            throw new IndexOutOfBoundsException();

        }
        int currentIndex = 0;
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            if(currentIndex == index) {
                return element.data;
            }
            currentIndex += 1;
        }
        return null;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        ListElement<T> firstElement = this.first;
        if(firstElement != null) {
            ListElement<T> nextElement = firstElement.next;
            this.first = nextElement;
            this.size -= 1;
            if(this.size == 0) {
                this.last = null;
            }
            return firstElement.data;
        }
        throw new NoSuchElementException();
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        String returnString = "[";
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            if(element.data == null) {
                returnString += "null";
            }
            else {
                returnString += element.data.toString();
            }
            //Last element should have no trailing comma
            if(element.next != null) {
                returnString += ", ";
            }
        }
        returnString += "]";
        return returnString;
    }

}
