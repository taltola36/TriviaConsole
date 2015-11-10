/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaGameLogic;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author tal
 */
@XmlRootElement(name = "triviaGame")
public class TriviaGame {

    private ArrayList<TriviaCategory> categoris;

    public TriviaGame() {
        this.categoris = new ArrayList<>();
    }

    @XmlElement(name = "category")
    public ArrayList<TriviaCategory> getCategories() {
        return categoris;
    }

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
        } catch (Exception e) {
            String errMsg = e.getMessage();
        }
    }

//    public void loadFile() {
//        // for testing
//        categoris = new ArrayList<>();
//        categoris.add(new TriviaCategory("Movies"));
//        categoris.add(new TriviaCategory("History"));
//        categoris.get(0).addQuestion("מי כוכב הסרט אייר פורס 1?", true, 1, "אריסון פורד");
//        categoris.get(0).addQuestion("בסרט פורסט גאמפ מה כוכב הסרט מכר שגרם להתעשר?", true, 2, "שרימפס");
//        categoris.get(0).addQuestion("איזה סרט פרסם את אושרי כהן?", true, 3, "הכוכבים של שלומי");
//        categoris.get(0).addQuestion("?האם ג'קי צ'אן היה ניצב בסרטיו של ברוס לי", false, 1, "yes", "no");
//        categoris.get(0).addQuestion("באיזה סרט מופיע ג'אפר?", false, 2, "Aladin", "Pokahontas", "Mulan");
//        categoris.get(0).addQuestion("עלילת הסרט הבופור התרחשה ב?", false, 3, "Lebanon", "Eygept", "Yarden");
//        categoris.get(1).addQuestion("איזו עיר בישראל נקראת על שמו של הקיסר הרומי טיבריוס", true, 1, "טבריה");
//        categoris.get(1).addQuestion("חכם יווני הנחשב לאבי תורת הגיאומטריה", true, 2, "אוקלידס");
//        categoris.get(1).addQuestion("כינויי של חברי המפלגה הקומוניסטית ברוסיה לפני עלייתם לשלטון", true, 3, "בולשביקים");
//        categoris.get(1).addQuestion("האם מדינת ישראל הוקמה ב1948", false, 1, "yes", "no");
//        categoris.get(1).addQuestion("שם החללית הרוסית הראשונה בחלל", false, 3, "Spotnic", "Farom", "Halalit");
//    }

    public static TriviaGame loadFromFile() {

        TriviaGame game = new TriviaGame();
        try {
            File fXmlFile = new File("TriviaGame.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList listCat = doc.getElementsByTagName("category");
            for (int i = 0; i < listCat.getLength(); i++) {

                Node nNode = listCat.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eCat = (Element) nNode;
                    String catName = eCat.getAttribute("name");

                    TriviaCategory category = new TriviaCategory(catName);

                    // get category questions
                    NodeList listQues = eCat.getElementsByTagName("question");
                    for (int j = 0; j < listQues.getLength(); j++) {
                        Node node = listQues.item(j);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            // get the question text
                            Element eQues = (Element) node;

                            // get the text
                            String quesText = eQues.getAttribute("text");

                            // get the question difficulty
                            String quesDifficulty = eQues.getElementsByTagName("difficulty").item(0).getTextContent();

                            // get the question isOpen
                            String quesIsOpen = eQues.getElementsByTagName("isOpen").item(0).getTextContent();

                            // get the answers
                            ArrayList<String> answers = new ArrayList<>();
                            NodeList listAns = eQues.getElementsByTagName("answer");
                            for (int k = 0; k < listAns.getLength(); k++) {
                                Node nodeAn = listAns.item(k);
                                if (nodeAn.getNodeType() == Node.ELEMENT_NODE) {
                                    Element eAns = (Element) nodeAn;

                                    // get the text
                                    String ansText = eAns.getAttribute("text");
                                    answers.add(ansText);
                                }
                            }

                            String[] arrAns = new String[answers.size()];
                            answers.toArray(arrAns);

                            category.addQuestion(quesText, Boolean.parseBoolean(quesIsOpen), Integer.parseInt(quesDifficulty), arrAns);
                        }
                    }

                    game.categoris.add(category);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return game;
    }
}
