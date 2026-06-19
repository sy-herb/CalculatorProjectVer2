package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Number> results = new ArrayList<>();

    public <A extends Number> Number calculate (A num1, A num2, char operator) {

        OperatorType op = OperatorType.fromChar(operator);

        double result = op.apply(num1.doubleValue(), num2.doubleValue());

        if (operator == '/' && num1 instanceof Integer && num2 instanceof Integer) {
            if (num1.intValue() % num2.intValue() == 0) {
                int intResult = (int) result;
                results.add(intResult);
                return intResult;
            }
        }

        // 소수점 첫째 자리까지만 반올림
        double rounded = Math.round(result * 10) / 10.0;
        results.add(rounded);
        return rounded;
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
