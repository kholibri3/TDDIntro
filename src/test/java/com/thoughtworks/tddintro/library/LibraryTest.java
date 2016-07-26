package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private List<String> books;
    private PrintStream printStream;
    private DateTime time;
    private DateTimeFormatter dateTimeFormatter;
    private Library library;

    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        time = new DateTime();
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        library.listBooks();
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // implement me
        books.add("Harry Potter");
        books.add("Ishmael");
        library.listBooks();

        verify(printStream).println("Harry Potter, Ishmael, ");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");
        library.welcome(time);

        // add a verify here
        verify(printStream).println("Welcome to the library!");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        // then move common test variables into a setup method

        when(dateTimeFormatter.print(time)).thenReturn("2016-07-21 13:43:17");
        library.welcome(time);

        // add a verify here
        verify(printStream).println("Welcome to the library! The current time is 2016-07-21 13:43:17");

    }
}
