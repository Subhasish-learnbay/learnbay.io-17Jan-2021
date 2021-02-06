package warmup_sessions.set1;

public class JewelsAndStones {
	//T.C - O(Max(sizeOf(jewels), sizeOf(stones))), S.C - O(1)
	public int numJewelsInStones(String jewels, String stones) {
		boolean[] small = new boolean[26];
		boolean[] caps = new boolean[26];
		for (int i = 0; i < jewels.length(); i++) {
			if (jewels.charAt(i) >= 'a' && jewels.charAt(i) <= 'z')
				small[jewels.charAt(i) - 'a'] = true;
			else
				caps[jewels.charAt(i) - 'A'] = true;
		}
		int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			if (stones.charAt(i) >= 'a' && stones.charAt(i) <= 'z') {
				if (small[stones.charAt(i) - 'a'])
					count++;
			} else {
				if (caps[stones.charAt(i) - 'A'])
					count++;
			}
		}
		return count;
	}
}
