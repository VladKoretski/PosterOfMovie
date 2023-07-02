import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.MovieName;
import ru.netology.MoviePosterManager;

public class MoviePosterManagerTest {
    MovieName movie1 = new MovieName("Movie 1");
    MovieName movie2 = new MovieName("Movie 2");
    MovieName movie3 = new MovieName("Movie 3");
    MovieName movie4 = new MovieName("Movie 4");
    MovieName movie5 = new MovieName("Movie 5");
    MovieName movie6 = new MovieName("Movie 6");
    MovieName movie7 = new MovieName("Movie 7");
    MovieName movie8 = new MovieName("Movie 8");
    MovieName[] posters = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
    MoviePosterManager managerWithPosters = new MoviePosterManager(posters);
    MoviePosterManager managerWithPosterAndResultLengthConstruction = new MoviePosterManager(posters, 7);
    MoviePosterManager managerDefaultConstruction = new MoviePosterManager();
    MoviePosterManager managerWithResultLength = new MoviePosterManager(7);

    //Getters and Setters testing
    //DefaultConstruction
    @Test
    public void ShouldGetPosterAndResultLength() {
        MoviePosterManager manager = new MoviePosterManager();
        MovieName[] expectedPosters = {};
        MovieName[] actualPosters = manager.getPosters();
        int expectedResultLength = 5;
        int actualResultLength = manager.getResultLength();

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
        Assertions.assertEquals(expectedResultLength, actualResultLength);
    }

    @Test
    public void ShouldSetPostersAndResultLength() {
        managerDefaultConstruction.setPosters(posters);
        MovieName[] expectedPosters = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actualPosters = managerDefaultConstruction.getPosters();
        managerDefaultConstruction.setResultLength(7);
        int expectedResultLength = 7;
        int actualResultLength = managerDefaultConstruction.getResultLength();

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
        Assertions.assertEquals(expectedResultLength, actualResultLength);
    }

    //Poster Construction
    @Test
    public void ShouldGetPostersForPostersConstruction() {
        MovieName[] expectedPosters = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actualPosters = managerWithPosters.getPosters();
        Assertions.assertArrayEquals(expectedPosters, actualPosters);
    }

    //ResultLength Construction
    @Test
    public void ShouldGetPostersAndResultLengthForResultLengthConstructor() {
        MovieName[] expectedPosters = {};
        MovieName[] actualPosters = managerWithResultLength.getPosters();
        int expectedResultLength = 7;
        int actualResultLength = managerWithResultLength.getResultLength();

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
        Assertions.assertEquals(expectedResultLength, actualResultLength);
    }

    @Test
    public void ShouldSetPostersAndResultLengthForResultLengthConstructor() {
        managerWithResultLength.setPosters(posters);
        MovieName[] expectedPosters = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actualPosters = managerWithResultLength.getPosters();
        managerWithResultLength.setResultLength(6);
        int expectedResultLength = 6;
        int actualResultLength = managerWithResultLength.getResultLength();

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
        Assertions.assertEquals(expectedResultLength, actualResultLength);
    }

    //Result Length and Poster Constructor
    @Test
    public void ShouldGetPostersAndResultLengthForPosterAndResultLengthConstructor() {
        MovieName[] expectedPosters = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actualPosters = managerWithPosterAndResultLengthConstruction.getPosters();
        int expectedResultLength = 7;
        int actualResultLength = managerWithPosterAndResultLengthConstruction.getResultLength();

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
        Assertions.assertEquals(expectedResultLength, actualResultLength);
    }

    @Test
    public void ShouldSetPostersAndResultLengthForPosterAndResultLengthConstructor() {
        managerWithPosterAndResultLengthConstruction.setPosters(posters);
        MovieName[] expectedPosters = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actualPosters = managerWithPosterAndResultLengthConstruction.getPosters();
        managerWithPosterAndResultLengthConstruction.setResultLength(6);
        int expectedResultLength = 6;
        int actualResultLength = managerWithPosterAndResultLengthConstruction.getResultLength();

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
        Assertions.assertEquals(expectedResultLength, actualResultLength);
    }

    // Add movies testing
    @Test
    public void shouldCheckAddSomeMovie() {

        MoviePosterManager manager = new MoviePosterManager();
        MovieName newMovie1 = new MovieName("movie 1");
        manager.addNewMovie(newMovie1);
        MovieName newMovie2 = new MovieName("movie 2");
        manager.addNewMovie(newMovie2);
        MovieName newMovie3 = new MovieName("movie 3");
        manager.addNewMovie(newMovie3);
        MovieName[] expected = {newMovie1, newMovie2, newMovie3};
        MovieName[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Find All and Find Last testing
    //FindAll Testing
    @Test
    public void shouldFindAllForBasicConstructor() {
        MoviePosterManager manager = new MoviePosterManager();
        MovieName[] expected = {};
        MovieName[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //FindAll and FindLast for none-zero poster matrices
    @BeforeEach
    public void setup() {

        //Test data for basic constructor
        managerDefaultConstruction.addNewMovie(movie1);
        managerDefaultConstruction.addNewMovie(movie2);
        managerDefaultConstruction.addNewMovie(movie3);
        managerDefaultConstruction.addNewMovie(movie4);
        managerDefaultConstruction.addNewMovie(movie5);
        managerDefaultConstruction.addNewMovie(movie6);
        managerDefaultConstruction.addNewMovie(movie7);
        managerDefaultConstruction.addNewMovie(movie8);
    }

    @Test
    public void shouldFindAllForBasicConstructor1() {
        MoviePosterManager manager = new MoviePosterManager();
        MovieName[] expected = {};
        MovieName[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllForPosterConstruction() {
        MovieName[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        MovieName[] actual = managerDefaultConstruction.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // FindLast for different ResultLength: default = 5; 3; 4; 7);
    //For 5
    @Test
    public void shouldFindLastForDefaultResultLength() {
        MovieName[] expected = {movie8, movie7, movie6, movie5, movie4};
        MovieName[] actual = managerDefaultConstruction.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    //For 3
    @Test
    public void shouldFindLastResultLength3() {
        MovieName[] expected = {movie8, movie7, movie6};
        managerDefaultConstruction.setResultLength(3);
        MovieName[] actual = managerDefaultConstruction.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    //For 4
    @Test
    public void shouldFindLastResultLength4() {
        MovieName[] expected = {movie8, movie7, movie6, movie5};
        managerDefaultConstruction.setResultLength(4);
        MovieName[] actual = managerDefaultConstruction.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    //For 6
    @Test
    public void shouldFindLastResultLength6() {
        MovieName[] expected = {movie8, movie7, movie6, movie5, movie4, movie3};
        managerDefaultConstruction.setResultLength(6);
        MovieName[] actual = managerDefaultConstruction.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    //For 7
    @Test
    public void shouldFindLastResultLength7() {
        MovieName[] expected = {movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        managerDefaultConstruction.setResultLength(7);
        MovieName[] actual = managerDefaultConstruction.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    //For empty poster
    @Test
    public void shouldFindLastEmptyPoster() {
        MovieName[] expected = {};
        MoviePosterManager manager = new MoviePosterManager();
        MovieName[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
