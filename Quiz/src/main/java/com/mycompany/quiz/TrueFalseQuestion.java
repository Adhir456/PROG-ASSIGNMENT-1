/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quiz;

/**
 *
 * @author admin
 */
public class TrueFalseQuestion extends Question {
    private final boolean correct;
    
    public TrueFalseQuestion(String prompt, boolean correct, int marks) {
        super(prompt, marks);
        this.correct = correct;
    }
    
    @Override
    public String render() {
        return getPrompt() + " (T/F): ";
    }
    
    @Override
    public boolean isCorrect(String userAnswer) {
        if (userAnswer == null) return false;
        String a = userAnswer.trim().toLowerCase();
        boolean val = a.startsWith("t") || a.equals("true");
        boolean valF = a.startsWith("f") || a.equals("false");
        if (!val && !valF) return false;
        return val == correct;
    }
    
    @Override
    public String correctAnswer() {
        return correct ? "T" : "F";
    }
    
    
}
