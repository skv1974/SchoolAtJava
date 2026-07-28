package homeWork15;

import java.util.ArrayList;
import java.util.List;

public class GameRental {
    private final List<BoardGame> catalog = new ArrayList<>();

    public void addGame(BoardGame game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (findGame(game.getTitle()) != null) {
            throw new IllegalArgumentException("Game with this title already exists");
        }
        catalog.add(game);
    }

    public BoardGame findGame(String title) {
        for (BoardGame game : catalog) {
            if (game.getTitle().equalsIgnoreCase(title)) {
                return game;
            }
        }
        return null;
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Game does not exist");
        }
        if (game.isRented() || !game.canBeRentedBy(customerAge)) {
            return false;
        }
        game.setRented(true);
        return true;
    }

    public boolean returnGame(String name) {
        BoardGame game = findGame(name);
        if (game == null || !game.isRented()) {
            return false;
        }
        game.setRented(false);
        return true;
    }

    public int calculateCost(String name, int days) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Game does not exist");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than zero");
        }
        return game.getRentalCostPerDay() * days;
    }

    public void reset() {
        for (BoardGame game : catalog) {
            game.setRented(false);
        }
    }
}