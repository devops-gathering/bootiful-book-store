package io.devops.gathering.bootiful;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

/**
 * Writer of Wisdom.
 */
@Entity
public class Author {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private Collection<Book> publishedBooks;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Collection<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
