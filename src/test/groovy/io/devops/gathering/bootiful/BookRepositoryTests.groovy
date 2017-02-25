package io.devops.gathering.bootiful

import com.groovycoder.spockdockerextension.Docker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE

@ContextConfiguration
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@Docker(image = "postgres", ports = ["5432:5432"])
class BookRepositoryTests extends Specification {

    @Autowired
    BookRepository repository

    def "lists all existing books"() {
        expect: "empty repository is empty"
        repository.count() == 0
    }

}
