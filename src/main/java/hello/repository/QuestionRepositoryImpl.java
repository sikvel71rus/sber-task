package hello.repository;

import hello.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    LobHandler lobHandler;


    @Override
    public int save(Question question) {
        return jdbcTemplate.update(
                "insert into questions (name, answer) values(?,?)",
                question.getName(),question.getAnswer());
    }


    @Override
    public List<Question> findAll() {
        return jdbcTemplate.query(
                "select * from questions",
                        (rs, rowNum)-> new Question(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("answer")
                )
        );
    }
}
