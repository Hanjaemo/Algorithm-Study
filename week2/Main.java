package week2;

import java.util.Scanner;

class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int nSubject;
    private static int[] scoreArr;
    private static int maxScore;
    private static double[] newScoreArr;

    /**
     * logic
     * 1. 입력 받을 과목 개수를 입력 받는다. -> int nSubject
     * 1-1. nSubject는 0~1000 사이의 정수이다.
     * 2. 입력 받은 개수만큼 점수를 입력 받는다.
     * 2-1. 점수는 0~100 사이의 정수이다.
     * 2-2. 적어도 하나의 값은 0보다 크다.
     * 3. 입력 받은 점수들을 비교하여 최댓값을 선정한다. -> int maxScore
     * 4. 모든 점수를 최댓값으로 나누고 100을 곱한다.
     * 5. 점수들의 평균을 구한다. -> float avg;
     * 5-1. avg는 소수 둘째자리까지만 나타낸다.
     */

    public static void main(String[] args) {
        Validation validation = new Validation();

        nSubject = Integer.parseInt(scanner.nextLine());
        while (!(validation.validateNSubject(nSubject))) {
            nSubject = Integer.parseInt(scanner.nextLine());
        }

        Main b1546 = new Main();

        scoreArr = b1546.setScoreArr();
        while (!validation.validateIsZero(scoreArr)) {
            System.out.println("적어도 하나의 점수는 0보다 커야합니다.");
            scoreArr = b1546.setScoreArr();
        };

        while (validation.invalidScore(scoreArr)) {
            System.out.println("점수는 0~100 사이의 정수값이어야 합니다.");
            scoreArr = b1546.setScoreArr();
        }

        b1546.setNewScoreArr();
        System.out.println(b1546.getAvg());
    }

    /**
     * 점수를 입력 받아 배열에 저장하는 메서드
     * @return
     */
    public int[] setScoreArr() {
        int[] scoreArr = new int[nSubject];

        for (int i=0; i<scoreArr.length; i++) {
            scoreArr[i] = Integer.parseInt(scanner.next());
        }

        return scoreArr;
    }

    /**
     * 점수들 중 최댓값을 반환하는 메서드
     * @return
     */
    public int getMaxScore() {
        maxScore = 0;
        for (int i=0; i<scoreArr.length; i++) {
            if (maxScore < scoreArr[i]) {
                maxScore = scoreArr[i];
            }
        }
        return maxScore;
    }

    /**
     * 기존 배열의 요소(점수)를 최댓값으로 나누고 100을 곱하여 새로운 배열을 만든다.
     */
    public void setNewScoreArr() {
        newScoreArr = new double[scoreArr.length];
        for(int i=0; i<scoreArr.length; i++) {
            newScoreArr[i] = (double) scoreArr[i] / getMaxScore() * 100;
        }
    }

    /**
     * 새로 완성된 배열의 모든 요소의 평균을 구하는 메서드
     * @return
     */
    public float getAvg() {
        int total = 0;
        for (int i=0; i<newScoreArr.length; i++) {
            total += newScoreArr[i];
        }
        return (float) total / newScoreArr.length;
    }
}

class Validation {
    /**
     * 과목 개수의 유효성 검사하는 메서드
     * @param nSubject
     * @return
     */
    public boolean validateNSubject(int nSubject) {
        if (0<=nSubject && nSubject <=1000) return true;
        else return false;
    }

    /**
     * 점수가 0~100 사이의 정수인지 확인하는 메서드
     * @param scoreArr
     * @return
     */
    public boolean invalidScore(int[] scoreArr) {
        for (int i=0; i<scoreArr.length; i++) {
            if (!(0<=scoreArr[i] && scoreArr[i]<=100)) {
                break;
            }
        }
        return false;
    }

    /**
     * 적어도 하나 이상의 점수가 0보다 큰지 확인하는 메서드
     * @param scoreArr
     * @return
     */
    public boolean validateIsZero(int[] scoreArr) {
        int checkZero = 0;
        for (int i=0; i<scoreArr.length; i++) {
            if (scoreArr[i] == 0) {
                checkZero += 1;
            }
        }

        if (checkZero <= 1) return true;
        else return false;
    }
}