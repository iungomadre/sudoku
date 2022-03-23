package spockpv;
/**
 * Sudoku is a simple console game that displays board on standard output
 *
 * @author  Filip Wiśniewski
 */
public class Sudoku {

  /**
   * Main method that runs game
   * @param args unused
   */
  public static void main(String[] args) {

    BoardProvider boardProvider = new BasicBoardProvider();
    UserInterface ui = new ConsoleUserInterface();
    Board board = boardProvider.createBoard();

    Game game = new Game(board);
    play(game, ui);
  }

  /**
   * Runs whole game synchronously until won
   * @param game object to be played
   * @param ui user interface
   */
  private static void play(Game game, UserInterface ui) {
    Integer movesNumber = 0;

    while (!game.isWon()) {
      movesNumber++;

      ui.draw(game.getCurrentBoard());

      if (!game.tryPutValue(ui.getCoords(), ui.getValue())) {
        ui.promptUnmodifiableCell();
      }
    }
    ui.promptGameWon(movesNumber);
  }
}
