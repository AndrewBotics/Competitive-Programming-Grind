import java.util.*;

public class Code {
    public static void main(String[] args){
        double avg = 0;
        double prev = 1;
        for (double i = 2; i<=20; i++){
            prev = 0.5*prev+54.051904/(2*prev);
        }
        System.out.println(prev);
    }
}
