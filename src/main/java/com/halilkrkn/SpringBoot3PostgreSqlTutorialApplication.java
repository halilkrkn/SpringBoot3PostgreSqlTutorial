package com.halilkrkn;

import com.halilkrkn.data.CustomerRepository;
import com.halilkrkn.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBoot3PostgreSqlTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3PostgreSqlTutorialApplication.class, args);
    }


/*    @GetMapping("/greet")
    public GreetResponse greet() {
        Language english = new Language("English");
        Language deutsch = new Language("Deutsch");
        GreetResponse response = new GreetResponse(
                "Hello World!",
                List.of("Java", "Kotlin", "Groovy"),
                List.of(english, deutsch, new Language("Turkish")),
                new Person("John", 42)
        );
        return response;
    }

    record Person(String name, int age) {
    }

    record Language(String name) {
    }

    record GreetResponse(
            String message,
            List<String> favoriteLanguages,
            List<Language> languages,
            Person person
    ) {
    }*/


}
