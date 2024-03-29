package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solving_7949_JumpGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        long[] dp = new long[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = Math.max(1, i - arr[i]); j < i; j++) {
                dp[i] += dp[j];
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
