import java.io.*;
import java.util.*;

public class sleepinginclass {
	public static void main(String[] args) throws IOException {
		BufferedReader read =
		    new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(read.readLine());
		for (int t = 0; t < testNum; t++) {
			int n = Integer.parseInt(read.readLine());
			int[] elsieLog = new int[n];
			int logSum = 0;
			StringTokenizer logST = new StringTokenizer(read.readLine());
			for (int i = 0; i < n; i++) {
				elsieLog[i] = Integer.parseInt(logST.nextToken());
				logSum += elsieLog[i];
			}

			// Try all possible number of hours after modification
			for (int numHours = 0; numHours <= logSum; numHours++) {
				if (numHours != 0 && logSum % numHours != 0) {
					// The sum must be divisible by numHours
					continue;
				}

				// Check if numHours leads to a valid answer
				int currSum = 0;  // The current number of hours Elsie's logging
				boolean valid = true;
				for (int h : elsieLog) {
					currSum += h;
					if (currSum > numHours) {
						valid = false;  // curr_sum can't exceed numHours
						break;
					} else if (currSum == numHours) {
						currSum = 0;
					}
				}

				if (valid) {
					if (numHours == 0) {
						// Handle the edge case where numHours is 0
						System.out.println(0);
					} else {
						// sum/numHours is the total # of classes AFTER
						// modifying
						System.out.println(n - logSum / numHours);
					}
					break;
				}
			}
		}
	}
}