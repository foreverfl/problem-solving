package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Copied_BOJ_14503_RobotCleaner {

	private static int N, M;
	private static int[][] map;
	private static int cnt = 0;
	private static int[] dr = { -1, 0, 1, 0 }; // 북,동,남,서
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r, c, d);

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}

	private static void clean(int row, int col, int direction) {
		// 1. 현재 위치를 청소한다.
		if (map[row][col] == 0) {
			map[row][col] = 2;
			cnt++;
		}

		// 2. 왼쪽방향부터 차례대로 탐색을 진행한다.
		boolean flag = false;
		int origin = direction;
		for (int i = 0; i < 4; i++) {
			// 왼쪽 방향부터 차례대로 탐색
			int next_d = (direction + 3) % 4;
			int next_r = row + dr[next_d];
			int next_c = col + dc[next_d];

			if (next_r > 0 && next_c > 0 && next_r < N && next_c < M) {
				// 아직 청소하지 않은 공간이라면
				if (map[next_r][next_c] == 0) {
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			direction = (direction + 3) % 4;
		}

		// 네 방향 모두 청소가 되어있거나 벽인 경우 -> 후진
		if (!flag) {
			int next_d = (origin + 2) % 4;
			int next_br = row + dr[next_d];
			int next_bc = col + dc[next_d];

			if (next_br > 0 && next_bc > 0 && next_br < N && next_bc < M) {
				if (map[next_br][next_bc] != 1) {
					// 바라보는 방향 유지한 채 후진
					clean(next_br, next_bc, origin);
				}
			}
		}
	}

}

// reference: https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-14503-%EB%A1%9C%EB%B4%87-%EC%B2%AD%EC%86%8C%EA%B8%B0-java
