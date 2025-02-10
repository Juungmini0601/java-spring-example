import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0,1로만 이루어진 N * N 격자가 주어졌을 때, K개의 시작점으로부터 상하좌우 인접한 곳으로만 이동하여 도달 가능한 칸의 수를 출력하시오.
 */
public class Main {

	public static int n, k;
	public static int[][] map;
	public static boolean[][] visited;
	// 상 우 하 좌
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static final int NO_MOVE = 1;
	public static int cnt = 0;

	public static Queue<Pos> q = new ArrayDeque<>();

	public static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		BFS();

		System.out.println(cnt);
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == NO_MOVE)
					continue;

				visited[nx][ny] = true;
				cnt++;
				q.add(new Pos(nx, ny));
			}
		}
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			visited[x][y] = true;
			cnt++;

			q.add(new Pos(x, y));
		}
	}
}
