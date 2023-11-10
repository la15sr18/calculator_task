package com.central.calculator.operation;

public class Division implements Operation {

    public double calculateResult(double left, double right) {
        if(right == 0)
            throw new ArithmeticException("Деление на 0");
        return left / right;
    }

}
