package spockpv;

public class Board {
    /* Represents Sudoku board and its state */

    private final Integer[][] initialBoardState_;
    private Integer[][] currentBoardState_;

    public Board(BoardReader boardReader) {
        initialBoardState_ = boardReader.readBoard();
        currentBoardState_ = initialBoardState_.clone();
    }

    public boolean isCellModifiable(Coordinates at) {
        return initialBoardState_[at.x()][at.y()] == 0;
    }

    public void setCellValue(Integer to, Coordinates at) {
        currentBoardState_[at.x()][at.y()] = to;
    }

    public Integer getCellValue(Coordinates from) {
        return currentBoardState_[from.x()][from.y()];
    }

}
