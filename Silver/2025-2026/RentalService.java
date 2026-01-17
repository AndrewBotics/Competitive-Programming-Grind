// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class RentalService {
	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(System.in);
        //PrintWriter pw = new PrintWriter(System.out);
        Scanner s = new Scanner(new File("rental.in"));
        PrintWriter pw = new PrintWriter("rental.out");

        int n = s.nextInt();
        int m = s.nextInt();
        int r = s.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i<n; i++){
            cows[i] = s.nextInt();
        }
        Store[] stores = new Store[m];
        for (int i = 0; i<m; i++){
            stores[i] = new Store(s.nextInt(), s.nextInt());
        }
        int[] rent = new int[r];
        for (int i = 0; i<r; i++) rent[i] = s.nextInt();

        Arrays.sort(cows);
        for (int i = 0; i<n/2; i++){
            int temp = cows[i];
            cows[i] = cows[cows.length-i-1];
            cows[cows.length-i-1] = temp;
        }
        Arrays.sort(stores, Comparator.comparingInt(st -> - st.price));
        Arrays.sort(rent);
        for (int i = 0; i<n/2; i++){
            int temp = rent[i];
            rent[i] = rent[rent.length-i-1];
            rent[rent.length-i-1] = temp;
        }

        int sInd = 0;
        int rInd = 0;
        int cInd = 0;
        long maxMoney = 0;
        while (cInd<n){
            int amt = cows[cInd];
            int soldMoney = 0;
            int currShop = sInd;
            int last = 0;
            while (currShop<m){
                int sold = Math.min(amt, stores[currShop].amt);
                soldMoney += stores[currShop].price * sold;
                amt -= sold;
                if (amt==0){
                    last = sold;
                    break;
                }
                else currShop++;
            }
            if (rInd>=r || soldMoney>rent[rInd]){
                maxMoney += soldMoney;
                sInd = currShop;
                if (sInd<m) stores[sInd].amt -= last;
                cInd++;
            } else {
                maxMoney += rent[rInd];
                n--;
                rInd++;
            }
        }

        pw.println(maxMoney);
        pw.close();

		pw.close();
	}
    public static class Store{
        public int price;
        public int amt;
        public Store(int amt, int price){
            this.amt = amt;
            this.price = price;
        }
    }
}
