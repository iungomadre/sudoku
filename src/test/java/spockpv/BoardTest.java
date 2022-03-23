package spockpv;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    final Character[][] initialBoardState = {
        { '0', '1' },
        { '2', '0' },
        { '1', '3' }
    };

    private final Board underTest = new Board(initialBoardState);

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
        Character[][] localBoardState = {
            { '2', '0' },
            { '3', '0' },
            { '4', '0' }
        };
        Board localUnderTest = new Board(localBoardState);

        Coordinates testedCoordinates = new Coordinates(0, 0);
        Character testedValue = 'x';

        assertThat(localUnderTest.getCellValue(testedCoordinates)).isNotEqualTo(testedValue);
        
        // when
        localUnderTest.setCellValue(testedValue, testedCoordinates);
        
        // then
        assertThat(localUnderTest.getCellValue(testedCoordinates)).isEqualTo(testedValue);
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
