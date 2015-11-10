/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;

/**
 *
 * @author tal
 */
public class TriviaQuestion {

    private int difficultyLevel;
    private String question;
    private boolean isOpen;
    private ArrayList<TriviaAnswer> answers;

    public TriviaQuestion(String question, boolean isOpen, int difficultyLevel) {
        this.question = question;
        this.isOpen = isOpen;
        this.difficultyLevel = difficultyLevel;
    }
    
    public boolean getType(){
        return isOpen;
    }
    
    public int getDifficulty(){
        return difficultyLevel;
    }

    public void addAnswers(TriviaAnswer ans) {
        answers.add(ans);
    }

    public ArrayList<TriviaAnswer> getAnswers() {
        return answers;
    }
}
