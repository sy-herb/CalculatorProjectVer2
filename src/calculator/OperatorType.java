package calculator;

public enum OperatorType {
    ADD('+') {
        public double apply (double num1, double num2) {
            return num1 + num2;
        }
    },
    SUB('-') {
        public double apply (double num1, double num2) {
            return num1 - num2;
        }
    },
    MUL('*') {
        public double apply (double num1, double num2) {
            return num1 * num2;
        }
    },
    DIV('/') {
        public double apply (double num1, double num2) {
            if (num2 == 0)
                System.out.println("0으로는 나눌 수 없습니다.");
            return num1 /num2;
        }
    };

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public abstract double apply(double num1, double num2);

    public static OperatorType fromChar (char operator) {
        for(OperatorType op : values()) {
            if (op.operator == operator) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산 기호입니다.");
    }
}
