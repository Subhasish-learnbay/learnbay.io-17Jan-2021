package array.assignment1;

import java.util.ArrayList;
import java.util.List;

public class FindCommoncharacters {
	public List<String> commonChars(String[] A) {
		List<String> res = new ArrayList<>();
		int[][] count = new int[A.length][26];
		for (int i = 0; i < A.length; i++) {
			String str = A[i];
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				count[i][ch - 'a'] += 1;
			}
		}
		for (int i = 0; i < 26; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < A.length; j++) {
				if (count[j][i] < min)
					min = count[j][i];
			}
			while (min-- > 0)
				res.add(((char) ('a' + i)) + "");
		}
		return res;
	}
}
