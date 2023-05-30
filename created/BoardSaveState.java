package created;

import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

public class BoardSaveState {
    Board board;
    List<Piece> pieces;
    List<Position> fields = new ArrayList<>();
    public BoardSaveState(Board board, List<Piece> pieces, List<Position> fields) {
        this.board = board;
        this.pieces = pieces;
        this.fields = fields;
    }
    public void restoreBoard() {
        board.setFields(fields);
        board.setPieces(pieces);
    }
}
