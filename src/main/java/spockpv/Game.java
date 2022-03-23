package spockpv;

/**
 * Class representing game logic
 * 
 * @author  Filip Wiśniewski
 */
public class Game {

  final Board initialBoard_; // initial state of the board
  final Board currentBoard_; // current state of the board

  /**
   * Parameter constructor
   * @param board board to play with
   */
  public Game(Board board) {
    currentBoard_ = board;
    initialBoard_ = (Board)board.clone();
  }

  /**
   * @return current game board (using pointer)
   */
  public Board getCurrentBoard() { return currentBoard_; }

  /**
   * Gane is won, when sum in every row and column is equal (1+2+...+n), where n
   * is width (or length) of the board
   * @return true, if game won
   */
  public boolean isWon() {

    Integer expectedRowSum = countSumN(currentBoard_.width());
    Integer expectedColumnSum = countSumN(currentBoard_.height());

    for (Integer rowSum : currentBoard_.countRowSums()) {
      if (rowSum != expectedRowSum) {
        return false;
      }
    }
    for (Integer columnSum : currentBoard_.countColumnSums()) {
      if (columnSum != expectedColumnSum) {
        return false;
      }
    }
    return true;
  }

  private Integer countSumN(Integer n) {
    // counts sum of (1, ..., n)
    Integer sum = 0;
    for (Integer i = 1; i <= n; i++) {
      sum = sum + i;
    }
    return sum;
  }

  /**
   * Tries putting value to certain coordinates
   * @param coordinates
   * @param value
   * @return true, if has succeed
   */
  public boolean tryPutValue(Coordinates coordinates, Character value) {
    if (initialBoard_.getCellValue(coordinates) != '0') {
      return false;
    }
    currentBoard_.setCellValue(value, coordinates);
    return true;
  }
}
