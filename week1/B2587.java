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

    /**
     * 배열의 길이만큼 숫자를 입력받고 배열에 저장한다.
     * @param arrayNum
     * @param scanner
     */
    static void append(int[] arrayNum, Scanner scanner){
        for (int i=0; i<arrayNum.length; i++) {
            arrayNum[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    /**
     * 배열의 요소들의 평균을 반환한다.
     * @param numbers
     * @return 배열의 모든 요소의 평균
     */
    static int getAverage(int[] numbers) {
        int total = 0;
        for (int i=0; i<numbers.length; i++) {
            total += numbers[i];
        }

        return total / numbers.length;
    }

    /**
     * 배열을 정렬하고, 중앙값을 반환한다.
     * @param numbers
     * @return 배열의 중앙에 있는 요소
     */
    static int getMedian(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[2];
    }
}