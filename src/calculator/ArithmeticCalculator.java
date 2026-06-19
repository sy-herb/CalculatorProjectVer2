package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void printGreaterThan(double threshold) {
        String resultList = results.stream()
                .filter(r -> r.doubleValue() > threshold)
                .map(r -> {
                    if (r instanceof Integer) {
                        return String.valueOf(r.intValue());
                    } else {
                        // 소수점 첫째 자리까지만 반올림
                        double rounded = Math.round(r.doubleValue() * 10) / 10.0;
                        return String.valueOf(rounded);
                    }
                })
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("조회 결과 : " + resultList);
    }
}
