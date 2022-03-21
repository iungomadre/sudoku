package spockpv;

public class Board {
    /* Represents Sudoku board and its state */

    private Character[][] boardState_;

    public Board(Character[][] initialBoardState) {
        boardState_ = initialBoardState;
    }

    public void setCellValue(Character to, Coordinates at) {
        boardState_[at.x()][at.y()] = to;
    }

    public Character getCellValue(Coordinates from) {
        return boardState_[from.x()][from.y()];
    }

    public Integer width() {
        return boardState_.length;
    }

    public Integer height() {
        return boardState_[0].length;
    }

}
