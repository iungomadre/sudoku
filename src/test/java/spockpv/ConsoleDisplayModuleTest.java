package spockpv;

import org.junit.Test;

public class ConsoleDisplayModuleTest {

    private final BoardProvider provider = new MockBoardProvider();
    private final Board board = provider.createBoard();
    private final DisplayModule underTest = new ConsoleDisplayModule();

    @Test
    public void testDraw() {
        underTest.draw(board);
    }
}
