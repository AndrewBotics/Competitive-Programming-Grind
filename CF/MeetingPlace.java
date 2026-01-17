import java.util.*;

public class MeetingPlace {
	static final double MAX_ERROR = 10e-7;

	static List<Double> locations = new ArrayList<>();
	static List<Double> speeds = new ArrayList<>();

	static double min_ans = Double.MAX_VALUE;
	static double curr_min_time;
	static boolean left_has_max = false;  // which side gives us max answer
	static boolean right_has_max = false;

	/**
	 * Checks whether all friends can converge on one point in the specified
	 * time interval.
	 */
	public static double get_time(double loc) {
		double max_time = 0;
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i) == loc) { continue; }
			double i_time = Math.abs(locations.get(i) - loc) / speeds.get(i);
			if (i_time > max_time) {
				// reset to false, as we have a new maximum
				left_has_max = false;
				right_has_max = false;
				if (locations.get(i) > loc) {
					right_has_max = true;
				} else {
					left_has_max = true;
				}
				max_time = i_time;
			} else if (i_time == max_time) {
				// The max can be from both sides, so we don't reset the 2
				// booleans
				if (locations.get(i) > loc) {
					right_has_max = true;
				} else {
					left_has_max = true;
				}
			}
		}
		return max_time;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double low = 0;
		double high = 0;  // location of the farthest north friend

		for (int i = 0; i < n; i++) {
			double location = scanner.nextDouble();
			locations.add(location);
			high = Math.max(high, location);
		}

		for (int i = 0; i < n; i++) { speeds.add(scanner.nextDouble()); }

		// Binary search is used to find the minimum time.
		while (high - low > MAX_ERROR) {
			double mid = (high + low) / 2;
			curr_min_time = get_time(mid);
			min_ans = Math.min(min_ans, curr_min_time);
			if (left_has_max && right_has_max) {
				break;
			} else if (left_has_max) {
				high = mid;
			} else {
				low = mid;
			}
		}

		System.out.printf("%.10f%n", min_ans);
	}
}