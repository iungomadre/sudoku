package spockpv;

import org.junit.Test;
import static org.junit.Assert.assertNotSame;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    final Character[][] initialBoardState = {
        { '0', '1' },
        { '2', '0' },
        { '1', '3' }
    };
    final Character[][] differentInitialBoardState = {
        { 'x', 'y' },
        { 'x', 'y' },
        { 'x', 'y' }
    };

    private final Board underTest = new Board(initialBoardState);
    private final Board differentUnderTest = new Board(differentInitialBoardState);

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

    @Test
    public void testIsEqual() {
        // given
        Board first = new Board(initialBoardState);
        Board second = new Board(initialBoardState);

        // then
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void testIsNotEqual() {
        assertThat(underTest).isNotEqualTo(differentUnderTest);
    }

    @Test
    public void testIsEqualSameObject() {
        assertThat(underTest).isEqualTo(underTest);
    }

    @Test
    public void testIsNotEqualDifferentObject() {
        // given 
        Integer notBoard = 2;

        // then
        assertThat(underTest).isNotEqualTo(notBoard);
    }

    @Test
    public void testCloneIsNotSame() {
        // given
        Board clone = (Board)underTest.clone();

        // then
        assertNotSame(underTest, clone);
    }

    @Test
    public void testCloneEquals() {
        // given
        Board clone = (Board)underTest.clone();

        // then
        assertThat(underTest).isEqualTo(clone);
    }
}
