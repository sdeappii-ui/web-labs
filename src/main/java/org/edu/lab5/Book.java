package org.edu.lab5;

/**
 * Класс, представляющий книгу с автором и названием.
 */
public class Book {
    private String author;
    private String title;

    /**
     * Конструктор книги.
     * @param author автор книги
     * @param title название книги
     */
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    /**
     * Возвращает автора книги.
     * @return автор
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Возвращает название книги.
     * @return название
     */
    public String getTitle() {
        return title;
    }
}