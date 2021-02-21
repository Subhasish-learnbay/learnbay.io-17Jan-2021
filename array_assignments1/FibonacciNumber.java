package array.assignment1;

public class FibonacciNumber {
	public int fib(int n) {
		if (n == 0 || n == 1)
			return n;
		int num1 = 0, num2 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = num1 + num2;
			num1 = num2;
			num2 = temp;
		}
		return num2;
	}
}
