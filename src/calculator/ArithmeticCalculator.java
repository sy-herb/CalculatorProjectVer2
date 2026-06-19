package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Number> results = new ArrayList<>();

    public <A extends Number> Number calculate (A num1, A num2, char operator) {

        OperatorType op = OperatorType.fromChar(operator);

        double result = op.apply(num1.doubleValue(), num2.doubleValue());

        if (num1 instanceof Integer && num2 instanceof Integer) {
            results.add((int) result);   // 정수로 저장
            return (int) result;
        } else {
            results.add(result);         // 실수로 저장
            return result;
        }
    }

    public List<Number> getResult() {

        return results;
    }

    public void removeResult() {

        if (!results.isEmpty()) {
            results.remove(0);
        }

    }
}
