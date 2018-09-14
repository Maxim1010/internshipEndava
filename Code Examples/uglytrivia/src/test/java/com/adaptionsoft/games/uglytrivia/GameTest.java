package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    // specifies the player number used for tests
    public static final int TEST_PLAYER_NUMBER = 0;
    private Game game;

    @Before
    public void setUp() throws TooManyPlayersException {
        game = new Game();
        game.add("Alpha");
        game.add("Beta");
    }

    @Test(expected = TooManyPlayersException.class)
    public void shouldThrowExceptionForTooManyPlayers() throws TooManyPlayersException {
        game = new Game();
        for (int i = 1; i < 7; i++) {
            game.add(String.valueOf(i));
        }
    }

    @Test
    public void shouldAdvancePlayerOutsidePenaltyBox() {
        game.setCurrentPlayer(TEST_PLAYER_NUMBER);

        int numberOpPositions = 5;
        game.roll(numberOpPositions);

        assertEquals(numberOpPositions, game.places[TEST_PLAYER_NUMBER]);
    }

    @Test
    public void shouldAdvancePlayerInPenaltyBoxWhenItRolledAnOddDice() {
        game.setCurrentPlayer(TEST_PLAYER_NUMBER);
        game.inPenaltyBox[TEST_PLAYER_NUMBER] = true;

        int numberOfPositions = 5;
        game.roll(numberOfPositions);

        assertEquals("Expected to advance 5 positions",
                numberOfPositions, game.places[TEST_PLAYER_NUMBER]);
        assertTrue("Expected the player to get out of the penalty box",
                game.isGettingOutOfPenaltyBox);
    }

    @Test
    public void playerShouldRemainInPenaltyBoxWhenItRolledAnEvenDice() {
        game.setCurrentPlayer(TEST_PLAYER_NUMBER);
        game.inPenaltyBox[TEST_PLAYER_NUMBER] = true;

        int numberOfPositions = 2;
        game.roll(numberOfPositions);

        assertEquals("Expected to remain in the same position",
                TEST_PLAYER_NUMBER, game.places[TEST_PLAYER_NUMBER]);
        assertFalse("Expected the player to remain in the penalty box",
                game.isGettingOutOfPenaltyBox);
    }

}
