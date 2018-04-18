package edu.ap.spring.view;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.awt.event.ActionEvent;

@Service
public class EventHandler {

    private UI ui;
    private QuestionRepository repository;

    @Autowired
    public void setRepository(QuestionRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent actionEvent){

        String vraag = ui.getQuestion().getText();
        String antwoord = ui.getAnswer().toString();
        Question question = new Question(vraag, antwoord);
        repository.save(question);

        System.out.println(question.toString() + " saved in repository");
        System.out.println("Find all : ") ;
        repository.findAll().forEach(System.out::println);
    }
}
