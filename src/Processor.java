

public class Processor implements Comparable<Processor> {
	
	private List processedTasks;
	
	private int id;
	
	public Processor(int id, List processedTasks) {
		this.id = id;
		this.processedTasks = processedTasks;
		
	}
	
	public int getID() {
		return id;
	}
	
	public List getList() {
		return processedTasks;
	}
	
	public int getActiveTime() {
			int sum = 0;
			
			List pt = getList();
			
			Node iterator = pt.getHead();
			
			while (iterator != null) {
				Task tsk = iterator.getData();
				
				int tm = tsk.getTime();
				
				sum += tm;
				
				iterator = iterator.getNext();
			}
			return sum;
		}

	@Override
	public int compareTo(Processor p) {
		
		int pt1 = this.getActiveTime();
		int pt2 = p.getActiveTime();
		
		int id1 = this.getID();
		int id2 = p.getID();
		
		if(pt1 != pt2) {
			return pt1 - pt2;
		}
		return id1 - id2;
	}
	public String toString() {
		return "id "+ getID()+ " List: "+ getList();
	}
}
