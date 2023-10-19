import java.io.*;
import java.util.Random;

public class Comparisons{
	
	public static void main(String[] args) {
		
		Comparisons cm = new Comparisons();
		
		String s = args[0];
		
		int tasknum = 100;
		int a = 0;
		cm.WriteFile(tasknum,a,s);
		cm.ReadTxts(a,s);
		
		 a += 10;
		 tasknum = tasknum + 150;
		 cm.WriteFile(tasknum,a,s);
		 cm.ReadTxts(a,s);
		
		 a += 10;
		 tasknum = tasknum + 250;
		 cm.WriteFile(tasknum,a,s);
		 cm.ReadTxts(a,s);
		}
		
		
		
	public void ReadTxts(int c,String s) {
		
		Greedy rf = new Greedy();
		int makespan = 0;
		int sortedmakespan = 0;
		int total_makespan = 0;
		int total_sortedmakespan = 0;
		String type = "type2";
	    
		for (int i=1; i<=10; i++) {
			int ci = c + i;
			String choice = "no sort";
			String file = s+ci+".txt";
		
			try {
				makespan = rf.ReadFile(file,choice,type);
				
				total_makespan += makespan;
				
			} catch (EmptyListException e) {
				System.out.println("Couldn't read the file");
			}
	
			String choice2 = "sort";
	
			try {
				sortedmakespan = rf.ReadFile(file,choice2,type);
			    total_sortedmakespan += sortedmakespan;
			} catch (EmptyListException e) {
				System.out.println("Couldn't read the file");
			}
		    
		}
		int average_makespan = total_makespan/10;
		int average_sortedmakespan = total_sortedmakespan/10;
		System.out.println("Average makespan: "+ average_makespan);
		System.out.println("Average sorted makespan: "+ average_sortedmakespan);
		System.out.println("--------------------------");
	}
	
	public void WriteFile(int tasknum, int c, String s) {
		
		Random r = new Random();
		int min = 10;
		int max = 180;
		
		for(int i=1; i<=10; i++) {
			
		    int ci = c + i;
			File f = new File(s+ci+".txt");
			int pronum = (int) Math.sqrt(tasknum);
			
		
			try {
				PrintWriter mw = new PrintWriter(f);
				mw.println(pronum);
				mw.println(tasknum);
				for (int j=1; j<= tasknum; j++) {
					int rnd = r.nextInt(max) + min;
					mw.println(j+" "+rnd);
				}
				mw.close();
			} catch (IOException e) {
				System.out.println("This file doesn't exist");
		}
		}
		
		
	}
	
}