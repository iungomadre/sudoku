package spockpv;

public class BasicBoardProvider implements BoardProvider {

    @Override
    public Board createBoard() {

        Integer[][] initialBoardState = {
            {1, 2, 3},
            {4, 5, 6},
            {1, 0, 0}
        };
        return new Board(initialBoardState);
    }
}
