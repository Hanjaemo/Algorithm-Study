package baekjoon;

import java.util.Scanner;

class B2438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        if (invalidInput(N)) return;

        for (int i=1; i<=N; i++) {
            for (int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static boolean invalidInput(int input) {
        return !(1 <= input && input <= 100);
    }
}