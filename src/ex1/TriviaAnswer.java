/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tal
 */
//@XmlRootElement
public class TriviaAnswer {

    private String answer;
    private boolean isTrue;
    
    public TriviaAnswer(boolean isTrue, String answer){
        this.answer = answer;
        this.isTrue = isTrue;
    }
    
    @XmlElement
    public String getAnswer(){
        return answer;
    }
    
    @XmlElement
    public boolean getIsTrue(){
        return isTrue;
    }
}
