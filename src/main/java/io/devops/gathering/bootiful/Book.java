package io.devops.gathering.bootiful;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * Ancient tome of Knowledge.
 */
@Entity
public class Book {

    @Id
    private String iban;

    private String title;
    private Author author;
    private String summary;

    @ManyToMany(mappedBy = "books")
    private Collection<Genre> associatedGenres;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Collection<Genre> getAssociatedGenres() {
        return associatedGenres;
    }

    public void setAssociatedGenres(Collection<Genre> associatedGenres) {
        this.associatedGenres = associatedGenres;
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
