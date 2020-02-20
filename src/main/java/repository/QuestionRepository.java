package repository;

import model.Question;

import java.util.List;

public interface QuestionRepository {

    int save(Question question);

    List<Question> findAll();



}
