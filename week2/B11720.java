package week2;

import java.util.ArrayList;
import java.util.Scanner;

class B11720 {
    private static Scanner scanner = new Scanner(System.in);
    private static int N;
    private static String S;

    /**
     * logic
     * 1. 입력 받을 숫자의 개수 N을 입력 받는다.
     * 1-1. 1~100 사이의 정수인지 확인한다.
     * 2. 공백없이 문자열을 입력 받는다.
     * 2-1. 문자열에 공백이 있는지 확인한다.
     * 2-2. 문자열의 길이가 N과 일치하는지 확인한다.
     * 2-3. 문자열이 숫자로만 이루어져 있는지 확인한다.
     * 3. 문자열 각 자리의 문자를 정수형으로 변환한다.
     * 4. 숫자를 모두 합한다.
     * 4-1. 결과가 제대로 나왔는지 확인한다.
     * 5. 결과값을 출력한다.
     */
    public static void main(String[] args) {
        N = scanner.nextInt();
        extinctReturn(scanner);
        NTest nTest = new NTest();
        while(!(nTest.invalidRange(N))) {
            N = scanner.nextInt();
        }

        NumbersTest numbersTest = new NumbersTest();
        S = scanner.nextLine();
        while(!(numbersTest.lengthTest(S, N)) && !(numbersTest.intTest(S)) && !(numbersTest.blankTest(S))) {
            S = scanner.nextLine();
        }

        Solution solution = new Solution();
        ArrayList<Integer> arr = solution.strToInt(S);
        System.out.println(solution.sum(arr));
    }

    public static void extinctReturn(Scanner scanner) {
        String s = scanner.nextLine();
    }
}

class NTest {
    /**
     * 입력 받을 정수의 개수 N의 유효성을 검사하는 메서드
     * @param N 1~100 사이의 정수
     * @return N이 1~100 사이의 정수인지 확인 후 반환한다.
     */
    public boolean invalidRange(int N) {
        if (1<=N && N<=100) return true;
        else return false;
    }
}

class NumbersTest {
    /**
     * 입력 받은 문자열에 공백이 있는지 확인하는 메서드
     * @param S 공백없이 이루어진 문자열
     * @return S에 공백이 있는지 확인 후 반환한다.
     */
    public boolean blankTest(String S) {
        if (S.contains(" ")) return true;
        else return false;
    }

    /**
     * 입력 받은 문자열의 개수가 맞는지 확인하는 메서드
     * @param S 공백없이 이루어진 문자열
     * @param N 1~100 사이의 정수
     * @return S의 길이가 N과 같은지 확인 후 반환한다.
     */
    public boolean lengthTest(String S, int N) {
        if (S.length() == N) return true;
        else return false;
    }

    /**
     * 입력 받은 문자열이 숫자로 이루어져 있는지 확인하는 메서드
     * @param S 공백없이 이루어진 문자열
     * @return S가 숫자로 이루어져 있는지 확인 후 반환한다.
     */
    public boolean intTest(String S) {
        for (int i=0; i<S.length(); i++) {
            int n = Integer.parseInt(String.valueOf(S.charAt(i)));
            if (0<=n && n<=9) continue;
            else return false;
        }
        return true;
    }
}

class Solution {
    /**
     * 입력 받은 문자열을 정수형으로 변환 후 ArrayList에 저장하는 메서드
     * @param S 공백없이 이루어진 문자열
     * @return 문자열 S의 길이만큼의 숫자가 저장된 ArrayList
     */
    public ArrayList<Integer> strToInt(String S) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<S.length(); i++) {
            arr.add(Integer.parseInt(String.valueOf(S.charAt(i))));
        }
        return arr;
    }

    /**
     * ArrayList에 저장된 정수들의 총합을 구하는 메서드
     * @param arr 정수들이 저장된 ArrayList
     * @return ArrayList에 저장된 정수들의 총합을 반환한다.
     */
    public int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i=0; i<arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}