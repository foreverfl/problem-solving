package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02753_LeapYear {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());

		if (a % 4 == 0) {
			if (a % 100 != 0 || a % 400 == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else {
			System.out.println(0);
		}
	}

}
