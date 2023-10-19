

/**
 * ListNode represents a list node
 * Each node contains an int as data and a reference to the next node in the list.
 */
public class Node {
    protected Task data;
    protected Node next = null;

    /**
     * Constructor. Sets data
     *
     * @param data the data stored
     * @return
     */
    Node(Task data) {
        this.data = data;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public Task getData() {
        // return data stored in this node
        return data;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public Node getNext() {
        // get next node
        return next;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
