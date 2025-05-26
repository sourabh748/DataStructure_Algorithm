package Generics;

enum Operator {
    ADD, SUBSTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD:
                return a.doubleValue() + b.doubleValue();

            case SUBSTRACT:
                return a.doubleValue() - b.doubleValue();
            
            case MULTIPLY:
                return a.doubleValue() * b.doubleValue();
            
            case DIVIDE:
                return a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown Operation: " + this);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Operator.ADD.apply(10, 11);
    }
}