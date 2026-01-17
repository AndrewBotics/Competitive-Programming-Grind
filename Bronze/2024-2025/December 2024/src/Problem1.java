import java.util.*;
public class Problem1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int ind = 1;
        for (int i = 0; i<t; i++){
            int x = s.nextInt();
            int ret = 0;
            for (int j = 0; j<=x; j++){
                ret += isRoundable(j);
            }
            System.out.println(ret);
        }
    }
    public static int isRoundable(double n){
        double n1 = n;
        while (n1>=10) n1/=10;
        if (n1>=1) n1/=10;
        n1 = Math.round(n1);

        double n2 = n;
        while (n2>=10) {
            if (n2%10<5) n2 -= n2%10;
            else n2 += 10-(n2%10);
            n2/=10;
        }
        if (n2>=1) n2/=10;
        n2 = Math.round(n2);

        if (n1==n2 || (Double.toString(n).charAt(0)=='9')) return 0;
        System.out.println((int) n + " " + n1 + " " + n2);
        return 1;
    }
}
