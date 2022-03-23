package spockpv;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {

        BoardProvider boardProvider = new BasicBoardProvider();
        UserInterface ui = new ConsoleUserInterface();
        Board board = boardProvider.createBoard();

        Game game = new Game(board);
        play(game, ui);
    }

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

