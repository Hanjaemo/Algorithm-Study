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

    /**
     * 숫자를 입력 받아서 배열에 저장하고, 배열을 반환한다.
     * @param arrLength 배열의 길이
     * @return 입력 받은 숫자들이 저장된 배열
     */
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

    /**
     * numbers의 요소 두개를 더해서 list에 저장한다. 이때 중복을 허용하지 않는다.
     * @param numbers 입력 받은 숫자들이 저장된 배열
     */
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

    /**
     * list의 요소를 answer 배열에 저장하여 정렬 후, 배열을 출력한다.
     */
    public void printAnswer() {
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
    }

    /**
     * num이 list에 포함되어 있는지 확인한다.
     * @param num
     * @return
     */
    public boolean contains(int num) {
        return list.contains(num);
    }
}