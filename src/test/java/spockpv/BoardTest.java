package spockpv;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    // Mock board reader (simulates reading bord from source)
    private BoardReader reader = new BoardReader() {
        public Integer[][] readBoard() {
            Integer[][] mockBoard = {
                    { 0, 1 },
                    { 2, 0 }
            };
            return mockBoard;
        };
    };
    private final Board underTest = new Board(reader);

    @Test
    public void testGetCellValue() {
        assertThat(underTest.getCellValue(new Coordinates(0, 0))).isEqualTo(reader.readBoard()[0][0]);
        assertThat(underTest.getCellValue(new Coordinates(0, 1))).isEqualTo(reader.readBoard()[0][1]);
        assertThat(underTest.getCellValue(new Coordinates(1, 0))).isEqualTo(reader.readBoard()[1][0]);
        assertThat(underTest.getCellValue(new Coordinates(1, 1))).isEqualTo(reader.readBoard()[1][1]);
    }

    @Test
    public void testIsCellModifiable() {
        assertThat(underTest.isCellModifiable(new Coordinates(0, 0))).isTrue();
    }

    @Test
    public void testIsNotCellModifiable() {
        assertThat(underTest.isCellModifiable(new Coordinates(1, 0))).isFalse();
    }

    @Test
    public void testSetCellValue() {
        Coordinates at = new Coordinates(0, 0);
        Board modifiableBoard = new Board(reader);
        assertThat(modifiableBoard.getCellValue(at)).isEqualTo(0);
        modifiableBoard.setCellValue(4, at);
        assertThat(modifiableBoard.getCellValue(at)).isEqualTo(4);
    }
}
