/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quiz;
import com.mycompany.quiz.Quiz;
import com.mycompany.quiz.Question.*;
import java.util.Scanner;

/*
QUIZ CONSOLE GAME BY ADHIR GUNIRAJH/ST10218840

This is a program that asks the user the following:
Multiple choice and true/false questions about java concepts which we learning 

FEATURES 

Stores questions in arrays
Uses loops to ask each question
Checks answers from the user and calculates marks of the answered questions 
At the end of the game it shows the report with score and the user marks

This application makes use of Arrays and Inheritance 
*/   


/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        Question[] bank = new Question[] {
            new MultipleChoiceQuestion("Which collection type has a fixed size?", 
            new String[] {"ArrayList", "LinkedList", "Array", "HashMap"}, 2,2),
            new TrueFalseQuestion("Java supports multiple inheritance with classes." ,false, 2),
            new MultipleChoiceQuestion("Which keyword is used to inherit a class?", new String[] {"this","super","extends","implements"},2,2),
            new TrueFalseQuestion("The JVM executes bytecode.", true, 2),
            new MultipleChoiceQuestion("Which index is the first element of a java array?", 
                    new String[] {"-1", "0", "1", "Depends on JVM"}, 1,2)
        
        };
        
        Quiz quiz = new Quiz(bank);
        try (Scanner sc = new Scanner(System.in)) {
            quiz.run(sc);
        }
    }
    
}
