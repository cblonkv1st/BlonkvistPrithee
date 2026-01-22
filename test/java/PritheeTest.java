import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PritheeTest {
    @Test
    void testInitialState() {
        Prithee game = new Prithee("hello world");
        assertEquals(0, game.getCorrect());
        assertEquals(0, game.getIncorrect());
    }

    @Test
    void testWinCondition() {
        Prithee game = new Prithee("test");
        game.registerCorrect();
        game.registerCorrect();
        game.registerCorrect();
        assertTrue(game.hasWon());
    }

    @Test
    void testLoseCondition() {
        Prithee game = new Prithee("test");
        game.registerIncorrect();
        game.registerIncorrect();
        game.registerIncorrect();
        assertTrue(game.hasLost());
    }


}