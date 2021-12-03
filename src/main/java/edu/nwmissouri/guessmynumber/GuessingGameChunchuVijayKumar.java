package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *
 * Original Source: https://hackr.io/blog/java-projects
 *
 * Read about jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Vijay Kumar Chunchu
 */
public class GuessingGameChunchuVijayKumar {

    public static void main(String[] args) {
        // TODO: change randomNumber to secretNumber Hint: Right-click / Refactor / Rename
        int randomNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + randomNumber);
        int count = 1;

        while (userAnswer != randomNumber) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is always null (no parent)
            // message = "Enter a guess between 1 and 100" // what type?
            // title = "Guessing Game" // what type?
            // messageType = JOptionPane.INFORMATION_MESSAGE
            // Works the same as original 3 but more expressive - this is an example of a what? Hint: enum
            String message = "Enter a gusess between 1 and 100";//What type?
            String tittle = "Guessing Game";//what type?
            int messageType = JOptionPane.INFORMATION_MESSAGE;
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + evaluateGuess(userAnswer, randomNumber, count));
            count++;
        }
    }

    // TODO: Refactor / Rename determineGuess to calculateMessage
    public static String evaluateGuess(int userAnswer, int randomNumber, int count) {
        // TODO: Instead of "Try Number" which sounds like we should try that as a guess...
        // Say "You've used " + count + guesses.
        // If count is one, use "guess", else use "guesses" HINT: Ternary operator
        String s =(count==1)? "guess":"guesses";
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == randomNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > randomNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count+s;
        } else if (userAnswer < randomNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count+s;
        } else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}