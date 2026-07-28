package homeWork15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameRentalTest {

    private GameRental rental;
    private BoardGame game;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        game = new BoardGame("Carcassonne", 8, 300);
    }

    @Test
    void shouldAddGameAndFindIt() {
        rental.addGame(game);
        BoardGame found = rental.findGame("Carcassonne");
        assertNotNull(found);
        assertEquals("Carcassonne", found.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullGame() {
        assertThrows(IllegalArgumentException.class, () -> rental.addGame(null));
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateGame() {
        rental.addGame(game);
        BoardGame duplicate = new BoardGame("Carcassonne", 12, 400);
        assertThrows(IllegalArgumentException.class, () -> rental.addGame(duplicate));
    }

    @Test
    void shouldReturnNullWhenGameNotFound() {
        assertNull(rental.findGame("Unknown"));
    }

    @Test
    void shouldRentGameSuccessfully() {
        rental.addGame(game);
        boolean result = rental.rentGame("Carcassonne", 10);
        assertTrue(result);
        assertTrue(game.isRented());
    }

    @Test
    void shouldFailRentWhenCustomerTooYoung() {
        rental.addGame(game); // minAge = 8
        boolean result = rental.rentGame("Carcassonne", 6);
        assertFalse(result);
        assertFalse(game.isRented());
    }

    @Test
    void shouldFailRentWhenAlreadyRented() {
        rental.addGame(game);
        rental.rentGame("Carcassonne", 10);

        boolean secondRent = rental.rentGame("Carcassonne", 12);
        assertFalse(secondRent);
    }

    @Test
    void shouldThrowExceptionWhenRentingNonExistentGame() {
        assertThrows(IllegalArgumentException.class, () -> rental.rentGame("Ghost", 10));
    }

    @Test
    void shouldReturnGameSuccessfully() {
        rental.addGame(game);
        rental.rentGame("Carcassonne", 10);

        boolean returned = rental.returnGame("Carcassonne");
        assertTrue(returned);
        assertFalse(game.isRented());
    }

    @Test
    void shouldFailReturnWhenNotRentedOrNotExists() {
        assertFalse(rental.returnGame("Ghost")); // Не существует

        rental.addGame(game);
        assertFalse(rental.returnGame("Carcassonne")); // Не была арендована
    }

    @Test
    void shouldCalculateCostCorrectly() {
        rental.addGame(game); // cost = 300
        int cost = rental.calculateCost("Carcassonne", 4);
        assertEquals(1200, cost);
    }

    @Test
    void shouldThrowExceptionWhenCalculatingCostForInvalidParams() {
        rental.addGame(game);
        assertThrows(IllegalArgumentException.class, () -> rental.calculateCost("Ghost", 3));
        assertThrows(IllegalArgumentException.class, () -> rental.calculateCost("Carcassonne", 0));
        assertThrows(IllegalArgumentException.class, () -> rental.calculateCost("Carcassonne", -2));
    }

    @Test
    void shouldResetAllGamesToAvailable() {
        rental.addGame(game);
        BoardGame game2 = new BoardGame("Monopoly", 6, 200);
        rental.addGame(game2);

        rental.rentGame("Carcassonne", 10);
        rental.rentGame("Monopoly", 10);

        rental.reset();

        assertFalse(game.isRented());
        assertFalse(game2.isRented());
    }
}