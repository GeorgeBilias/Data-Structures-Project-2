

public interface ListInterface {
    /**
     * Inserts an data at the front of the list
     * @param data the inserted data
     */
    void insertAtFront(Task data);

    /**
     * Inserts an data at the end of the list
     *
     * @param data the inserted item
     */
    void insertAtBack(Task data);

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    Task removeFromFront() throws EmptyListException;

    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    Task removeFromBack() throws EmptyListException;

    /**
     * Determine whether list is empty
     * @return true if list is empty
     */
    boolean isEmpty();
}
