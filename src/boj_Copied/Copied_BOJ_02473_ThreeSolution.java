package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02473_ThreeSolution {
	
	static long[] pick = new long[3];
	static long max = 3000000000L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());

		Arrays.sort(arr);

		for (int i = 0; i < N - 2; i++)
			solution(arr, i);

		Arrays.sort(pick);

		for (int i = 0; i < 3; i++)
			System.out.print(pick[i] + " ");
	}

	static void solution(long[] arr, int index) {
		int left = index + 1;
		int right = arr.length - 1;

		while (left < right) {

			long sum = arr[left] + arr[right] + arr[index];
			long absSum = Math.abs(sum);

			// 두 용액 갱신
			if (absSum < max) {
				pick[0] = arr[left];
				pick[1] = arr[right];
				pick[2] = arr[index];
				max = absSum;
			}

			if (sum > 0)
				right--;
			else
				left++;
		}
	}
}

// reference: https://bcp0109.tistory.com/56