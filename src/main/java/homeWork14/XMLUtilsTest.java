package homeWork14;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLUtilsTest {

    @Test
    public void testCreateEmptyElementWithValidTagName() {
        // 1. Arrange
        String inputTagName = "user";
        String expectedOutput = "<user></user>";

        // 2. Act
        String actualOutput = XMLUtils.createEmptyElement(inputTagName);

        // 3. Assert
        assertEquals(expectedOutput, actualOutput,
                String.format("Метод должен возвращать корректные теги для валидного имени. Ожидалось: %s, но получено: %s", expectedOutput, actualOutput));
    }

    @Test
    public void testCreateEmptyElementWithNull() {
        // 1. Arrange
        String inputTagName = null;
        String expectedOutput = "<invalid/>";

        // 2. Act
        String actualOutput = XMLUtils.createEmptyElement(inputTagName);

        // 3. Assert
        assertEquals(expectedOutput, actualOutput,
                String.format("Метод должен возвращать <invalid/> при передаче null. Ожидалось: %s, но получено: %s", expectedOutput, actualOutput));
    }

    @Test
    public void testCreateEmptyElementWithEmptyString() {
        // 1. Arrange
        String inputTagName = "";
        String expectedOutput = "<invalid/>";

        // 2. Act
        String actualOutput = XMLUtils.createEmptyElement(inputTagName);

        // 3. Assert
        assertEquals(expectedOutput, actualOutput,
                String.format("Метод должен возвращать <invalid/> при передаче пустой строки. Ожидалось: %s, но получено: %s", expectedOutput, actualOutput));
    }
}