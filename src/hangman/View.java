/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author phillipchan
 */
public class View {
    
    public char promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your guess?");
        String input = scanner.nextLine();
        char guess = input.charAt(0);
        return guess;
    }
    
    public void displayProgress(String formattedProgress, String hits, String misses, String guesses, int guessesLeft) {
        System.out.println(formattedProgress);
        System.out.println("Hits: " + hits);
        System.out.println("Misses: " + misses);
        System.out.println("Guesses: " + guesses);
        System.out.println("Gusses Left: " + guessesLeft);
    }
    
    public void userLost() {
        System.out.println("Sorry you lost. Try better next time!");
    }
}
