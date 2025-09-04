/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.quiz.Quiz;
import com.mycompany.quiz.Question.*;
import com.mycompany.quiz.MultipleChoiceQuestion;
import com.mycompany.quiz.Question;
import com.mycompany.quiz.TrueFalseQuestion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author admin
 */
public class QuizTest {
    @Test
    void scoringWorksForAllCorrect(){
        Question[] qs = new Question[]{
            new TrueFalseQuestion("T?", true, 2),
            new MultipleChoiceQuestion("Pick A", new String[] {"A","B"}, 0, 3)
        };
        Quiz quiz = new Quiz(qs);
        
        assertTrue(qs[0].isCorrect("T"));
        assertTrue(qs[1].isCorrect("A"));
        
        assertEquals(5,quiz.getTotalMarks());
    }
    @Test 
    void mcValidation() {
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("?", new String[] {"A","B","C"}, 1, 2);
        
        assertTrue(mcq.isCorrect("b"));
        assertFalse(mcq.isCorrect("c"));
        assertEquals( "B", mcq.correctAnswer());
    }
    
    @Test 
    void tfValidation() {
        TrueFalseQuestion tf = new TrueFalseQuestion("Earth is round", true, 1);
        assertTrue(tf.isCorrect("true"));
         assertTrue(tf.isCorrect("T"));
         assertTrue(tf.isCorrect("F"));
         assertEquals("T", tf.correctAnswer());
    }
    
}
