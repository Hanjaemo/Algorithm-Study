package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class PickTwoAddThem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int arrLength = new Scanner(System.in).nextInt();
        int[] numbers = input(arrLength);

        solution.add(numbers);
        solution.printAnswer();

    }

    public static int[] input(int arrLength) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }
}

class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void add(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if (!contains(num)) {
                    list.add(num);
                }
            }
        }
    }

    public void printAnswer() {
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
    }

    public boolean contains(int num) {
        return list.contains(num);
    }
}