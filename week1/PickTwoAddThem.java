package week1;

import java.util.ArrayList;
import java.util.Arrays;

public class PickTwoAddThem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers = {2, 1, 4, 5, 1};

        System.out.println(Arrays.toString(solution.solution(numbers)));
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if (list.indexOf(num) == -1) {
                    list.add(num);

                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}