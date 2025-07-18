import java.util.*;

public class Recommender {

    static class Movie {
        String title;
        List<String> genres;

        Movie(String title, List<String> genres) {
            this.title = title;
            this.genres = genres;
        }
    }

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", Arrays.asList("Sci-Fi", "Action")));
        movies.add(new Movie("The Notebook", Arrays.asList("Romance", "Drama")));
        movies.add(new Movie("Avengers: Endgame", Arrays.asList("Action", "Adventure")));
        movies.add(new Movie("Titanic", Arrays.asList("Romance", "Drama")));
        movies.add(new Movie("Interstellar", Arrays.asList("Sci-Fi", "Adventure")));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your favorite genre (e.g. Action, Romance, Sci-Fi): ");
        String genre = scanner.nextLine();

        System.out.println("\n🎬 Recommended movies for genre: " + genre);
        for (Movie movie : movies) {
            if (movie.genres.contains(genre)) {
                System.out.println("👉 " + movie.title);
            }
        }
    }
}
