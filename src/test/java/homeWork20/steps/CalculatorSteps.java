package homeWork20.steps;

import homeWork20.Calculator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class CalculatorSteps {
    private final Calculator calculator = new Calculator();

    @Step("Сложить {a} + {b}")
    public double add(double a, double b) {
        double result = calculator.add(a, b);
        attachCalculation(String.valueOf(a), "+", b, result);
        return result;
    }

    @Step("Вычесть {a} - {b}")
    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        attachCalculation(String.valueOf(a), "-", b, result);
        return result;
    }

    @Step("Умножить {a} * {b}")
    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        attachCalculation(String.valueOf(a), "*", b, result);
        return result;
    }

    @Step("Разделить {a} / {b}")
    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        attachCalculation(String.valueOf(a), "/", b, result);
        return result;
    }

    @Step("Возвести {base} в степень {exponent}")
    public double power(double base, double exponent) {
        double result = calculator.power(base, exponent);
        attachCalculation(String.valueOf(base), "^", exponent, result);
        return result;
    }

    @Step("Вычислить квадратный корень из {value}")
    public double sqrt(double value) {
        double result = calculator.sqrt(value);
        attachCalculation("sqrt", "", value, result);
        return result;
    }

    @Step("Проверить результат: ожидаемое {expected}, фактическое {actual}")
    public void verifyResult(double expected, double actual) {
        Allure.step("Проверка: ожидаемое = " + expected + ", фактическое = " + actual);
    }

    private void attachCalculation(String a, String op, double b, double result) {
        String calculation = String.format("Вычисление: %s %s %s = %s", a, op, b, result);
        Allure.addAttachment(calculation, calculation, "UTF-8");
    }
}
