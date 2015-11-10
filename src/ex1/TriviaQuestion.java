/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author tal
 */
@XmlType(name = "question")
public class TriviaQuestion {

    private int difficulty;
    private String question;
    private boolean isOpen;
    private ArrayList<TriviaAnswer> answers;

    public TriviaQuestion(String question, boolean isOpen, int difficultyLevel) {
        this.answers = new ArrayList<>();
        this.question = question;
        this.isOpen = isOpen;
        this.difficulty = difficultyLevel;
    }

    @XmlAttribute(name = "text")
    public String getQuestion() {
        return question;
    }

    @XmlElement(name = "isOpen")
    public boolean getIsOpen() {
        return isOpen;
    }

    @XmlElement(name = "difficulty")
    public int getDifficulty() {
        return difficulty;
    }

    @XmlElement(name = "answer")
    public ArrayList<TriviaAnswer> getAnswers() {
        return answers;
    }

    public void addAnswers(TriviaAnswer ans) {
        answers.add(ans);
    }
}
