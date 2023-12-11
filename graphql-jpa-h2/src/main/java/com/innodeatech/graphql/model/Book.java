package com.innodeatech.graphql.model;

import java.util.Arrays;
import java.util.List;

public record Book(Integer id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book(1, "Effective Java", 416, "author-1"),
            new Book(2, "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            new Book(3, "Down Under", 436, "author-3")
    );

    public static Book getById(Integer id) {
        return books.stream()
				.filter(book -> (book.id().equals(id)))
				.findFirst()
				.orElse(null);
    }
}
