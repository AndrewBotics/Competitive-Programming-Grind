import java.util.*;
import java.io.*;

public class PowerProds {
    public static int k;

    public static class PrimePair {
        int prime, exp;
        PrimePair(int prime, int exp) {
            this.prime = prime;
            this.exp = exp;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof PrimePair)) return false;
            PrimePair other = (PrimePair) obj;
            return prime == other.prime && exp == other.exp;
        }
        @Override
        public int hashCode() {
            return Objects.hash(prime, exp);
        }
    }

    static List<PrimePair> factor(int number) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                number /= i;
                factors.put(i, factors.getOrDefault(i, 0) + 1);
            }
        }
        if (number > 1) factors.put(number, factors.getOrDefault(number, 0) + 1);

        List<PrimePair> primeFactorization = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
            int modExp = entry.getValue() % k;
            if (modExp > 0) {
                primeFactorization.add(new PrimePair(entry.getKey(), modExp));
            }
        }
        primeFactorization.sort(Comparator.comparingInt(p -> p.prime));
        return primeFactorization;
    }

    static List<PrimePair> findFactorInverse(List<PrimePair> original) {
        List<PrimePair> inverse = new ArrayList<>();
        for (PrimePair p : original) {
            inverse.add(new PrimePair(p.prime, k - p.exp));
        }
        return inverse;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = s.nextInt();
        k = s.nextInt();

        Map<List<PrimePair>, Integer> factorFrequency = new HashMap<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            List<PrimePair> f = factor(arr[i]);
            factorFrequency.put(f, factorFrequency.getOrDefault(f, 0) + 1);
        }

        long ret = 0;
        for (int i = 0; i < n; i++) {
            List<PrimePair> f = factor(arr[i]);
            List<PrimePair> inv = findFactorInverse(f);

            if (f.equals(inv)) ret += factorFrequency.getOrDefault(f, 0) - 1;
            else ret += factorFrequency.getOrDefault(inv, 0);
        }

        pw.println(ret / 2);
        pw.close();
    }
}
