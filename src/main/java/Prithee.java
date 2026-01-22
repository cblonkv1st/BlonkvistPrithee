import java.util.Random;

public class Prithee {
    private String[] words; // where the broken sonnet will be stored
    private int correct; //num of correct answers
    private int incorrect; // num of incorrect answers
    private int index; //word removal choice for question
    private int previousIndex;
    private final Random rand; // random index for choosing words


    public Prithee(String sonnet) {
        this.words = sonnet.split(" ");//split text @ spaces
        this.correct = 0;//initialize # of correct
        this.incorrect = 0;//initialize # of incorrect
        this.index = 0; // initialize index to beginning of sonnet
        this.previousIndex = -1; // no prev index when initialized
        this.rand = new Random();

    }

    public String getRandomWord() {
        if (words.length == 0) {
            return "";
        }

        int start = previousIndex + 1;

        // If we're at the end, wrap
        if (start >= words.length) {
            return null; // honestly not sure if this is the best way to go about it
        }
        previousIndex = index; //set prev index
        index = start + rand.nextInt(words.length - start); // get next random word

        return words[index];
    }


    public void registerCorrect() {
        correct++;
    }

    public void registerIncorrect() {
        incorrect++;
    }

    // end conditions below
    public boolean hasWon() {
        return correct >= 3;
    }

    public boolean hasLost() {
        return incorrect >= 3;
    }
    public boolean isSonnetComplete() {
        return previousIndex >= words.length - 1;
    }

    public int getPreviousIndex() {
        return previousIndex;
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }
    public int getIndex() {
        return index;
    }
}