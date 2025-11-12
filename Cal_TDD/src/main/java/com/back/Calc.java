package com.back;


public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");
        // 숫자, 연산자 혼재된 배열

        int totalLength = expressionBits.length;
        Integer[] numBits = new Integer[totalLength]; //숫자 담는 배열
        String[] operatorBits = new String[totalLength]; // 연산자 담는 배열

        for (int i = 0; i < totalLength; i++) {
            if (i % 2 == 0) {
                numBits[i] = Integer.parseInt(expressionBits[i]);
            } else {
                operatorBits[i] = expressionBits[i];
            }
        }
        // 숫자배열 numbits : 짝수 번호에 숫자 들어감
        // 연산자배열 operatorbits : 홀수 번호에 연산자 들어감
        // ex) expression = "10 + 5 * 2"
        // numBits = [10, null, 5, null, 2]
        // operatorBits = [null, "+", null, "*", null]

        int result = numBits[0]; // 어차피 첫번째 숫자는 무조건 계산에 들어감

        for (int i = 0; i < totalLength; i++) {
            if (operatorBits[i] == null) operatorBits[i] = "";
            // 스위치에 null 들어가면 바로 오류 -> 빈문자열로
            switch (operatorBits[i]) {
                // 1번째 연산자 +로 결정 -> 그 다음 2번째 숫자와 + 연산
                // 괄호나 부호 우선 순위가 문제긴 한데 그 부분만 슬라이싱해서 처리?
                // 아님 갈아엎어야될 듯..
                case "+":
                    result += numBits[i+1];
                    break;
                case "-":
                    result -= numBits[i+1];
                    break;
                case "*":
                    result *= numBits[i+1];
                    break;
                case "/":
                    result /= numBits[i+1];
                    break;
            }
        }
        return result;
    }
}
