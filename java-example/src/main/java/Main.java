import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static int n;
	public static Map<String, Integer> map = new HashMap<>();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		int max = 0;

		for (int i = 0; i < n; i++) {
			String key = sc.nextLine();
			int value = map.getOrDefault(key, 0);
			value++;

			max = Math.max(max, value);
			map.put(key, value);
		}

		System.out.println(max);
	}
}