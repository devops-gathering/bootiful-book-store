package io.devops.gathering.bootiful

import com.groovycoder.spockdockerextension.Testcontainers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.EnvironmentTestUtils
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE

@ContextConfiguration(initializers = Initializer)
@SpringBootTest(classes = BookStoreApplication)
@AutoConfigureTestDatabase(replace = NONE)
@Testcontainers
class BookRepositoryTests extends Specification {

    @Autowired
    BookRepository repository

    @Shared
    PostgreSQLContainer postgresContainer = new PostgreSQLContainer()
            .withDatabaseName("bootiful")
            .withUsername("bootiful")
            .withPassword("secret")

    static PostgreSQLContainer staticContainerHandle

    def setupSpec() {
        staticContainerHandle = postgresContainer
    }

    def "lists all existing books"() {
        expect: "empty repository is empty"
        repository.count() == 0
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            EnvironmentTestUtils.addEnvironment("testcontainers", configurableApplicationContext.getEnvironment(),
                    "spring.datasource.url=" + staticContainerHandle.jdbcUrl,
                    "spring.datasource.username=" + staticContainerHandle.username,
                    "spring.datasource.password=" + staticContainerHandle.password,
            )
        }
    }

}
