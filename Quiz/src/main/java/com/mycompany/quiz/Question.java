/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quiz;

/**
 *
 * @author admin
 */
public abstract class Question {
    
    private final String prompt;
    private final int marks;
    
    protected Question(String prompt, int marks) {
        this.prompt = prompt;
        this.marks = Math.max(1, marks);
                
    }
    
    public String getPrompt() {return prompt;}
    public int getMarks() {return marks;}
    
    public abstract String render();
    public abstract boolean isCorrect(String userAnswer);
    public abstract String correctAnswer();
    
    
    
}
