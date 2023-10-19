import java.io.*;

public class Greedy{
	
	public static void main(String[] args) throws EmptyListException {
		
        String file = args[0];
		
		Greedy rf = new Greedy();
		
		String choice = "no sort";
		String type ="type1";
		
		rf.ReadFile(file,choice,type);
		
	}
	
	public int ReadFile(String file, String choice,String type) throws EmptyListException {
		
		int makespan = 0;
		File fl = null;
		BufferedReader br = null;
		String line;
		MaxPQ mp = new MaxPQ();
		Sort sr = new Sort();
		
		try {
	        fl = new File(file);	
	    } catch (NullPointerException e) {
	        System.err.println("Couldn't find the file...");
	    }//try to find file
		
		try {
	        br = new BufferedReader(new FileReader(fl));
	    } catch (FileNotFoundException e) {
	        System.err.println("Couldn't open the file...");
	    }//try opening file
		
		try {
			line = br.readLine();
			int pronum = Integer.parseInt(line);
			line = br.readLine();
			int tasknum = Integer.parseInt(line);
			
			
			line = br.readLine();
			
			int linenum = 0;
			Task[] pi = new Task[tasknum];
			int ij = 0;
			
			while(line != null) {
				
				if (linenum < tasknum) {
				
				String word[] = line.split(" ");
				
				int id = Integer.parseInt(word[0]);
				int time = Integer.parseInt(word[1]);
				
				
				
				Task t = new Task(id,time);
				
				
				pi[ij]= t;
				
				ij++;
				
				}
				line = br.readLine();
				linenum++;
			}
			br.close();
			
			
		    
            
			if (linenum != tasknum) {
				System.out.println("the number of tasks stated doesn't match the ones on the file");
			}else {
				
				if(choice.equalsIgnoreCase("sort")) {
					sr.HeapSort(pi);
		        }
				
				for (int i=1; i<=tasknum; i++) {
					if (i <= pronum) {
					List pr = new List();
					
					Task ptask = pi[i-1];
					pr.insertAtBack(ptask);
					
					Processor p = new Processor(i,pr);
					mp.insert(p);
					
					}else {
						
						Task ptask = pi[i-1];
						Processor max = mp.getmax();
						max.getList().insertAtBack(ptask);
						mp.insert(max);
						
					}
					
				}
					int max  = 0;
					while (mp.max() != null) {
						Processor mx = mp.getmax();
						makespan = mx.getActiveTime();
						if (makespan > max) {
							max = makespan;
						}
						if (type.equalsIgnoreCase("type1") && tasknum < 50) {
						System.out.println("id "+mx.getID()+", "+"load="+makespan+":"+mx.getList());
						}
					}
					if (type.equalsIgnoreCase("type1")) {
					System.out.println("Makespan = "+max);
					}
			    
			}
		}
		catch(IOException e) {
	    	System.out.println("Couldn't read the line...");
	    }//IOException
		
		return makespan;
		
			
	}
}

