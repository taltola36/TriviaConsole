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
public class TriviaGame {

    private ArrayList<TriviaCategory> categoris;

    public ArrayList<TriviaQuestion> showQuestions(TriviaCategory category) {
        ArrayList<TriviaQuestion> ques;
        ques = category.getQuestions();
        return ques;
    }

    public void addQuestion(String question, boolean isOpen, int difficultyLevel, int category, String... answers) {
        categoris.get(category).addQuestion(question, isOpen, difficultyLevel, answers);

    }

    public void deleteQuestions(int qNum) {
    }

    public void saveToFile() {
    }

    public void loadFile() {
        // for testing
        categoris = new ArrayList<>();
        categoris.add(new TriviaCategory("Movies"));
        categoris.add(new TriviaCategory("History"));
        categoris.add(new TriviaCategory("Animals"));

        categoris.get(0).addQuestion("באיזה סרט שיחק..?", true, 1, "בלהבלה");
        categoris.get(0).addQuestion("באיזה סרט לא שיחק..?", false, 2, "בלהבלה", "בלהבלהבהל");        
        categoris.get(1).addQuestion("מתי הייתה מלחמת העולם הראשונה...?", false, 2, "בלהבלה", "בלהבלהבהל");
        categoris.get(2).addQuestion("לאיזה חיה יש...?", true, 2, "כלב");

    }
}
