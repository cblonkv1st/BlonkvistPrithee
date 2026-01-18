import java.util.Random;
import java.util.Scanner;

public class Prithee {

    public static void main(String[] args) {
        runTests();
        Scanner scan = new Scanner(System.in); //setting up for user input
        Random rand = new Random(); // setting up for random index
        String sonnet = "Two households, both alike in dignity, " +
                "In fair Verona, where we lay our scene, " +
                "From ancient grudge break to new mutiny, " +
                "Where civil blood makes civil hands unclean. " +
                "From forth the fatal loins of these two foes " +
                "A pair of star-cross’d lovers take their life; " +
                "Whose misadventured piteous overthrows " +
                "Do with their death bury their parents’ strife. " +
                "The fearful passage of their death-mark’d love, " +
                "And the continuance of their parents’ rage, " +
                "Which, but their children’s end, nought could remove, " +
                "Is now the two hours’ traffic of our stage; " +
                "The which if you with patient ears attend, " +
                "What here shall miss, our toil shall strive to mend."; //could be replaced with something to make it not fixed
        String[] sonnetWords = sonnet.split(" ");//split text @ spaces
        int correct = 0;//initialize # of correct
        int incorrect = 0;//initialize # of incorrect
        int prevIndex = -1;// initialize previous index
        int index;
        while (true) { //generate index greater than previous
            do {
                index = rand.nextInt(sonnetWords.length);
            } while (index <= prevIndex);
            prevIndex = index;
            for (int i = 0; i < index; i++) { //print words up to index
                System.out.println(sonnetWords[i] + " ");
            }

            String hiddenWord = sonnetWords[index]; //set next word to hiddenWord
            for (int i = 0; i < hiddenWord.length(); i++) {
                System.out.print("_");
            }// print next words as _____ with number of spaces per letter
            System.out.println();
            System.out.print("Guess the hidden word: ");  //ask for user input
            String guess = scan.nextLine();
            if (isCorrectGuess(guess, hiddenWord)) {
                //if input is the same as hidden word
                correct++; //print correct and increase correct
                System.out.println("Correct!");
            } else {
                incorrect++; //else print incorrect and increase incorrect
                System.out.println("Incorrect. The word was: " + hiddenWord);
            }
            System.out.println("Correct: " + correct + " | Incorrect: " + incorrect);
            System.out.println();
            //end conditions
            if (correct == 3) { //3 right
                System.out.println("Yay! You won!");
                break;
            } else if (incorrect == 3) { // 3 wrong
                System.out.println("You lost! Game over.");
                break;
            }
            if (prevIndex >= sonnetWords.length - 1) { //end of sonnet
                System.out.println("End of sonnet! Goodbye.");
                break;
            }
        }
        scan.close();


    }

    public static boolean isCorrectGuess(String guess, String hiddenWord) {
        return guess.equals(hiddenWord);
    }

    public static void runTests() {
        System.out.println("Running tests...");

        // test 1: exact match should be true
        if (isCorrectGuess("Two", "Two")) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 FAILED");
        }

        // test 2: mismatch should be false
        if (!isCorrectGuess("Three", "Two")) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 FAILED");
        }

        // test 3: punctuation matters (expected false)
        if (!isCorrectGuess("dignity", "dignity,")) {
            System.out.println("Test 3 passed!!");
        } else {
            System.out.println("Test 3 FAILED!!");
        }

        System.out.println("Tests complete!\n");
    }

}