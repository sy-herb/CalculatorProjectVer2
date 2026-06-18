package calculator;

import java.util.Scanner;

public class CalculatorStep1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit = "";

        int result = 0;

        while (!exit.equals("exit")) {
            System.out.print("첫 번째 정수를 입력하세요. : ");
            int num1 = sc.nextInt();
            if (num1 < 0) {
                System.out.println("0을 포함한 양의 정수만 입력 가능합니다.");
                continue;
            }

            System.out.print("두 번째 정수를 입력하세요. : ");
            int num2 = sc.nextInt();
            if (num2 < 0) {
                System.out.println("0을 포함한 양의 정수만 입력 가능합니다.");
            }

            System.out.print("연산 기호(+ - * /)를 입력하세요. : ");
            char oper = sc.next().charAt(0);

            switch (oper) {
                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default :
                    System.out.println("지원하지 않는 연산 기호를 입력하셨습니다.");
                    continue;
            }
            System.out.println("결과 : " + result);

            System.out.print("더 계산하시겠습니까 ? (exit 입력시 종료됨)");
            exit = sc.next();
            System.out.println("");
        }
        sc.close();
        System.out.println("프로그램을 종료합니다.");
    }
}
