package spockpv;

import org.junit.Test;

public class ConsoleDisplayModuleTest {

    private BoardProvider provider = new BoardProvider() {
        public Board createBoard() {
            Integer[][] boardState = {
                    { 0, 1 },
                    { 2, 0 },
                    { 1, 3 }
            };
            return new Board(boardState);
        };
    };
    private final Board board = provider.createBoard();
    private final DisplayModule underTest = new ConsoleDisplayModule();

    @Test
    public void testDraw() {
        underTest.draw(board);
    }
}
