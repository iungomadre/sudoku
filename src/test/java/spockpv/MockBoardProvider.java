package spockpv;

public class MockBoardProvider implements BoardProvider {

    @Override
    public Board createBoard() {
        Character[][] boardState = {
            { '0', '1' },
            { '2', '0' },
            { '1', '3' }
        };
    return new Board(boardState);
    }
    
}
