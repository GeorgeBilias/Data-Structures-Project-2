

/**
 * Single-link List. Uses {@link Node} for list nodes.
 */
public class List implements ListInterface {

    protected Node head = null;
    private Node tail = null;
    private int counter = 0;

    /**
     * Default constructor
     */
    public List() {
    }

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    public int length() {
    	
    	return counter;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */
    @Override
    public void insertAtFront(Task data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
        
        counter++;
    }

    /**
     * Inserts the data at the end of the list
     *
     * @param data the inserted item
     */
    @Override
    public void insertAtBack(Task data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        
        counter++;
    }
    
    public Node getHead() {
    	
    	if (isEmpty())
    		return head = null;
    	
    	return head;
    }

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    @Override
    public Task removeFromFront() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        Task data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();
        
        counter--;

        return data;
    }
    
    
    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    @Override
    public Task removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        Task data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }
        counter--;

        return data;
    }

    /**
     * Returns list as String
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        

        while (current != null) {
            ret.append(current.data);

            if (current.getNext() != null)
                ret.append(" ");

            current = current.next;
        }

        
        return ret.toString();
    }
}
