package spockpv;

public class ConsoleDisplayModule implements DisplayModule {

    @Override
    public void draw(Board board) {
        drawDelimiter(board.width());
        for (Integer row = 0; row < board.height(); row++) {
            drawLine(board, row);
            drawDelimiter(board.width());
        }
    }

    private void drawLine(Board board, Integer lineNumber) {
        for (Integer col = 0; col < board.width(); col++) {
            System.out.print("| ");
            System.out.print(board.getCellValue(new Coordinates(col, lineNumber)));     
            System.out.print(" ");
        }
        System.out.print("|\n");  
    }

    private void drawDelimiter(Integer cellsNumber) {
        for (Integer col = 0; col < cellsNumber; col++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
    }
}
