package io.devops.gathering.bootiful;

import javax.persistence.*;

/**
 * Ancient tome of Knowledge.
 */
@Entity
public class Book {

    @Id
    private String iban;

    private String author;

    private String title;
    private String summary;

    private String genre;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return iban != null ? iban.equals(book.iban) : book.iban == null;
    }

    @Override
    public int hashCode() {
        return iban != null ? iban.hashCode() : 0;
    }
}
