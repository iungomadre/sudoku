package spockpv;

public interface UserInterface {
    public Coordinates getCoords();
    public Character getValue();
    public void draw(Board board);
    public void promptUnmodifiableCell() ;
}