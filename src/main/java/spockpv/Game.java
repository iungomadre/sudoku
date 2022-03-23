package spockpv;

public class Game {

    final Board initialBoard_;
    final Board currentBoard_;
    
    public Game(Board board) {
        currentBoard_ = board;
        initialBoard_ = (Board)board.clone();
    }

    public Board getCurrentBoard() {
        return currentBoard_;
    }

    public boolean isWon() {
        // game won if sum in every row and column is equal (1+...+n)
        
        Integer expectedRowSum = countSumN(currentBoard_.width());
        Integer expectedColumnSum = countSumN(currentBoard_.height());

        for (Integer rowSum : currentBoard_.countRowSums()) {
            if (rowSum != expectedRowSum) {
                return false;
            }
        }
        for (Integer columnSum : currentBoard_.countColumnSums()) {
            if (columnSum != expectedColumnSum) {
                return false;
            }
        }
        return true;
    }

    private Integer countSumN(Integer N) {
        Integer sum = 0;
        for (Integer i = 1; i <= N; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public boolean tryPutValue(Coordinates coordinates, Character value) {
        if (initialBoard_.getCellValue(coordinates) != '0') {
            return false;
        }
        currentBoard_.setCellValue(value, coordinates);
        return true;
    }
}
