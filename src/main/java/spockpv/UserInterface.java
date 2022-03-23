package spockpv;

/**
 * Class reresenting user interdace. Has to implement all following methods in
 * order for game to work properly.
 *
 * @author  Filip Wiśniewski
 */
public interface UserInterface {
  /**
   * Gets coordinates from user
   * @return coordinates provided by user input
   */
  public Coordinates
  getCoords(); // TODO user interface probably should not create objects, just
               // return input replace with getX, getY

  /**
   * Gets character from user
   * @return character provided by user input
   */
  public Character getValue();

  /**
   * Draws game board
   * @param board
   */
  public void draw(Board board);

  /**
   * Informs user that cell cannot be mofified
   */
  public void promptUnmodifiableCell();

  /**
   * Tells user that they won. Also prints number of points collected
   * @param points
   */
  public void promptGameWon(Integer points);
}