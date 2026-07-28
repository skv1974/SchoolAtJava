package homeWork15;

public class BoardGame {
    private final String title;
    private final int minAge;
    private final int rentalCostPerDay;
    private boolean isRented;

    public BoardGame(String title, int minAge, int rentalCostPerDay) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (minAge < 0) {
            throw new IllegalArgumentException("Minimum age cannot be negative");
        }
        if (rentalCostPerDay <= 0) {
            throw new IllegalArgumentException("Rental cost must be greater than zero");
        }

        this.title = title;
        this.minAge = minAge;
        this.rentalCostPerDay = rentalCostPerDay;
        this.isRented = false;
    }

    public String getTitle() {
        return title;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean canBeRentedBy(int age) {
        return age >= minAge;
    }
}