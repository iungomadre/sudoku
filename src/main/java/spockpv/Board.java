package spockpv;

/**
 * Represents game board and its state
 *
 * @author  Filip Wiśniewski
 */
public class Board implements Cloneable {

  private Character[][] boardState_;

  /**
   * Parameter constructor
   *
   * @param initialBoardState array representing board[at_x][at_y]
   */
  public Board(Character[][] initialBoardState) {
    boardState_ = initialBoardState;
  }

  /**
   * Sets value to value at certain coordinates
   * @param to  what to change value for
   * @param at  where to change it
   */
  public void setCellValue(Character to, Coordinates at) {
    boardState_[at.x()][at.y()] = to;
  }

  /**
   * Gets value at coordinates specified
   * @param from
   * @return  character at coordinates passed
   */
  public Character getCellValue(Coordinates from) {
    return boardState_[from.x()][from.y()];
  }

  /**
   * @return board width
   */
  public Integer width() { return boardState_.length; }

  /**
   * @return board height
   */
  public Integer height() { return boardState_[0].length; }

  /**
   * Implementation of Java's equals operator
   * Compares values, not addresses
   * @param o object to compare with
   * @return is equal
   */
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
        if (this.boardState_[i][j] != compared.boardState_[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * @return deep copy of object
   * Requires casting in order to get proper type
   */
  @Override
  public Object clone() {

    Character[][] newBoardState =
        new Character[this.boardState_.length][this.boardState_[0].length];

    for (Integer i = 0; i < this.boardState_.length; i++) {
      for (Integer j = 0; j < this.boardState_[i].length; j++) {
        newBoardState[i][j] = this.boardState_[i][j];
      }
    }

    return new Board(newBoardState);
  }

  /**
   * Counts sum of digits in every row
   * @return array of sums in every row
   */
  public Integer[] countRowSums() {
    Integer[] sums = new Integer[this.height()];
    Integer sum;

    for (int y = 0; y < this.height(); y++) {
      sum = 0;
      for (int x = 0; x < this.width(); x++) {
        sum = sum + Character.getNumericValue(boardState_[x][y]);
      }
      sums[y] = sum;
    }
    return sums;
  }

  /**
   * Counts sum of digits in every column
   * @return array of sums in every column
   */
  public Integer[] countColumnSums() {
    Integer[] sums = new Integer[this.width()];
    Integer sum;

    for (int x = 0; x < this.width(); x++) {
      sum = 0;
      for (int y = 0; y < this.height(); y++) {
        sum = sum + Character.getNumericValue(boardState_[x][y]);
      }
      sums[x] = sum;
    }
    return sums;
  }
}
