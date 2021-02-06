package warmup_sessions.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		ArrayList<List<Integer>> res = new ArrayList<>();
		int diff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) < diff)
				diff = Math.abs(arr[i] - arr[i - 1]);
		}
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) == diff) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i - 1]);
				list.add(arr[i]);
				res.add(list);
			}

		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3 };
		List<List<Integer>> res = minimumAbsDifference(arr);
		for (List<Integer> r : res)
			System.out.println(r);
	}
}
