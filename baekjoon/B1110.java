package baekjoon;

import java.util.*;

class B1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        if (invalidInput(N)) return;

        int cycle = 0;
        int num = N;

        while (true) {
            N = (N % 10 * 10) + ((N / 10 + N % 10) % 10);

            cycle++;

            if (num == N) {
                break;
            }
        }

        System.out.println(cycle);
    }

    public static boolean invalidInput(int input) {
        return !(0 <= input && input <= 99);
    }
}
