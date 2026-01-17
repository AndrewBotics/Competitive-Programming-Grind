// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class FactoryMachines {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());
		double[] machines = new double[n];
		double perSecond = 0;
		for (int i = 0; i<n; i++){
			machines[i] = 1.0/Integer.parseInt(st.nextToken());
			perSecond += machines[i];
		}

		long curr = (long) Math.ceil(t/perSecond);
		while (!works(curr, t, machines)){
			curr++;
		}
		System.out.println(curr);

		//System.out.println(perSecond);
		//System.out.println(Arrays.toString(machines));
	}
	public static boolean works(long curr, long t, double[] machines){
		long sum = 0;
		for (double m : machines) sum += (long) Math.floor(curr*m);
		return sum>=t;
	}
}
