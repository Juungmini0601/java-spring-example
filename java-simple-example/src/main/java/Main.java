import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0,1,2 로만 이루어진 N * N 격자
 * 0초에 K개의 상한 귤로부터 시작하여 1초에 한 번씩 모든 상한 귤로부터 인접한 곳에 있는 귤이 동시에 전부상한다.
 * 각 귤마다 최초로 상하게 되는 시간을 구하는 프로그램을 작성해라.
 *
 * 숫자 0: 비어 있음
 * 1: 귤이 있음
 * 2: 해당 칸에 상한 귤이 있음
 */
public class Main {

	public static int n, k;
	public static int[][] map;
	public static int[][] distance;

	public static final int EMPTY = 0;
	public static final int ORANGE = 1;
	public static final int SPOILED_ORANGE = 2;
	// 상 우 하 좌
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static Queue<Pos> q = new ArrayDeque<>();

	public static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		BFS();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == EMPTY) {
					System.out.print(-1 + " ");
				} else {
					if (distance[i][j] == 0) {
						System.out.print(-2 + " ");
					} else {
						System.out.print((distance[i][j] - 1) + " ");
					}
				}
			}
			System.out.println();
		}
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (!inRange(nx, ny))
					continue;
				if (map[nx][ny] != ORANGE)
					continue;
				if (distance[nx][ny] != 0)
					continue;

				// 오렌지이면서 아직 방문이 안된 경우이다.
				distance[nx][ny] = distance[cur.x][cur.y] + 1;
				q.add(new Pos(nx, ny));
			}
		}
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		distance = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == SPOILED_ORANGE) {
					q.add(new Pos(i, j));
					distance[i][j] = 1;
				}
			}
		}
	}
}
