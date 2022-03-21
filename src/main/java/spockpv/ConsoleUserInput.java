package spockpv;

import java.util.Scanner;

public class ConsoleUserInput implements UserInput {

    Scanner scanInput = new Scanner(System.in);
    
    @Override
    public Coordinates getCoords() {
        System.out.println("Please insert coordinates:\nx: ");
        Integer x = Integer.parseInt(scanInput.nextLine());
        System.out.println("\ny: ");
        Integer y = Integer.parseInt(scanInput.nextLine());
        return new Coordinates(x, y);
    }

    @Override
    public Integer getValue() {
        System.out.println("Please insert value:\nx: ");
        Integer value = Integer.parseInt(scanInput.nextLine());
        return value;
    }
}
