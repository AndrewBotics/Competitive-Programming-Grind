// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class MooRouteII {
    static class Flight {
        public int dest;
        public int start;
        public int end;
        
        public Flight(int s, int d, int e){
            dest = d;
            start = s;
            end = e;
        }

        public String toString(){
            return dest+": "+start+"-"+end;
        }
    }
    public static List<Flight>[] flights;
    public static int[] mins;
    public static HashSet<Integer>[] traversed;
    public static int[] layovers;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int m = s.nextInt();
        flights = new ArrayList[n+1];
        layovers = new int[n+1];
        for (int i = 1; i<=n; i++) {
            flights[i] = new ArrayList<>();
        }
        for (int i = 0; i<m; i++){
            flights[s.nextInt()].add(new Flight(s.nextInt(), s.nextInt(), s.nextInt()));
        }
        for (int i = 1; i<=n; i++) layovers[i] = s.nextInt();
        
        //pw.println(Arrays.toString(flights));

        mins = new int[n+1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        traversed = new HashSet[n+1];
        for (int i = 1; i<=n; i++) traversed[i] = new HashSet<>();
        search(1, 0, true);

        //pw.println(Arrays.toString(mins));
        for (int i = 1; i<=n; i++) pw.println(mins[i]==Integer.MAX_VALUE?-1:mins[i]);
		pw.close();
	}

    //Initial method signature
    public static void search(int loc, int time, boolean b){
        traversed[loc].add(time);
        mins[loc] = 0;
        for (Flight f : flights[loc]) if (f.start>=time) search(f.dest, f.end);
    }

    //Following method signature
    public static void search(int loc, int time){
        if (traversed[loc].contains(time)) return;
        traversed[loc].add(time);
        mins[loc] = Math.min(mins[loc], time);
        //System.out.println("HI "+mins[loc]+" "+time);
        for (Flight f : flights[loc]) if (f.start>=time+layovers[loc]) search(f.dest, f.end);
    }
}
