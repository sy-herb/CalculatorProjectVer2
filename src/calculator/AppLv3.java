package calculator;

import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        String exit = "";


        while (!exit.equals("exit")) {
            System.out.print("첫 번째 숫자를 입력하세요. : ");
            String input1 = sc.next();
            Number num1;
            if (input1.contains(".")) {
                num1 = Double.parseDouble(input1);
            } else {
                num1 = Integer.parseInt(input1);
            }
            if (num1.doubleValue() < 0) {
                System.out.println("0을 포함한 양의 정수만 입력 가능합니다.");
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요. : ");
            String input2 = sc.next();
            Number num2;
            if (input2.contains(".")) {
                num2 = Double.parseDouble(input2);
            } else {
                num2 = Integer.parseInt(input2);
            }
            if (num2.doubleValue() < 0) {
                System.out.println("0을 포함한 양의 정수만 입력 가능합니다.");
                continue;
            }

            System.out.print("연산 기호(+ - * /)를 입력하세요. : ");
            char oper = sc.next().charAt(0);

            Number result = calculator.calculate(num1, num2, oper);
            if (num1 instanceof Integer && num2 instanceof Integer) {
                System.out.println("결과: " + result.intValue());
            } else {
                System.out.println("결과: " + result);
            }

            System.out.println("현재 저장된 결과 : " + calculator.getResult());

            System.out.print("가장 오래된 결과를 삭제하시겠습니까 ? (yes 입력시 삭제됨)");
            String remove = sc.next();
            if (remove.equals("yes")) {
                calculator.removeResult();
                System.out.println("현재 남은 결과 : " + calculator.getResult());
            }

            System.out.print("더 계산하시겠습니까 ? (exit 입력시 종료됨)");
            exit = sc.next();
            System.out.println("");
        }
        sc.close();
        System.out.println("프로그램을 종료합니다.");
    }
}
