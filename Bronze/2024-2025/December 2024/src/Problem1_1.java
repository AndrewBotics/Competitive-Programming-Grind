import java.util.Scanner;

public class Problem1_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long t = s.nextLong();
        for (long i = 0; i<t; i++){
            long x = s.nextInt();
            long ret = 0;
            long half = 50;
            long minus = 5;
            while (x>=half-minus){
                ret += Math.max(0, Math.min(x-half+minus+1, minus));
                //System.out.println(half+" "+minus+" "+ret);
                minus += half;
                half *= 10;
            }
            System.out.println(ret);
        }
    }
}
