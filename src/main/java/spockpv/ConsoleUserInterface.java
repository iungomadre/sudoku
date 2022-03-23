package spockpv;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    Scanner scanInput = new Scanner(System.in);
    
    @Override
    public Coordinates getCoords() {
        System.out.print("\nPlease insert coordinates:\nx: ");
        Integer x = Integer.parseInt(scanInput.nextLine());
        System.out.print("y: ");
        Integer y = Integer.parseInt(scanInput.nextLine());
        return new Coordinates(x, y);
    }

    @Override
    public Character getValue() {
        System.out.print("\nPlease insert value:\nx: ");
        Character value = scanInput.nextLine().charAt(0);
        return value;
    }
    
    @Override
    public void promptUnmodifiableCell() {
        System.out.println("\nCannot modify that cell!");
    }

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

    @Override
    public void promptGameWon(Integer points) {
        System.out.println("You have won in " + points + " moves!");
    }
}
