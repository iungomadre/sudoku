package spockpv;

public class Board {
    /* Represents Sudoku board and its state */

    private final Character[][] initialBoardState_;
    private Character[][] currentBoardState_;

    public Board(Character[][] initialBoardState) {
        initialBoardState_ = initialBoardState;
        currentBoardState_ = initialBoardState;
    }

    public boolean isCellModifiable(Coordinates at) {
        return initialBoardState_[at.x()][at.y()] == '0';
    }

    public void setCellValue(Character to, Coordinates at) {
        currentBoardState_[at.x()][at.y()] = to;
    }

    public Character getCellValue(Coordinates from) {
        return currentBoardState_[from.x()][from.y()];
    }

    public Integer width() {
        return initialBoardState_.length;
    }

    public Integer height() {
        return initialBoardState_[0].length;
    }

}
