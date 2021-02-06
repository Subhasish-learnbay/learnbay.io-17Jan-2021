package warmup_sessions.set1;

public class RunningSum {
	//T.C - O(N), S.C - O(N)
	public int[] runningSum(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = nums[0];
		for (int i = 1; i < res.length; i++)
			res[i] = res[i - 1] + nums[i];
		return res;
	}
}
