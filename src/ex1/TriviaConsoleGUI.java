/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Scanner;

/**
 * זאת המחלקה של התצוגה, השם שנתת לא התאים לפה, הוא מתאים ללוגיקה
 *
 * @author tal
 */
public class TriviaConsoleGUI {

    public void showQuestions() {
    }

    public static void main(String[] args) {
        // TODO code application logic here 
        // אביטל!!!!אה כן יכולה אפילו לעשות את התצוגה בפרויקט נפרד ואז להעתיק לפה את הקוד, לא חייב לעשות מחלקה חדשה לזה.. 
    }

    public void actionMenu() {
        Scanner s = new Scanner(System.in);
        TriviaGame TG = new TriviaGame();
        TG.loadFile();
        int action = 1;
        System.out.println("For Trivia questions, press 1");
        System.out.println("To add a Trivia question, press 2");
        System.out.println("To delete a Trivia question, press 3");

        while (0 > action && action > 3) {
            System.out.println("Invalid value, please try again");
            action = s.nextInt();
        }

        switch (action) {
            case 1:
                categoryMenu();
                break;
            case 2:
                String category;
                int difficultyLevel = 1;
                int questionType = 1;
                int numberOfOptions = 0;

                System.out.println("Type the requested category");
                category = s.next();

                System.out.println("Choose the requested difficulty level:"
                        + " 1 for easy, "
                        + "2 for medium, "
                        + "3 for hard");
                while (0 > difficultyLevel && difficultyLevel > 3) {
                    System.out.println("Invalid value, please try again");
                    difficultyLevel = s.nextInt();
                }

                System.out.println("Choose the requested kind of question:"
                        + "1 for open question,"
                        + " 2 for multiple options question, "
                        + "3 for yes\no question");
                while (0 > difficultyLevel && difficultyLevel > 3) {
                    System.out.println("Invalid value, please try again");
                    questionType = s.nextInt();
                }
                if (questionType == 2) {
                    System.out.println("Choose the number of options for your question");
                    while (1 > difficultyLevel) {
                        System.out.println("Invalid value, please try again");
                        numberOfOptions = s.nextInt();
                    }
                }
                if (numberOfOptions == 0) {
                    TG.add(category, difficultyLevel, questionType);
                } else {
                    TG.add(category, difficultyLevel, questionType, numberOfOptions);
                }

                break;
            case 3:
                TG.remove();
                break;
        }
    }
}
