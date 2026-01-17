import java.io.*;
import java.util.*;

public class balancingbacteria {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] grass = new long[n];
		long ret = 0;
		for (int i = 0; i<n; i++){
			grass[n-i-1] = s.nextLong();
		}
		//System.out.println(Arrays.toString(grass));
		for (int i = n-1; i>=0; i--){
			while (grass[i]!=0){
				if (grass[i]>0){
					ret += grass[i];
					grass = negspray(grass, i+1, grass[i]);
					//System.out.println(Arrays.toString(grass));
				}
				else if (grass[i]<0){
					ret += grass[i]*-1;
					grass = posspray(grass, i+1, grass[i]*-1);
					//System.out.println(Arrays.toString(grass));
				}
			}
		}
		System.out.println(ret);
	}
	static long[] posspray(long[] grass, int strength, long times){
		int loc = 0;
		for (int i = strength; i>0; i--){
			grass[loc] += i*times;
			loc++;
		}
		return grass;
	}
	static long[] negspray(long[] grass, int strength, long times){
		int loc = 0;
		for (int i = strength; i>0; i--){
			grass[loc] -= i*times;
			loc++;
		}
		return grass;
	}
}