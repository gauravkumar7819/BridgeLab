package StreamAPI;

import java.util.*;
import java.time.LocalDate;

public class MovieAnalytics {
    static class Movie {
        private String title;
        private double rating;
        private LocalDate releaseDate;

        public Movie(String title, double rating, LocalDate releaseDate) {
            this.title = title;
            this.rating = rating;
            this.releaseDate = releaseDate;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public double getRating() {
            return rating;
        }

        public LocalDate getReleaseDate() {
            return releaseDate;
        }

        @Override
        public String toString() {
            return "Movie{title='" + title + "', rating=" + rating +
                   ", releaseDate=" + releaseDate + "}";
        }
    }

    public List<Movie> getTop5TrendingMovies(List<Movie> movies) {
        return movies.stream()
            .filter(movie -> movie.getRating() > 4.0) // sirf acche movies
            .sorted(
                Comparator.comparing(Movie::getReleaseDate).reversed() // naya pehle
                          .thenComparing(Movie::getRating, Comparator.reverseOrder()) // phir rating high
            )
            .limit(5) // top 5
            .toList(); // Java 16+, else collect(Collectors.toList())
    }

    // Example usage
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 4.5, LocalDate.of(2025, 8, 20)),
            new Movie("Movie B", 3.8, LocalDate.of(2025, 7, 15)),
            new Movie("Movie C", 4.7, LocalDate.of(2025, 9, 1)),
            new Movie("Movie D", 4.2, LocalDate.of(2025, 8, 25)),
            new Movie("Movie E", 4.9, LocalDate.of(2025, 9, 5)),
            new Movie("Movie F", 4.1, LocalDate.of(2025, 6, 30)),
            new Movie("Movie G", 4.8, LocalDate.of(2025, 9, 3))
        );

        MovieAnalytics analytics = new MovieAnalytics();
        List<Movie> top5 = analytics.getTop5TrendingMovies(movies);

        System.out.println("Top 5 Trending Movies:");
        top5.forEach(System.out::println);
    }
}
