import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] arr;
	public static int[][] maxDp; // 경로상 최대 값이 최소가 되는 경우

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		input();

		maxDp[1][1] = arr[1][1];

		// 1열 채우기
		for (int i = 2; i <= n; i++) {
			maxDp[1][i] = Math.max(maxDp[1][i - 1], arr[1][i]);
		}

		// 2열부터 끝까지 채우기
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 1) {
					maxDp[i][j] = Math.max(maxDp[i - 1][j], arr[i][j]);
					continue;
				}

				// 최대값 고르기
				maxDp[i][j] = arr[i][j];
				// 이전 최대 값 중 최소 값 선택
				int temp = Math.min(maxDp[i][j - 1], maxDp[i - 1][j]);
				maxDp[i][j] = Math.max(maxDp[i][j], temp);
			}
		}

		System.out.println(maxDp[n][n]);

	}

	public static void input() {
		n = sc.nextInt();
		arr = new int[n + 1][n + 1];
		maxDp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}
}