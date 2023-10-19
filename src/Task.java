

public class Task {
	
	private int id;
	private int time;

	public Task(int id, int time) {
		this.id = id;
		this.time = time;
		
	}

	public int getId() {
		return id;
	}

	public int getTime() {
		return time;
	}
	
	public String toString(){
		return " "+getTime();
		}//toString
	
}
