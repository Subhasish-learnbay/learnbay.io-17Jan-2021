package heap.assignment1;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		String res = "";
		int[] freq = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freq[c] += 1;
		}
		String str = printMax(freq);
		res += str;
		while (!str.equals("")) {
			str = printMax(freq);
			res += str;
		}
		return res;
	}

	String printMax(int[] freq) {
		String res = "";
		int max = 0;
		char c = ' ';
		for (int i = 0; i < 128; i++) {
			if (freq[i] > max) {
				max = freq[i];
				c = (char) i;
			}
		}
		if (max == 0)
			return "";
		else {
			while (max-- > 0)
				res += c + "";
			freq[c] = 0;
			return res;
		}
	}
}
