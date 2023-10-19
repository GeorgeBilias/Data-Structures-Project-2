
public class MaxPQ implements PQInterface {
	
	private Processor[] heap;
	private int size;
	private int counter=0;
	private static final int AUTOGROW_SIZE = 2;
	private static final int DEFAULT_CAPACITY = 4;
	
	
	public MaxPQ() {
        this.heap = (Processor[]) new Processor[DEFAULT_CAPACITY + 1];
        this.size = 0;
    }
	
	public boolean isEmpty() {
		
	  return size == 0;
	}
	//check if the queue is empty
	public int size() {
		
		return counter;	
	}
	//return the number of active elements in the queue
	public void insert(Processor x) {
		
		if (size >= heap.length * 0.75 )
			resize();
		
		heap[++size] = x;
		
		swim(size);
		
		counter++;
	}
	// insert the object x to the queue
	public Processor max() {
		
		if (size == 0) {
			return null;
		}
		
		return heap[1];
	}
	/*return without removing the object with
	the highest priority */
	public Processor getmax() {
		
		if (size == 0) {
			return null;
		}
		
		Processor root = heap[1];
		
		heap[1] = heap[size];
		size--;
		
		sink(1);
		
		counter--;
		
		return root;
	}
	/* remove and return the object
	with the highest priority*/
	
	private void swim(int i) {
		
		if (i ==  1) {
			return;
		}
		
		int parent = i / 2;
		
		while(i != 1 && (heap[i].compareTo(heap[parent]))< 0) {
			swap(i,parent);
			i = parent;
			parent = i /2;
		}
	}
	
	private void sink(int i) {
		int left = 2 * i;
		int right = left + 1;
		
		if (left > size) {
			return;
		}
		
		while (left <= size) {
			int max = left;
			
			if (right <= size) {
				if (heap[left].compareTo(heap[right]) > 0)
					max = right;
			}
			
			if (heap[i].compareTo(heap[max]) <= 0)
				return;
			else {
				swap(i,max);
				i = max;
				left = i * 2;
				right = left + 1;
			}
		}
		
		
	}
	
	private void swap(int i, int j) {
		Processor tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	private void resize() {
		Processor[] newHeap = new Processor[heap.length * AUTOGROW_SIZE];
		
		for (int i = 0; i <= size; i++) {
			newHeap[i] = heap[i];
		}
		
		heap = newHeap;
	}
	
	
	
}
