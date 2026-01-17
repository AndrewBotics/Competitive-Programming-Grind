// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class ReplaceTheNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());
        Stack<Event> evs = new Stack<>();
        for (int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x==1) {
                evs.add(new Event(Integer.parseInt(st.nextToken())));
            }
            else {
                evs.add(new Event(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        }
        //pw.println(evs);

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = n; i>0; i--){
            Event ev = evs.pop();
            if (ev.type==2){
                map.put(ev.changeFrom, map.getOrDefault(ev.changeTo, ev.changeTo));
            }
            else arr.add(map.getOrDefault(ev.valueOf, ev.valueOf));
        }

        //pw.println(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.size()-1; i>=0; i--){
            sb.append(arr.get(i)).append(" ");
        }
        pw.println(sb);

		pw.close();
	}
    static class Event {
        int type;
        int valueOf;
        int changeFrom;
        int changeTo;

        public Event(int cf, int ct){
            type = 2;
            changeFrom = cf;
            changeTo = ct;
        }
        public Event(int v){
            type = 1;
            valueOf = v;
        }

        public String toString(){
            if (type==1) return valueOf+"";
            else return changeFrom+" "+changeTo;
        }
    }
}
