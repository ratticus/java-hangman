package hangman;

/*
Copyright (c) Phillip Chan 2016

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

The Software shall be used for Good, not Evil.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

/**
 * This houses the game logic.
 * @author Phillip Chan
 * @version 2016-05-11
 */

public class Game {
    private String mAnswer;
    public int guesses;
    private char[] answerArray;
    private String mFormattedAnswer;
    private String mHits = "";
    private String mMisses = "";
    private String mGuesses = "";
    private int mGuessesLeft = 5;
    
    public Game(String newAnswer) {
        mAnswer = newAnswer;
        startGame();
    }
    
    private void startGame() {
        // turn answer to array
        answerArray = mAnswer.toCharArray();
        
        // format answer for the board
        mFormattedAnswer = formatAnswer("init", 'z');
        System.out.println(mFormattedAnswer);
        
        gameCycle();
    }
    
    private void gameCycle() {
        View view = new View();
        
        // try to guess
        char guess = view.promptForGuess();
        
        // return the result of the guess
        boolean result = applyGuess(guess);
        
        // show progress
        view.displayProgress(formatAnswer("progress", guess), getHits(), getMisses(), getGuesses(), getGuessesLeft());
        
        if (mGuessesLeft > 0 ) {
            gameCycle();
        } else {
            view.userLost();
        }
    }
       
    private String formatAnswer(String mode, char Guess) {
        String formattedString = "";
        char hitsArray[] = mHits.toCharArray();
        
        if (mode == "init") {
            for (int p = 0; p < answerArray.length; p++) {
                formattedString += "_ ";
            }
        } else {
            for (int p = 0; p < answerArray.length; p++) {
                for (int q = 0; q < hitsArray.length; q++) {
                    if (hitsArray[q] == answerArray[p]) {
                        formattedString += hitsArray[q];
                    } else {
                        formattedString += "_ ";
                    }
                }
            }
        }
       
        return formattedString;
    }
    
    private boolean checkIfGuessesBefore(char guess) {
        return false;
    }
    
    private boolean applyGuess(char guess) {
        boolean success = false;
        char successfulHit = '\0';
        
        // record guess
        mGuesses += guess;
        
        // loop through answer with guess to see if there's a match
        for (int x = 0; x < answerArray.length; x++) {
            if (guess == answerArray[x]) {
                success = true;
                successfulHit = answerArray[x];
                break;
            }
        }
        
        // if there's a match, add it to mHits
        if (success == true) {
            System.out.println("hit!!! \n");
            mHits += successfulHit;
        } 
        
        // if not, add the guess to misses and minus guesses left
        else {
            System.out.println("miss!!! \n");
            mMisses += guess;
             // minus guesses
            mGuessesLeft --;
        }
        
        return success;
    } 
        
    public String getHits() {
        return mHits;
    }
    
    public String getMisses() {
        return mMisses;
    }
    
    public String getGuesses() {
        return mGuesses;
    }
    
    public int getGuessesLeft() {
        return mGuessesLeft;
    }
}
