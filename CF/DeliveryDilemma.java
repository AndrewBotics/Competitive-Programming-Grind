import java.io.*;
import java.util.*;

public class DeliveryDilemma {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            Restaurant[] r = new Restaurant[n];
            for (int i = 0; i<n; i++){
                r[i] = new Restaurant(s.nextInt());
            }
            for (int i = 0; i<n; i++){
                r[i].setB(s.nextInt());
            }
            //Arrays.sort(r);
            long min = 0;
            List<Restaurant> list = new ArrayList<>();
            for (Restaurant rr : r){
                if (rr.toCompare<=0) min = Math.max(min, rr.a);
                else list.add(rr);
            }
            //pw.println(min+" "+list);

            long lo = min;
            long hi = Long.MAX_VALUE/2;
            while (lo<hi){
                long mid = (lo+hi)/2L;
                if (works(mid, list)) hi = mid;
                else lo = mid+1;
                //pw.println(lo+" "+hi);
            }
            pw.println(lo);
        }
		pw.close();
    }
    public static boolean works(long mid, List<Restaurant> list){
        long curr = 0;
        for (Restaurant r : list){
            if (r.a>mid) curr += r.b;
            if (curr>mid) return false;
        }
        return true;
    }
    static class Restaurant implements Comparable<Restaurant> {
        public int a;
        public int b;

        public int toCompare;
        
        public Restaurant(int a){
            this.a = a;
        }

        public void setB(int b){
            this.b = b;
            toCompare = a-b;
        }

        @Override
        public int compareTo(Restaurant r){
            return r.toCompare-toCompare;
        }

        public String toString(){
            return a+","+b;
        }
    }
}
