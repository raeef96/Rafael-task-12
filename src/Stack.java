public interface Stack<E> {
    /**
     * Adds an object to the top of the stack.
     * @param object object The object to add.
     */
    public void push(E object);
    /**
     * Retrieves the object of the top of the
     * stack and removes it from the stack.
     * @return E The topmost object.
     */
    public E pop();
    /**
     * Retrieves the object of the top of the
     * stack without removing it from the stack.
     * @return E The topmost object.
     */
    public E top();
    /**
     * Get the size of the stack.
     * @return int The size of the stack.
     */
    public int size();
    /**
     * Returns true if the stack is empty.
     * @return boolean True if empty.
     */
    public boolean isEmpty();
}
