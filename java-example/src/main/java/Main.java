import java.util.Scanner;

public class Main {

	public static int n;
	public static int m;
	public static int[][] arr;
	public static int[][] dp;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				find(i, j);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}

		System.out.println(ans);
	}

	public static void find(int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dp[i][j] == Integer.MIN_VALUE) {
					continue;
				}

				if (arr[i][j] < arr[row][col]) {
					dp[row][col] = Math.max(dp[row][col], dp[i][j] + 1);
				}
			}
		}
	}

	public static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
	}
}