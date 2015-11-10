/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tal
 */
//@XmlRootElement
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
    
    @XmlAttribute(name="text")
    public String getQuestion(){
        return question;
    }
    
    @XmlElement
    public boolean getIsOpen(){
        return isOpen;
    }
    
    @XmlElement
    public int getDifficulty(){
        return difficulty;
    }

    public void addAnswers(TriviaAnswer ans) {
        answers.add(ans);
    }

    @XmlElement
    public ArrayList<TriviaAnswer> getAnswers() {
        return answers;
    }
}
