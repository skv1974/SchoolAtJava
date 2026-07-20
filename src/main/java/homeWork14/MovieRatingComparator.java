package homeWork14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        // Сортировка от меньшего к большему
        return Double.compare(m1.getRating(), m2.getRating());
    }
}
