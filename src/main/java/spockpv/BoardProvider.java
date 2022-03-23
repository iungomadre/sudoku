package spockpv;

/**
 * Represents board provider whose task is to provide already-built Board object
 * from whatever source it works with
 * 
 * @author  Filip Wiśniewski
 */
public interface BoardProvider {
  /**
   * Creates and returns new Board object with parameters specified by
   * derivative class
   * @return already-built board
   */
  public Board createBoard();
}
