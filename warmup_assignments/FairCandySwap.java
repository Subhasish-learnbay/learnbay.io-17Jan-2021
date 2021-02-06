package warmup_sessions.set1;

public class FairCandySwap {
	public static void main(String[] args) {
		int[] A = { 1, 1 };
		int[] B = { 2, 2 };
		int[] res = fairCandySwap(A, B);
		System.out.println(res[0] + " " + res[1]);
	}

	static int[] fairCandySwap(int[] A, int[] B) {
		int aSum = 0, bSum = 0;
		for (int val : A)
			aSum += val;
		for (int val : B)
			bSum += val;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (aSum - A[i] + B[j] == bSum - B[j] + A[i])
					return new int[] { A[i], B[j] };
			}
		}
		return new int[] { -1, -1 };
	}
}
