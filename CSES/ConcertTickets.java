import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcertTickets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		TreeMap<Integer, Integer> tickets = customTreeIntegers(br.readLine());
		//System.out.println(tickets.toString());

		for(int i : customArrayIntegers(br.readLine(), m)){
			Integer ticketprice = tickets.floorKey(i);
			if(ticketprice != null){
				pw.println(ticketprice);
				if(tickets.get(ticketprice) == 1) tickets.remove(ticketprice);
				else tickets.put(ticketprice, tickets.get(ticketprice) - 1);
			}
			else pw.println(-1);
		}

		pw.close();
	}
	public static int[] customArrayIntegers(String input, int size) {
		int[] nums = new int[size];
		int n = 0;
		int ind = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == ' ') {
				nums[ind] = n;
				ind++;
				n = 0;
			}
			else n = n * 10 + (c - '0');
		}
		nums[ind] = n;
		return nums;
	}

	public static TreeMap<Integer, Integer> customTreeIntegers(String input) {
		TreeMap<Integer, Integer> ret = new TreeMap<>();
		int n = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == ' ') {
				ret.put(n, ret.getOrDefault(n, 0) + 1);
				n = 0;
			}
			else n = n * 10 + (c - '0');
		}
		ret.put(n, ret.getOrDefault(n, 0) + 1);
		return ret;
	}
}