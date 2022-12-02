package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_14888_EmbeddingOperators {

	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	public static int[] operator = new int[4];
	public static int[] operand;
	public static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		operand = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(operand[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);

	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (operator[i] > 0) {

				operator[i]--;

				switch (i) {

				case 0:
					dfs(num + operand[idx], idx + 1);
					break;
				case 1:
					dfs(num - operand[idx], idx + 1);
					break;
				case 2:
					dfs(num * operand[idx], idx + 1);
					break;
				case 3:
					dfs(num / operand[idx], idx + 1);
					break;
				}

				operator[i]++;
			}
		}
	}

}

// reference: https://st-lab.tistory.com/121