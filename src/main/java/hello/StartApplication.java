package hello;

import hello.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import hello.repository.QuestionRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QuestionRepository questionRepository;

    @Bean
    public LobHandler lobHandler() {
        return new DefaultLobHandler();
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args){

        log.info("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE questions IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE questions(" +
                "id SERIAL, name VARCHAR(255), answer VARCHAR(255))");

        List<Question> list = Arrays.asList(
                new Question("Question A", "Answer A"),
                new Question("Question B", "Answer B"),
                new Question("Question C", "Answer C"),
                new Question("Question D", "Answer D")
        );

        log.info("[SAVE]");
        list.forEach(question -> {
            log.info("Saving...{}", question.getName());
            questionRepository.save(question);
        });

        // find all
        log.info("[FIND_ALL] {}", questionRepository.findAll());


    }
}
