package homeWork20.tests;

import homeWork20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Калькулятор")
@Feature("Математические функции")
public class MathFunctionsTest {
    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Smotrov_K_V")
    @Description("Проверяем возведение в степень: 2^10 = 1024")
    @Link(value = "JIRA-1004", name = "Task: Power Function")
    public void testPower() {
        double result = steps.power(2, 10);
        steps.verifyResult(1024, result);
        assertEquals(1024, result, 0.0001);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Smotrov_K_V")
    @Description("Проверяем квадратный корень из положительного числа: sqrt(9) = 3")
    public void testSqrtPositive() {
        double result = steps.sqrt(9);
        steps.verifyResult(3, result);
        assertEquals(3, result, 0.0001);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Smotrov_K_V")
    @Description("Проверяем квадратный корень из отрицательного числа: ожидается ArithmeticException")
    @Link(value = "JIRA-1005", name = "Task: Sqrt Exception")
    public void testSqrtNegative() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            steps.sqrt(-4);
        });
        Allure.parameter("Ожидаемое исключение", "ArithmeticException");
        assertEquals("Корень из отрицательного числа", exception.getMessage());
    }
}
