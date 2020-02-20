package hello.sp;

import org.springframework.beans.factory.annotation.Autowired;
import hello.repository.QuestionRepository;

public class StoredFunction {

    @Autowired
    private QuestionRepository questionRepository;


}
