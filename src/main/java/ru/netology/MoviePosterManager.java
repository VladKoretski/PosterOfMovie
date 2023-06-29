package ru.netology;

public class MoviePosterManager {

    public MovieName[] posters = new MovieName[0];
    int resultLength = 5;

    // Constructors
    public MoviePosterManager() {
    }

    public MoviePosterManager(MovieName[] posters) {

        this.posters = posters;
    }

    public MoviePosterManager(int resultLength) {

        this.resultLength = resultLength;
    }

    public MoviePosterManager(MovieName[] posters, int resultLength) {
        this.posters = posters;
        this.resultLength = resultLength;
    }

    // File adding
    public void addNewMovie(MovieName nameOfMovie) {

        MovieName[] tempPosters = new MovieName[posters.length + 1];
        System.arraycopy(posters, 0, tempPosters, 0, posters.length);
        tempPosters[posters.length] = nameOfMovie;
        posters = tempPosters;
    }

    //Manager's arts
    public MovieName[] getPosters() {
        return posters;
    }

    public MovieName[] findAll() {
        return posters;
    }

    public MovieName[] findLast() {

        int actualLength = resultLength;
        if (actualLength > posters.length) {
            actualLength = posters.length;
        }
        MovieName[] lastMovies = new MovieName[actualLength];

        for (int i = 0; i < actualLength; i++) {
            lastMovies[i] = posters[posters.length - 1 - i];
        }
        return lastMovies;
    }
}