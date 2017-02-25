package io.devops.gathering.bootiful;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * It's like a tag, just not as digital.
 */
@Entity
public class Genre {

    @Id
    private String name;

    @ManyToMany()
    private Collection<Book> books;
}
