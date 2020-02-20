package hello.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

    private Long id;
    private String name;
    private String answer;


    public Question(){

    }

    public Question(String name, String answer) {
        this.name = name;
        this.answer = answer;
    }

    public Question(Long id, String name, String answer) {
        this.id = id;
        this.name = name;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
