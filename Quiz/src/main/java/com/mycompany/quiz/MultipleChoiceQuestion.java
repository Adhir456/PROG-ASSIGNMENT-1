/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quiz;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class MultipleChoiceQuestion extends Question {
    
    private final String[] options;
    private final int correctIndex;
    
    public MultipleChoiceQuestion(String prompt, String[] options, int correctIndex, int marks) {
        super (prompt, marks);
        if (options == null || options.length < 2 ) {
            throw new IllegalArgumentException("At least two options required");
        }
        if (correctIndex < 0 || correctIndex >= options.length){
            throw new IllegalArgumentException ("Correct index out of range");
        }
        this.options = Arrays.copyOf(options, options.length);
        this.correctIndex = correctIndex;
    }
    
    @Override
    public String render (){
        StringBuilder sb = new StringBuilder(getPrompt()).append("\n");
        char label = 'A';
        for (String opt : options) {
            sb.append("  ").append(label++).append(")  ").append(opt).append("\n");
        }
        sb.append("Enter option letter(A-").append((char)('A' + options.length - 1)).append("):");
        return sb.toString();
        
    }
    
    @Override
    public boolean isCorrect (String userAnswer) {
        if (userAnswer == null || userAnswer.isBlank())
            return false;
        char c = Character.toUpperCase(userAnswer.trim().charAt(0));
        int idx = c - 'A';
        return idx == correctIndex;
    }
    
    @Override
    public String correctAnswer() {
        return String.valueOf((char)('A' + correctIndex));
    }
    
    
}
