package homeWork14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Девчата", 8.7));
        movies.add(new Movie("Лига справедливости", 8.1));
        movies.add(new Movie("Фишер", 8.8));
        movies.add(new Movie("Гита и Зита", 6.6));

        System.out.println("До сортировки:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        // Сортировка собственным компаратором
        movies.sort(new MovieRatingComparator());

        System.out.println("\nПосле сортировки:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}