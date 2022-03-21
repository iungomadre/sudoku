package spockpv;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private final BoardProvider provider = new MockBoardProvider();
    private final Board underTest = provider.createBoard();

    @Test
    public void testGetCellValue() {
        assertThat(underTest.getCellValue(new Coordinates(0, 0))).isEqualTo('0');
        assertThat(underTest.getCellValue(new Coordinates(1, 0))).isEqualTo('2');
        assertThat(underTest.getCellValue(new Coordinates(0, 1))).isEqualTo('1');
        assertThat(underTest.getCellValue(new Coordinates(1, 1))).isEqualTo('0');
    }

    @Test
    public void testSetCellValue() {
        // given
        Coordinates coords = new Coordinates(0, 0);
        Board localUnderTest = provider.createBoard();
        
        // when
        localUnderTest.setCellValue('4', coords);
        
        // then
        assertThat(localUnderTest.getCellValue(coords)).isEqualTo('4');
    }

    @Test
    public void testWidth() {
        // given
        Integer expected = 3;

        // when
        Integer actual = underTest.width();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testHeight() {
        // given
        Integer expected = 2;

        // when
        Integer actual = underTest.height();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
