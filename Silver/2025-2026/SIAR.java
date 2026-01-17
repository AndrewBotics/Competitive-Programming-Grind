// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SIAR {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        List<Cow> norths = new ArrayList<>();
        List<Cow> easts = new ArrayList<>();
        for (int i = 0; i<n; i++){
            if (s.next().equals("N")) norths.add(new Cow(s.nextInt(), s.nextInt(), i));
            else easts.add(new Cow(s.nextInt(), s.nextInt(), i));
        }
        //pw.println(norths);
        //pw.println(easts);

        norths.sort(Comparator.comparingInt(j->j.x));
        easts.sort(Comparator.comparingInt(j->j.y));

        boolean[] stopped = new boolean[n];
        int[] amountStopped = new int[n];
        for (Cow no : norths){
            for (Cow ea : easts){
                if (!stopped[ea.id] && (!stopped[no.id]) && (no.x>ea.x) && (ea.y>no.y)){
                    if (no.x-ea.x>ea.y-no.y) {
                        stopped[ea.id] = true;
                        amountStopped[no.id] += (1+amountStopped[ea.id]);
                    }
                    else if (no.x-ea.x<ea.y-no.y){
                        stopped[no.id] = true;
                        amountStopped[ea.id] += (1+amountStopped[no.id]);
                    }
                }
            }
        }
        for (int i = 0; i<n; i++) pw.println(amountStopped[i]);
        pw.close();
	}
    static class Cow {
        public int x;
        public int y;
        public int id;

        public Cow(int a, int b, int id){
            x = a;
            y = b;
            this.id = id;
        }

        public String toString(){
            return x+"-"+y;
        }
    }
}
