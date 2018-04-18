package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String vraag, antwoord;

    public Question() {}

    public Question(String vraag, String antwoord){
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    public String getVraag(){return this.vraag;}

    public String getAntwoord() {
        return antwoord;
    }

    @Override
    public String toString(){
        return "Question {" +
                "vraag = " + vraag +
                ", antwoord = '" + antwoord + '\'' +
                '}';
    }
}
