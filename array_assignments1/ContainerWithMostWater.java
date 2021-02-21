package array.assignment1;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int low = 0, high = height.length - 1;
		while (low < high) {
			max = Math.max(max, (high - low) * Math.min(height[low], height[high]));
			if (height[low] < height[high]) {
				low++;
			} else
				high--;
		}
		return max;
	}
}
