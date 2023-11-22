package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solving_7914_MakingTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sticks = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(sticks);
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            makeStickList(sticks, visited, i, new ArrayList<>());
        }
    }

    public static boolean makeStickList(int[] sticks, boolean[] visited, int size, List<Integer> now) {
        if (now.size() == size) {
            System.out.println(now);
        }

        for (int i = 0; i < sticks.length; i++) {
            if (!visited[i]) {

            }
        }

        return true;

    }

    public static boolean canMakeTriangle(int[] sticks) {
        int len = sticks.length;

        for (int i = 0; i <= len - 3; i++) {
            for (int j = i + 1; j <= len - 2; j++) {
                for (int k = j + 1; k <= len - 1; k++) {
                    if (!isTriangle(sticks[i], sticks[j], sticks[k])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

}