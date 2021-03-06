package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private final DateTimeFormatter dateTimeFormatter;
    private List<String> books;
    private PrintStream printStream;

    public Library(List<String> books, PrintStream printStream, DateTimeFormatter dateTimeFormatter) {
        this.books = books;
        this.printStream = printStream;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public void listBooks() {
        StringBuilder compiledBooks = new StringBuilder();
        if(books.size()==0)
            printStream.println("");
        else {
            for (String book : books) {
                compiledBooks.append(book + ", ");
            }
            printStream.println(compiledBooks.toString());
        }
    }

    public void welcome(DateTime date) {
        String timeString = dateTimeFormatter.print(date);
        if(timeString=="")
            printStream.println("Welcome to the library!");
        else
            printStream.println("Welcome to the library! The current time is " + timeString);
    }
}
