public class Sort{
	
	
	public void HeapSort(Task p[])
    {
        int len = p.length;
  
        
        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(p, len, i);
  
        for (int i=len-1; i>=0; i--)
        {
            
            Task temp = p[0];
            p[0] = p[i];
            p[i] = temp;
 
            heapify(p, i, 0);
        }
    }
  
    void heapify(Task p[], int n, int i)
    {
        int largest = i;  
        int left = 2*i + 1;  
        int right = 2*i + 2;  
  
        
        if (left < n && p[left] !=null && p[left].getTime() < p[largest].getTime())
            largest = left;
  
        
        if (right < n && p[right] !=null && p[right].getTime() < p[largest].getTime())
            largest = right;
  
       
        if (largest != i)
        {
            Task swap = p[i];
            p[i] = p[largest];
            p[largest] = swap;
  
            
            heapify(p, n, largest);
        }
    }
 
}