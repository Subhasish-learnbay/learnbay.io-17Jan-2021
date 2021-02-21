package array.assignment1;

public class BestTimeToBuyAndSell {
	public int maxProfit(int[] prices) {
		int min = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - min > maxProfit)
				maxProfit = prices[i] - min;
			min = Math.min(min, prices[i]);
		}
		return maxProfit;
	}
}
