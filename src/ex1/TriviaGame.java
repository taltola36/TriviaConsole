/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tal
 */
@XmlRootElement
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
        int counter = 0;
        for (int i = 0; i < categoris.size(); i++) {
            ArrayList<TriviaQuestion> questions = categoris.get(i).getQuestions();
            for (int j = 0; j < questions.size(); j++) {
                if (counter == qNum) {
                    categoris.get(i).deleteQuestion(j);
                }
                counter++;
            }
        }
    }

    public void saveToFile() {
        try {
            File file = new File("TriviaGame.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TriviaGame.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);
        } catch (Exception e) {
            String errMsg = e.getMessage();
        }
    }

    @XmlElement(name="category")
    public ArrayList<TriviaCategory> getCategories() {
        return categoris;
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
