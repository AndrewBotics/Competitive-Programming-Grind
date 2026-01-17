import java.util.*;
public class BitStrings {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long ans = 1;
        long MOD = 1000000007;
        long base = 2;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            n >>= 1;
        }
        System.out.println(ans);
    }
}