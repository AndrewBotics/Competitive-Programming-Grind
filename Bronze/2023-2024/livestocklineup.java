// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class livestocklineup {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("lineup.in"));
		PrintWriter pw = new PrintWriter(new File("lineup.out"));
		int n = s.nextInt();
		List<String>[] orders = new ArrayList[8];
		for (int i = 0; i<8; i++) orders[i] = new ArrayList<>();
		for (int i = 0; i<n; i++){
			orders[i].add(s.next());
			for (int j = 0; j<4; j++) s.next();
			orders[i].add(s.next());
		}
		boolean going = true;
		while (going){
			List<String>[] compares = new ArrayList[8];
			for (int i = 0; i<8; i++) compares[i] = orders[i];
			
			for (int i = 0; i<8; i++){
				if (orders[i].size() != 0){
					String first = orders[i].get(0);
					String last = orders[i].get(orders[i].size()-1);
					boolean searching = true;
					for (int j = 0; j<8 && searching; j++){
						if (i!=j){
							if (orders[j].contains(first)){
								if (first.equals(orders[j].get(0))){
									Collections.reverse(orders[i]);
									orders[j].remove(0);
									orders[i].addAll(orders[j]);
									orders[j] = new ArrayList<>();
								}
								else {
									orders[i].remove(0);
									orders[j].addAll(orders[i]);
									orders[i] = new ArrayList<>();
								}
								searching = false;
							}
							else if (orders[j].contains(last)){
								if (last.equals(orders[j].get(0))){
									orders[j].remove(0);
									orders[i].addAll(orders[j]);
									orders[j] = new ArrayList<>();
								}
								else {
									Collections.reverse(orders[j]);
									orders[j].remove(0);
									orders[i].addAll(orders[j]);
									orders[j] = new ArrayList<>();
								}
								searching = false;
							}
						}
					}
				}
			}

			boolean temp = true;
			for (int i = 0; i<8; i++){
				if (compares[i]!=orders[i]) temp = false;
			}
			if (temp) going = false;
		}
		List<String> cows = Arrays.asList("Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue");
		for (int i = 0; i<8; i++){
			if (orders[i].size()!=0){
				if (cows.indexOf(orders[i].get(0)) > cows.indexOf(orders[i].get(orders[i].size()-1))) Collections.reverse(orders[i]);
				for (String c : orders[i]){
					if (c!=orders[i].get(0)) cows.set(cows.indexOf(c), "-");
				}
			}
		}
		for (int i = 0; i<8; i++){
			if (!cows.get(i).equals("-")) pw.println(cows.get(i));
			for (int j = 0; j<8; j++){
				if (orders[j].size()!=0){
					if (orders[j].get(0).equals(cows.get(i))){
						for (String k : orders[j]){
							if (k != orders[j].get(0)) pw.println(k);
						}
					}
				}
			}
		}
		//pw.println(Arrays.toString(orders));
		//pw.println(cows);
		pw.close();
	}
}
