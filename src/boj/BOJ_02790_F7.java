package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_02790_F7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int score = arr[0] + 1; // the last score
		int ans = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] + N >= score)
				ans++;

			score = Math.max(score, arr[i] + i + 1);
		}

		System.out.println(ans);
	}
}

// reference: https://ariz1623.tistory.com/116