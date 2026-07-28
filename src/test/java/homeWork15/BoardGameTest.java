package homeWork15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {

    @Test
    void shouldCreateBoardGameWithValidArguments() {
        BoardGame game = new BoardGame("Catan", 10, 500);
        assertEquals("Catan", game.getTitle());
        assertEquals(10, game.getMinAge());
        assertEquals(500, game.getRentalCostPerDay());
        assertFalse(game.isRented());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new BoardGame(null, 10, 500));
    }

    @Test
    void shouldThrowExceptionWhenTitleIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("", 10, 500));
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("   ", 10, 500));
    }

    @Test
    void shouldThrowExceptionWhenMinAgeIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("Catan", -1, 500));
    }

    @Test
    void shouldThrowExceptionWhenCostIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("Catan", 10, 0));
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("Catan", 10, -100));
    }

    @Test
    void shouldCorrectlyCheckAgeRequirement() {
        BoardGame game = new BoardGame("Catan", 12, 500);

        assertFalse(game.canBeRentedBy(10)); // Слишком молод
        assertTrue(game.canBeRentedBy(12));  // Возраст равен ограничению
        assertTrue(game.canBeRentedBy(15));  // Старше ограничения
    }
}