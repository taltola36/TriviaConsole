/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaGameConsole;
import TriviaGameLogic.TriviaGame;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.lang.System.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class TriviaConsoleGUI {
    //File file = new File("file.txt");
    //BufferedReader buffRdr = null;
    static Scanner  s = new Scanner(System.in);
    static Random rand = new Random();
    static ArrayList<String> askedQuestions = new ArrayList<String>();
            
    public static void actionMenu() {
        
        //TG.loadFile(); // delete this method from triviaGame
        TriviaGame TG = TriviaGame.loadFromFile();
        
        int action = -1;
        System.out.println("Choose one of the following:");
        System.out.println("1 - Start game");
        System.out.println("2 - add a Trivia question");
        System.out.println("3 - delete a Trivia question");
        System.out.println("4 - save a Trivia question");
        
        action = s.nextInt();
        while (0 > action || action > 4 ) {
            System.out.println("Invalid value, please try again");
            action = s.nextInt();
        }
        
        switch(action) {
//            case 1: showMenu(TG); 
//                    break;
//            case 2: addQuestionMenu(TG);    //הוספת שאלה חדשה
//                    break;
//            case 3: showQuestionsMenu(TG);     //מחיקת שאלה קיימת
//                    break;
            case 4: saveQuestionsMenu(TG);     //שמירת שאלה חדשה
                    break;
        }
    }
    
    public static void saveQuestionsMenu(TriviaGame TG) {
        TG.saveToFile();
    }
    
//    public void showQuestionsMenu(TriviaGame TG) {
//        int i=0;
//        ArrayList<TriviaCategory> TCList = TG.getCategories();
//        ArrayList<TriviaQuestion> TQList;
//        System.out.println("Please enter the number of the relevant question you wish to delete");
//        for (TriviaCategory TC : TCList) {
//            TQList = TC.questions;
//            for (TriviaQuestion TQ : TQList) {
//                i++;
//                System.out.println(i + ", " + TQ.question);
//            }
//        }
//        TG.deleteQuestions(s.nextInt());
//    }
//    
//    public int showCategoriesToAdd(TriviaGame TG) {
//        ArrayList<TriviaCategory> TCList = TG.getCategories();
//        int count = 0;
//        int categoryNum;
//        System.out.println("Please enter the number of the relevant "
//                         + "category to add\n");
//        for (TriviaCategory TC : TCList) {
//            count++;
//            System.out.println(count +", " + TC.getNameOfCategory());
//        }
//        categoryNum = s.nextInt();
//        while (categoryNum > TCList.size()) {
//            System.out.println("Invalid value, please try again");
//            categoryNum = s.nextInt();
//        }
//        return categoryNum;
//    }
//    
//     public void addQuestionMenu(TriviaGame TG) {
//        String category, question;
//        boolean isOpen = false;
//        int difficultyLevel = 1, questionType = 1, numberOfOptions = 0, i=0;
//        TriviaQuestion TQ;
//        String[] ans;
//        ArrayList<String> answers = new ArrayList<String>();
//        
//        System.out.println("Type your question");
//        question = s.next();
//        
//        System.out.println("Choose the requested kind of question:"
//                            + "1 for open question,"
//                            + " 2 for multiple options question, "
//                            + "3 for yes\no question");
//        questionType = s.nextInt();        
//        while (0 > questionType && questionType > 3 ) {
//        System.out.println("Invalid value, please try again");
//        questionType = s.nextInt();
//        }
//        
//        if (questionType == 1)
//            isOpen = true;
//        else
//            isOpen = false;  
//        
//        System.out.println("Choose the requested difficulty level:"
//                        + " 1 for easy, "
//                        + "2 for medium, "
//                        + "3 for hard");
//        while (0 > difficultyLevel && difficultyLevel > 3 ) {
//            System.out.println("Invalid value, please try again");
//            difficultyLevel = s.nextInt();
//        }
//
//        System.out.println("Type the requested category");
//        category = s.next();
//        
//        TQ = new TriviaQuestion(question, isOpen, difficultyLevel);
//        
//        System.out.println("Type your answers line by line and then press ctrl+C");    
//        while (s.hasNext())
//            answers.add(s.nextLine()); 
//        ans = new String[answers.size()];
//        for (i=0; i<answers.size(); i++)
//            ans[i] = answers.get(i);
//        TG.addQuestion(question, isOpen, difficultyLevel, i, ans);        
//    }
//    
//     public ArrayList<String> showCategoriesToAnswer(TriviaGame TG) {
//        ArrayList<TriviaCategory> TCList = TG.getCategories();
//        ArrayList<String> categories = new ArrayList<String>();
//        int count = 0;
//        boolean check = false;
//        String category;
//        System.out.println("Please enter the relevant "
//                         + "categories to add line by line\n");
//        for (TriviaCategory TC : TCList) {
//            count++;
//            System.out.println(count +", " + TC.getNameOfCategory());
//        }
//        while (s.hasNext()) {           //check if the category wasn't mistyped
//            category = s.nextLine();
//            while (!check) {
//                for (TriviaCategory TC : TCList) {
//                    if (category.equals(TC.getNameOfCategory()))
//                        check = true;
//                }       
//                if (!check)
//                    System.out.println("Invalid value, please type another value instead");
//            }
//            check = false;
//            categories.add(category);
//        }
//        return categories;
//    } 
//  
//    public void showMenu(TriviaGame TG) {
//        ArrayList<String> cList = showCategoriesToAnswer(TG);   //the chosen categories
//        ArrayList<TriviaAnswer> answers;
//        removeDuplicates(cList);
//        String randomQuestion;
//        int i=0, answer;
//        
//        while (true) {    //while still playing.  
//            System.out.println("Enter ctrl+shift+del to stop the game at any time");                        
//            randomQuestion = getRandomQuestion(TG, cList);
//            System.out.println("Answer the question-");            
//            System.out.println(randomQuestion); 
//            System.out.println(); 
//            answers = TG.getAnswers(randomQuestion);
//            for (TriviaAnswer TA : answers) {
//                i++;
//                System.out.println(i + ", " + TA.answer);
//            }
//            answer = s.nextInt();
//            checkAnswer(answers, answer);   
//        }
//    }
//    
//    public void checkAnswer(ArrayList<TriviaAnswer> answers, int answer) {
//        int i=0;
//        for (TriviaAnswer TA : answers) {
//            i++;
//            if (i==answer) {
//                if (answers.get(i).isTrue)
//                    System.out.println("Correct answer");
//                else
//                    System.out.println("Wrong answer");            
//            }
//        }
//    }
//    
//    public boolean isAsked(String q) {
//        for (String ques : askedQuestions) {
//            if (q.equals(ques))
//                return true;
//        }
//        askedQuestions.add(q);
//        return false;
//    }
//    
//    public String getRandomQuestion(TriviaGame TG, ArrayList<String> cList) {
//        ArrayList<TriviaQuestion> questions;
//        TriviaCategory TC;
//        String randomCategory, randomQuestion;
//        int temp1, temp2;
//        
//        temp1 = rand.nextInt(cList.size());
//        randomCategory = cList.get(temp1);
//        TC = new TriviaCategory(randomCategory);
//        TC.nameOfCategory = randomCategory;        
//        questions = TG.showQuestions(TC);
//        temp2 = rand.nextInt(questions.size());
//        randomQuestion = TG.getCategories().get(temp1).getQuestions().get(temp2).question;
//        while(isAsked(randomQuestion)) {    //בוחר שאלה אחרת
//            temp1 = rand.nextInt(cList.size());
//            randomCategory = cList.get(temp1);
//            TC = new TriviaCategory(randomCategory);
//            TC.nameOfCategory = randomCategory;        
//            questions = TG.showQuestions(TC);
//            temp2 = rand.nextInt(questions.size());
//            randomQuestion = TG.categoris.get(temp1).questions.get(temp2).question;
//        }
//        return randomQuestion;
//    }
    
    public void removeDuplicates(ArrayList<String> cList) {
        HashSet<String> hs = new HashSet<String>();   //remove repeated elements
        hs.addAll(cList);
        cList.clear();
        cList.addAll(hs);
    }
}


