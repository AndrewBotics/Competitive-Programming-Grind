import java.util.*;
import java.io.*;

public class cowevolution {
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("evolution.in");
		PrintWriter pw = new PrintWriter("evolution.out");
		Scanner sc = new Scanner(f);
		int subsets = sc.nextInt();
		
		ArrayList<ArrayList<String>> populations = new ArrayList<ArrayList<String>>();
		ArrayList<String> characteristics = new ArrayList<String>();
		
		for(int i = 0; i < subsets; i++) {
			ArrayList<String> a = new ArrayList<String>();
			int n = sc.nextInt();
			for(int j = 0; j < n; j++) a.add(sc.next());
			populations.add(a);
		}
		//System.out.println(populations);
		
		//making list of characteristics
		for(int i = 0; i < populations.size(); i++) {
			for(int j = 0; j < populations.get(i).size(); j++) {
				boolean there = false;
				for(int k = 0; k < characteristics.size(); k++) {
					if(characteristics.get(k).equals(populations.get(i).get(j))) {
						there = true;
						break;
					}
				}
				if(!there) characteristics.add(populations.get(i).get(j));
			}
		}
		//System.out.println(characteristics);
		
		//check to see if works or not
		boolean works = true;
		for(int i = 0; i < characteristics.size(); i++) {
			for(int j = i + 1; j < characteristics.size(); j++) {
				String c1 = characteristics.get(i), c2 = characteristics.get(j);
				boolean c1alone = false, c2alone = false, c1c2 = false;
				
				for(int k = 0; k < populations.size(); k++) {
					boolean c1check = false, c2check = false;
					for(int l = 0; l < populations.get(k).size(); l++) {
						if(populations.get(k).get(l).equals(c1)) c1check = true;
						if(populations.get(k).get(l).equals(c2)) c2check = true;
					}
					if(c1check && !c2check) c1alone = true;
					if(!c1check && c2check) c2alone = true;
					if(c1check && c2check) c1c2 = true;
				}
				if(c1alone && c2alone && c1c2) works = false;
			}
		}
		if(works) pw.println("yes");
		else pw.println("no");
		pw.close();
		sc.close();
	}
}