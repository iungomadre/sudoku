package spockpv;

public class Board implements Cloneable {
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

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Board)) {
            return false;
        }

        Board compared = (Board)o;
        for (int i = 0; i < compared.boardState_.length; i++) {
            for (int j = 0; j < compared.boardState_[i].length; j++) {
                if (this.boardState_[i][j] != compared.boardState_[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Object clone() {

        Character[][] newBoardState = new Character[this.boardState_.length][this.boardState_[0].length];

        for (Integer i = 0; i < this.boardState_.length; i++) {
            for (Integer j = 0; j < this.boardState_[i].length; j++) {
                newBoardState[i][j] = this.boardState_[i][j];
            }
        }

        return new Board(newBoardState);
    }
}
