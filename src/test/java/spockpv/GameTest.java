package spockpv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {

    Character[][] initialBoardState = {
        {'1', '0', '2'},
        {'2', '1', '3'},
        {'3', '2', '1'}
    };
    Board board = new Board(initialBoardState);
    Game game = new Game(board);

    @Test
    public void testGetCurrentBoardReturnsProperBoard() {
        // given
        Board expected = board;

        // when
        Board actual = game.getCurrentBoard();
        
        // then
        assertSame(expected, actual);
    }

    @Test
    public void testGameIsWon() {
        // given
        Character[][] wonBoardState = {
            {'1', '3', '2'},
            {'2', '1', '3'},
            {'3', '2', '1'}
        };
        Board wonBoard = new Board(wonBoardState);
        Game wonGame = new Game(wonBoard);
        
        // when
        boolean isWon = wonGame.isWon();

        // then
        assertTrue(isWon);
    }

    @Test
    public void testGameIsNotWon() {
        // when
        boolean isWon = game.isWon();

        // then
        assertFalse(isWon);
    }

    @Test
    public void testTryPutValueFails() {
        // given
        Coordinates coordinates = new Coordinates(0, 0);
        Character value = 'x';

        // when
        boolean result = game.tryPutValue(coordinates, value);

        // then
        assertFalse(result);
    }

    @Test
    public void testTryPutValueSucceeds() {
        // given
        Coordinates coordinates = new Coordinates(0, 1);
        Character value = 'x';

        // when
        boolean result = game.tryPutValue(coordinates, value);

        // then
        assertTrue(result);
    }
}
