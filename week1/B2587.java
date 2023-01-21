package week1;

import java.util.Arrays;
import java.util.Scanner;

class B2587 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];
        append(numbers, scanner);

        System.out.println(getAverage(numbers));
        System.out.println(getMedian(numbers));
    }

    static void append(int[] arrayNum, Scanner scanner){
        for (int i=0; i<arrayNum.length; i++) {
            arrayNum[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    static int getAverage(int[] numbers) {
        int total = 0;
        for (int i=0; i<numbers.length; i++) {
            total += numbers[i];
        }

        return total / numbers.length;
    }

    static int getMedian(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[2];
    }
}