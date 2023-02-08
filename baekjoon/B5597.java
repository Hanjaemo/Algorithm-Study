package baekjoon;

import java.util.Scanner;

class B5597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[] students = new boolean[31];

        for (int i=1; i<=28; i++) {
            int success = scanner.nextInt();
            students[success] = true;
        }

        for (int i=1; i<=30; i++) {
            if (!students[i]) {
                System.out.println(i);
            }
        }
    }
}
