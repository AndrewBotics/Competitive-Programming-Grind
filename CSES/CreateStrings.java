import java.util.*;

public class CreateStrings {
    static Set<String> solve(String S) {
        int N = S.length();
        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        Set<String> uniqueStrings = new HashSet<>();
        
        do {
            uniqueStrings.add(new String(charArray));
        } while (nextPermutation(charArray));
        
        return uniqueStrings;
    }

    static boolean nextPermutation(char[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        reverse(array, i + 1, array.length - 1);

        return true;
    }

    static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> uniqueStrings = solve(s.next());
        List<String> alph = new ArrayList<>();
        for (String x : uniqueStrings) alph.add(x); 
        Collections.sort(alph);

        System.out.println(alph.size());
        for (String str : alph) {
            System.out.println(str);
        }
    }
}
