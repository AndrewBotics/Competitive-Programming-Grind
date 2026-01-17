// Source: https://usaco.guide/general/io

import java.util.*;

public class GrayCode {
    public static List<String> generateGrayCode(int n) {
        if (n == 1) {
            List<String> grayCode = new ArrayList<>();
            grayCode.add("1");
            grayCode.add("0");
            return grayCode;
        }
        List<String> prevGrayCode = generateGrayCode(n - 1);
        List<String> reversedPrevGrayCode = new ArrayList<>(prevGrayCode);
        java.util.Collections.reverse(reversedPrevGrayCode);
        List<String> currentGrayCode = new ArrayList<>(prevGrayCode);       
        for (int i = 0; i < prevGrayCode.size(); i++) {
            currentGrayCode.set(i, "0" + reversedPrevGrayCode.get(i));        
            prevGrayCode.set(i, "1" + prevGrayCode.get(i));
        }
        prevGrayCode.addAll(currentGrayCode);       
        return prevGrayCode;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        List<String> grayCode = generateGrayCode(s.nextInt());
        for (String code : grayCode) {
            System.out.println(code);
        }
    }
}