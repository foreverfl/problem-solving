package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02869_PUZ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		int day = (length - down) / (up - down);

		if ((length - down) % (up - down) != 0) { // if there is the remainder
			day++;
		}
		System.out.println(day);
	}
}
