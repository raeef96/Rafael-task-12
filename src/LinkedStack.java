import java.util.EmptyStackException;
import java.util.LinkedList;


/**
 * An implementation of a stack using a linked list.
 */
public class LinkedStack<T> implements Stack<T> {
    private LinkedList<T> list;

    public LinkedStack() {
        list = new LinkedList<T>();
    }

    /**
     * Adds an object to the top of the stack.
     * @param  object The object to add.
     */

    @Override
    public void push(T object) {
        list.addFirst(object);
    }
    /**
     * Retrieves the object of the top of the
     * stack and removes it from the stack.
     * @return T The topmost object.
     */
    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T object = list.removeFirst();
        return object;
    }
    /**
     * Retrieves the object of the top of the
     * stack without removing it from the stack.
     * @return T The topmost object.
     */
    @Override
    public T top() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T object = list.getFirst();
        return object;
    }

    /**
     * Get the size of the stack.
     * @return int The size of the stack.
     */
    @Override
    public int size() {
        return list.size();
    }
    /**
     * Returns true if the stack is empty.
     * @return boolean True if empty.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
