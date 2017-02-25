package io.devops.gathering.bootiful

import com.groovycoder.spockdockerextension.Docker
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification


@ContextConfiguration
@SpringBootTest
class BookStoreApplicationTests extends Specification {

    def "should boot up"() {
        expect:
        true
    }



}
