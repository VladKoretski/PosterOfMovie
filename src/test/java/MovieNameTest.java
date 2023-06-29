import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.MovieName;

public class MovieNameTest {

    //Testing of one-parameter constructor of class MovieName
    @Test
    public void shouldCheckGetterForOneParameterConstructor() {
        MovieName movie = new MovieName("No-name Movie");
        String expected = "No-name Movie";
        String actual = movie.getNameOfMovie();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckSetterForOneParameterConstructor() {
        MovieName movie = new MovieName("No-name Movie");
        String expected = "New Movie";
        movie.setNameOfMovie("New Movie");
        String actual = movie.getNameOfMovie();
        Assertions.assertEquals(expected, actual);
    }

    //Testing of none-parameter constructor of class MovieName
    @Test
    public void shouldCheckGetterForNoneParameterConstructor() {
        MovieName movie = new MovieName();
        String actual = movie.getNameOfMovie();
        Assertions.assertNull(actual); // автоматом так настроилось
    }

    @Test
    public void shouldCheckSetterForNoneParameterConstructor() {
        MovieName movie = new MovieName();
        String expected = "New Movie";
        movie.setNameOfMovie("New Movie");
        String actual = movie.getNameOfMovie();
        Assertions.assertEquals(expected, actual);
    }
}
