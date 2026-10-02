package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerTest {

    @Test
    void shouldReturnEmptyArrayWhenNoMovies() {
        MovieManager manager = new MovieManager();
        assertArrayEquals(new String[0], manager.findAll());
        assertArrayEquals(new String[0], manager.findLast());
    }

    @Test
    void shouldReturnAllMoviesInOrder() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnLast5InReverseOrder() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");

        String[] expected = {"Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnLessThanLimitIfNotEnoughMovies() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");

        String[] expected = {"Film 2", "Film 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldWorkWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2"};
        assertArrayEquals(expected, manager.findLast());
    }
}