package hangmanapplication;

import java.io.IOException;
import java.util.Scanner;


public class HangmanApplication {

    public static void main(String[] args)throws IOException  {
        //How do we play the game 
        Scanner sc = new Scanner (System.in);
        System.out.println("Welcome to hangman ! I will pick  a word and you will try to guess it character by character "
        +".\nIf you guess wrong 6 times ,then I win . If you can guess it before then you win . "
        +"Are you Ready ? I hope so because I am");
        System.out.println();
        System.out.println("\nI have picked my word .Below is a picture ,"
                + " and below that is your current guess .Which starts off as nothing. "
                + "\nEvery time you guess incorrectly I add a body part to the picture.When there is a full "
                + "person , you lose");
        //Allows for multiple games 
        boolean doYouWantToPlay = true ;
        while (doYouWantToPlay){
            //setting up the game             
            System.out.println("Alright let's play! ");
            Hangman game = new Hangman();
             do{
                // Draw the things 
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println(game.mysteryWord);
                System.out.println();
                
                // Get the Guess 
                System.out.println("Enter a character that you think is in the word ");
                char guess =(sc.next().toLowerCase()).charAt(0);
                System.out.println();
                
                //check if the charcter is guessed already 
                
                    while (game.isGuessedAlready(guess)){
                        System.out.println("Try again! You've already guessed that charcter ");
                        guess = (sc.next().toLowerCase()).charAt(0);
                    }
                    //Play the guess 
                    if (game.playGuess(guess)){
                        System.out.println("Great Guess! That character is in the word!");
                    }else {
                        System.out.println("Unfortunately that charcter isn't  in the word");
                    }
                
            }
            while (!game.gameOver ());//Keep playing untill the game is over 
            // play again or no ?
            System.out.println();
            System.out.println("Do you want to play another game press  Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');            
        }
    }    
}
