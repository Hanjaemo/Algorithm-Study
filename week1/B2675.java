package week1;

import java.util.Scanner;

class B2675 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt(); // 테스트 케이스 개수
        extinctReturn(scanner); // scanner에 남아 있는 return 소거

        for (int i=0; i<testCase; i++) {
            String[] input = scanner.nextLine().split(" ");

            int repeat = Integer.parseInt(input[0]);
            if (invalidRepeat(repeat)) return; // repeat 유효성 검사

            String string = input[1];
            if (invalidString(string)) return; // string 유효성 검사

            repeatString(repeat, string);
        }
    }

    static void extinctReturn(Scanner scanner) {
        String extinctReturn = scanner.nextLine();
    }

    static boolean invalidRepeat(int repeat) {
        return !(1 <= repeat && repeat <= 8);
    }

    static boolean invalidString(String string) {
        return !(1 <= string.length() && string.length() < 8);
    }

    static void repeatString(int repeat, String string) {
        for (int j=0; j<string.length(); j++) {
            for (int k=0; k<repeat; k++) {
                System.out.print(string.charAt(j));
            }
        }
        System.out.println();
    }
}
