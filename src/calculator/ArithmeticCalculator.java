package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Double> results = new ArrayList<>();

    public <A extends Number> Double calculate (A num1, A num2, char operator) {

        OperatorType op = OperatorType.fromChar(operator);

        double result = op.apply(num1.doubleValue(), num2.doubleValue());

        results.add(result);

        return result;
    }

    public List<Double> getResult() {

        return results;
    }

    public void removeResult() {

        if (!results.isEmpty()) {
            results.remove(0);
        }

    }
}
