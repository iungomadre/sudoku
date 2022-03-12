package spockpv;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CoordinatesTest {
    @Test
    public void testEquals() {
        // given
        Coordinates first = new Coordinates(1, 2);
        Coordinates second = new Coordinates(1, 2);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void testX() {
        // given
        Coordinates coordinate = new Coordinates(1, 2);

        // when
        Integer actual = coordinate.x();
        Integer expected = 1;

        // then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testY() {
        // given
        Coordinates coordinate = new Coordinates(1, 2);

        // when
        Integer actual = coordinate.y();
        Integer expected = 2;

        // then
        assertThat(expected).isEqualTo(actual);
    }
}
