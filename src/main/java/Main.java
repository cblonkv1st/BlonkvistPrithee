
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
    Scanner scan = new Scanner(System.in); //setting up for user input
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
    Prithee game = new Prithee(sonnet);
     while (!game.hasWon() && !game.hasLost()) {

        String word = game.getRandomWord();

        // Sonnet finished
        if (word == null) {
            System.out.println("Sonnet complete!");
            break;
        }
         int wordIndex = game.getIndex();

        // IMPORTANT: split the SAME way Prithee does
         String[] words = sonnet.split(" ");

        // print words BEFORE the blank
         for (int i = 0; i < wordIndex; i++) {
             System.out.println(words[i] + " ");
         }

        // print blank and STOP
         System.out.println("_".repeat(word.length()));
        // Create blanks based on word length
        String blanks = "_".repeat(word.length());

        System.out.println("Fill in the missing word:");
        System.out.println(blanks);

        String guess = scan.nextLine().trim();

        if (guess.equalsIgnoreCase(word)) {
            System.out.println("Correct!");
            game.registerCorrect();
        } else {
            System.out.println("Incorrect. The word was: " + word);
            game.registerIncorrect();
        }

        System.out.println();
    }

        if (game.hasWon()) {
        System.out.println("You win!");
    } else if (game.hasLost()) {
        System.out.println("You lose!");
    }

        scan.close();
}
}
