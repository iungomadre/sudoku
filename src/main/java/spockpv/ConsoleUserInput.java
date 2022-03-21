package spockpv;

import java.util.Scanner;

public class ConsoleUserInput implements UserInput {

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
}
