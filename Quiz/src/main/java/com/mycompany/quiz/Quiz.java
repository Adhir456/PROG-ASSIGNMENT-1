/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quiz;
import com.mycompany.quiz.Question;
import java.util.Scanner;


/**
 *
 * @author adhir
 */
public class Quiz {
    private final  Question[] questions;
    private final boolean[] correctFlags;
    
    private int totalMarks = 0;
    private int earnedMarks = 0;
    
    public Quiz(Question[] questions) {
        if (questions == null || questions.length == 0) {
            throw new IllegalArgumentException("Quiz needs at least one question");
        }
        this.questions = questions;
        this.correctFlags = new boolean[questions.length];
        for (Question q : questions) totalMarks += q.getMarks();
    }
    
    public void run(Scanner scanner) {
        System.out.println("=== Welcome to the Console Quiz ===\n");
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Q" + (i + 1) + "  (" + q.getMarks() + ")  " );
            System.out.print(q.render());
            String ans = scanner.nextLine();
            boolean correct = q.isCorrect(ans);
            correctFlags[i] = correct;
            if (correct) {
                earnedMarks += q.getMarks();
                System.out.println("Correct!\n");
            } else {
                System.out.println("X Incorrect. Correct answer: " + q.correctAnswer() + "\n");
            }
        }
        printReport();
    } 
    
    public void printReport() {
        System.out.println("\n================ QUIZ REPORT ================");
        for (int i = 0; i < questions.length; i++) {
            String status = correctFlags[i] ? "Correct" : "Wrong";
            System.out.printf("Q%-2d : %-7s (%d marks%s)\n", i + 1 , status,questions[i].getMarks(), questions[i].getMarks() == 1 ? "" : "s");
        }
        
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("TOTAL: %d / %d\n", earnedMarks, totalMarks);
        double percent = (earnedMarks * 100.0) / totalMarks;
        System.out.printf("SCORE: %.1f%%\n", percent);
        
        System.out.println("===============================================================");
    }

    public int getTotalMarks() {
        return totalMarks;
    }
    public int getEarnedMarks() {
        return earnedMarks;
    }
    public boolean[] getCorrectFlags() {
        return correctFlags.clone();
                
    }
    
}
