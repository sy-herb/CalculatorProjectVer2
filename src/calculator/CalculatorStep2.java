package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorStep2 {

    private List<Integer> results = new ArrayList<>();

    public Integer Calculate (int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
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
                    System.out.println("0으로는 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;

            default :
                System.out.println("지원하지 않는 연산 기호입니다.");
        }
        results.add(result);
        return result;
    }

    public List<Integer> getResult() {
        return results;
    }

    public void removeResult() {
        results.remove(0);
    }
}
