package hangman;


import org.json.*;

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
    public String answer;
    public int guesses;
    public String category;
    private String mHits;
    private String mMisses;
    private int mGuessesLeft;
    
    /*
        Our game constructor
        First it will get the answer to be used for the game
    */
    public Game() {
        getGameAnswer();
    }
    
    private void getGameAnswer() {
        // JSONObject obj = new JSONObject(" ... ");
        // have to finish this
    }
    
    public String getHits() {
        return mHits;
    }
    
    public String getMises() {
        return mMisses;
    }
    
    public int getGuessesLeft() {
        return mGuessesLeft;
    }
}
